package DefaultMethods;

public interface Formula {
	double calculate(int a);
	
	default double sqrt(int a) {
		System.out.println("Default implementation of sqrt from Formula interface");
		return Math.sqrt(a);
	}
}
