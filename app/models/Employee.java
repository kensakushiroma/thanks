package models;

import javax.persistence.*;



import javax.persistence.Id;
import play.db.ebean.Model;
import javax.validation.*;
import play.data.validation.*;
import javax.persistence.*;
import models.*;
import java.util.*;

@Entity
public class Employee extends Model {
    @Id
	public Long emp_id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dep_id")
	public Department dep_id;

	public String emp_name;

	public String password;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="auth_id")
	public Authority auth_id;

    public static Finder<Long, Employee> find = new Finder<Long,Employee>(
    		Long.class, Employee.class
        );

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "send_id")
    public List<ThanksCard> send = new ArrayList<ThanksCard>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receive_id")
    public List<ThanksCard> receive = new ArrayList<ThanksCard>();



   // public List<ThanksCard> thankscards = new ArrayList<ThanksCard>();

    public static Boolean authenticate(Long emp_id, String password) {
    	Employee employee = find.where().eq("emp_id", emp_id).findUnique();
        return (employee != null && employee.password.equals(password));
    }

    public static Employee findById(Long input){
   	return Employee.find.where().eq("emp_id", input).findList().get(0);
    }

	public static Employee findByName(String input){
		return Employee.find.where().eq("emp_name", input).findList().get(0);
	}
}