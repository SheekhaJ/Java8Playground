package DefaultMethods;

public class FormulaImpl implements Formula{

	public static void main(String[] args) {
		FormulaImpl formulaImpl = new FormulaImpl();
		
		int a  = 90;
		
		formulaImpl.calculate(a);
		formulaImpl.sqrt(a);
	}

	@Override
	public double calculate(int a) {
		System.out.println("Implementation of calculate in FormulaImpl");
		return 0;
	}
	
}
