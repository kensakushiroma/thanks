package controllers;

import models.*;
import play.mvc.*;
import play.data.Form;
import views.html.authentication.*;
import java.util.*;

public class Authentication extends Controller {

	//ログイン認証
	public static class Login {
        public Long emp_id;
        public String password;


        public String validate() {
            if (authenticate(emp_id, password)) {
                return null;
            }
            return "Invalid userid and password";
        }

        //ユーザとパスワードの比較
        private Boolean authenticate(Long emp_id, String password) {
        	return Employee.authenticate(emp_id, password);
        }
    }
	//よくわからない

    public static Form<Login> loginForm = Form.form(Login.class);

    public static Result index() {

    	if (session("login") != null) {
           //return ok("あなたは既に " + session("login") + "としてログインしています");
    		return redirect(routes.Authentication.authenticate());
        }
        return ok(index.render(loginForm));
    }

    public static Result authenticate() {
    	Form<Login> form = loginForm.bindFromRequest();
    	Map<String, String[]> params = request().body().asFormUrlEncoded();

    	//List<ThanksCard> thankscard = ThanksCard.find.all();


    	if (form.hasErrors()) {
            return badRequest(index.render(form));
        } else {
        	Login login = form.get();

    	   long login_id = Long.parseLong(params.get("emp_id")[0]);
    		Employee id = Employee.find.byId(login_id);

    		List<ThanksCard> thankscard = ThanksCard.find.where().eq("receive_id", id).findList();

            session("login", id.emp_name);

            return ok(main.render(id.emp_name,thankscard));
        }

    }

    public static Result main(){
    	session();
            return redirect(routes.Authentication.index());

    }

//ログアウト処理
    public static Result logout() {
        session().clear();
        return redirect(routes.Authentication.index());
    }
}