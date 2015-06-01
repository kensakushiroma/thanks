package models;

import javax.persistence.Id;
import play.db.ebean.Model;
import javax.validation.*;
import play.data.validation.*;
import javax.persistence.*;
import models.*;
import java.util.*;

@Entity
public class HelpCategory extends Model {

	@Id
	public Long helpcate_id;
	public String helpcate_name;

    public static Finder<Long,HelpCategory> find = new Finder<Long,HelpCategory>(
    		Long.class, HelpCategory.class
        );

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "helpcate_id")
    public List<ThanksCard> thankscards = new ArrayList<ThanksCard>();

    public static HelpCategory findById(Long input){
   	return HelpCategory.find.where().eq("helpcate_id", input).findList().get(0);
    }

}
