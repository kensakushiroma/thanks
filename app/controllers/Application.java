package controllers;

import play.*;



import models.*;
import play.data.*;
import views.html.*;
import java.util.List;
import java.util.Map;
import play.mvc.*;

public class Application extends Controller {

	public static Result index() {

        List<Department> department = Department.find.all();
        List<Employee> employee = Employee.find.all();
        List<HelpCategory> helpcategory = HelpCategory.find.all();

        return ok(index.render(department,employee,helpcategory));
	}

	public static Result bord() {

        List<ThanksCard> thankscard = ThanksCard.find.all();
        List<Department> department = Department.find.all();
        List<Employee> employee = Employee.find.all();
        List<HelpCategory> helpcategory = HelpCategory.find.all();

        return ok(bord.render(department,employee,helpcategory,thankscard));
	}

    public static Result addThanks() {

    	Form<ThanksCard> form = new Form(ThanksCard.class).bindFromRequest();

    	 Map<String, String[]> params = request().body().asFormUrlEncoded();

    	if (!form.hasErrors()) {
    		ThanksCard data = form.get();

    		long send_dep = Long.parseLong(params.get("send_dep_id")[0]);
    		data.send_dep = Department.find.byId(send_dep);

    		long send_id = Long.parseLong(params.get("send_emp_id")[0]);
    		data.send_id = Employee.find.byId(send_id);

    		long helpcate_id = Long.parseLong(params.get("helpcates_id")[0]);
    		data.helpcate_id = HelpCategory.find.byId(helpcate_id);

    		long receive_dep = Long.parseLong(params.get("receive_dep_id")[0]);
    		data.receive_dep = Department.find.byId(receive_dep);

    		long receive_id = Long.parseLong(params.get("receive_emp_id")[0]);
    		data.receive_id = Employee.find.byId(receive_id);

    		data.save();
    		return redirect("/");

    	} else {
    		//return badRequest(add.render("ERROR",form));
    	}

        return redirect(routes.Application.index());
    }

    public static Result find() {
    	Form<ThanksCard> form = new Form(ThanksCard.class).bindFromRequest();

    	Map<String, String[]> params = request().body().asFormUrlEncoded();

    	//List<ThanksCard> thankscard = ThanksCard.find.all();

    	if (!form.hasErrors()) {

    		List<Department> department = Department.find.all();
    		List<Employee> employee = Employee.find.all();
    		List<HelpCategory> helpcategory = HelpCategory.find.all();

    		ThanksCard data = form.get();

    		long send_dep = Long.parseLong(params.get("send_dep_id")[0]);
    		Department dep_id = Department.find.byId(send_dep);
    		List<ThanksCard> thankscard = ThanksCard.find.where().eq("send_dep", dep_id).findList();

    		long send_id = Long.parseLong(params.get("send_emp_id")[0]);
    		Employee emp_id = Employee.find.byId(send_id);
    		thankscard = ThanksCard.find.where().eq("send_id", emp_id).findList();


    		return ok(bord.render(department,employee,helpcategory,thankscard));

    	} else {
    		//return badRequest(add.render("ERROR",form));
    	}
    	return redirect(routes.Application.index());
    }
}
