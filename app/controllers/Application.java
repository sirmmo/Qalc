package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.StatusCode;

import java.util.*;

import calc.Expression;
import calc.operations.Operation;

import models.*;

public class Application extends Controller {

	//static index renderer
	public static void index() {
		render();
	}

	//real "calculator"
	public static void doCalc(Double value, String op) {
		if (value != null){
			double _value = Double.parseDouble(session.get("value"));

			_value = Expression.evaluate(_value, op, value);
			session.put("value", _value);
			renderJSON(_value);
		} else {
			response.status = StatusCode.BAD_REQUEST;
			renderText("ERROR");
		}
	}

	//session status
	public static void status() {
		double _value;
		try {
			_value = Double.parseDouble(session.get("value"));
		} catch (Exception e) {
			session.put("value", 0);
			_value = 0;
		}
		try {
			renderJSON(_value);
		} catch (Exception e) {
			clear();
			renderJSON(_value);
		}
	}

	//restart with a new session
	public static void clear() {
		session.put("value", 0);
	}
	
	//gets the operator list
	public static void getOps(){
		renderJSON(Operation.getOps());
	}

}