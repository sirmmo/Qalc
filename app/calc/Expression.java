package calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import calc.operations.Operation;

public class Expression {


	//stateless expression evaluator
	public static double evaluate(double _value, String op, Double value) {
		Operation o;
		try {
			o = Operation.GetOperationForSymbol(op);
			return o.evaluate(_value, value);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	
}
