package models;

import javax.persistence.*;
import com.avaje.ebean.Query;

import java.util.*;
import javax.persistence.*;
import javax.validation.*;
import com.avaje.ebean.*;
import play.db.ebean.*;
import play.data.validation.*;
import com.avaje.ebean.Query;
import com.avaje.ebean.annotation.CreatedTimestamp;

@Entity
public class ThanksCard extends Model {

	@Id
	public Long thanks_id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="send_dep")
	public Department send_dep;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="send_id")
	public Employee send_id;

	@CreatedTimestamp
	public Date send_date;

	public Date help_date;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="helpcate_id")
	public HelpCategory helpcate_id;

	public String help_said;

	public String thanks_message;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="receive_dep")
	public Department receive_dep;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="receive_id")
	public Employee receive_id;


    public static Finder<Long, ThanksCard> find = new Finder<Long,ThanksCard>(
    		Long.class, ThanksCard.class
        );

}