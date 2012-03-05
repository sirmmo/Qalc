package calc.operations;

import calc.Expression;


public class SubtractionOperator extends Operation{

	public SubtractionOperator(){
		super("-", 0,OperatorAssociativity.Left);
	}

	@Override
	public Double evaluate(Double oldval, Double val) {
		return oldval - val;
	}
}
