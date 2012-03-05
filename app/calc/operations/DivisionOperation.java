package calc.operations;

import calc.Expression;

public class DivisionOperation extends Operation{

	
	
	public DivisionOperation() {
		super("/", 100,OperatorAssociativity.Left);
	}

	@Override
	public Double evaluate(Double oldval, Double val) {
		return oldval / val;
	}
}
