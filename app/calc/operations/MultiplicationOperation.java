package calc.operations;

import calc.Expression;

public class MultiplicationOperation extends Operation{


	public MultiplicationOperation() {

		super("*", 100,OperatorAssociativity.Left);
	}
	@Override
	public Double evaluate(Double oldval, Double val) {
		return oldval * val;
	}

}
