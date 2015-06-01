package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class New extends Model {

	@Id
	public Integer new_id;
	public String new_name;
}
