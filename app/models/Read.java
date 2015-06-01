package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Read extends Model {

	@Id
	public Integer read_id;
	public String read_name;
}
