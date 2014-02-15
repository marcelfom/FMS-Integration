package controllers;


import play.mvc.Controller;
import play.mvc.Result;
import views.html.AdminPage;

public class AdminController extends Controller {

    public static Result get(){
        return render();
    }

    public static Result render(){
        return ok(AdminPage.render());
    }
}
