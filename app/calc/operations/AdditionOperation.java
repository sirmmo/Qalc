package calc.operations;

import calc.Expression;

public class AdditionOperation extends Operation{

	
	
	public AdditionOperation() {
		super("+", 0,OperatorAssociativity.Left);
	}

	@Override
	public Double evaluate(Double oldval, Double val) {
		return oldval + val;
	}

}
