package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class FMSApp extends Controller {

    public static Result index() {
        return ok(index.render());
    }

}
