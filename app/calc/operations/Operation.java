package calc.operations;

import java.util.HashMap;
import java.util.Set;

import calc.Expression;

public abstract class Operation {

	{
		Operation.prepare();
	}

	public abstract Double evaluate(Double oldval, Double val);

	private String symbol;
	private int priority;
	private OperatorAssociativity associativity;

	protected Operation(String symbol, int priority,
			OperatorAssociativity associativity) {
		this.symbol = symbol;
		this.priority = priority;
		this.associativity = associativity;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getPriority() {
		return priority;
	}

	public OperatorAssociativity getAssociativity() {
		return associativity;
	}

	private static HashMap<String, Class> ops = new HashMap<String, Class>();

	private static void prepare() {
		ops.put("*", MultiplicationOperation.class);
		ops.put("-", SubtractionOperator.class);
		ops.put("+", AdditionOperation.class);
		ops.put("/", DivisionOperation.class);
	}

	private static void clear(){
		ops = new HashMap<String, Class>();
	}
	public static void AddOperation(String symbol, Class operation) {
		ops.put(symbol, operation);
	}

	public static Operation GetOperationForSymbol(String symbol)
			throws Exception {
		Operation.prepare();
		if (ops.containsKey(symbol)) {
			Class c = ops.get(symbol);

			Operation.clear();
			return (Operation) c.newInstance();
		} else
			Operation.clear();
			return null;

	}
	//enables the automatic creation of buttons
	public static Set<String> getOps(){
		prepare();
		return ops.keySet();
	}

}
