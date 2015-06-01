package models;

import play.db.ebean.*;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.*;
import play.data.validation.*;
import javax.persistence.*;
import models.*;

@Entity
public class Department extends Model {

	@Id
	public Long dep_id;
	public String dep_name;

    public static Finder<Long, Department> find = new Finder<Long,Department>(
    		Long.class, Department.class
        );

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "send_dep")
    public List<ThanksCard> send = new ArrayList<ThanksCard>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receive_dep")
    public List<ThanksCard> receive = new ArrayList<ThanksCard>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dep_id")
    public List<Employee> emp_dep = new ArrayList<Employee>();


    public static Department findById(Long input){
   	return Department.find.where().eq("dep_id", input).findList().get(0);
    }

}
