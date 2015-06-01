package models;

import play.db.ebean.Model;

import javax.persistence.*;
import javax.persistence.Id;
import play.db.ebean.Model;
import javax.validation.*;
import play.data.validation.*;
import javax.persistence.*;
import models.*;
import java.util.*;

@Entity
public class Authority extends Model {

	@Id
	public Long auth_id;
	public String auth_name;

	   @OneToMany(cascade = CascadeType.ALL, mappedBy = "auth_id")
	    public List<Employee> employees = new ArrayList<Employee>();

	  public static Finder<Long, Department> find = new Finder<Long,Department>(
			  Long.class, Department.class
	  );
}
