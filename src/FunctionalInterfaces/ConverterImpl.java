package FunctionalInterfaces;

public class ConverterImpl {

	public void printConvertedValue(ConverterFI converter) {
		converter.convert("34221");
	}
	
	public static void main(String[] args) {
		
		/*As seen here, lambda expressions are used to pass behavior of Converter Functional Interface without having to explicitly implement the interface.
		 * This is because the mapping from the lambda expression is done implicitly to the single method defined in the functional interface.*/  
		ConverterFI converter1 = ((name) -> {
			System.out.println("Converting from string to integer gives "+Integer.valueOf(name));
		});
		
		converter1.convert("434");
		converter1.convert("4324.3213");

		ConverterImpl converter2 = new ConverterImpl();
		converter2.printConvertedValue(converter1);
		
		/*Alternatively you can also pass the entire lambda expression to the printConvertedValue() method.
		 * This is called behavior parameterization i.e. passing of behavior as parameter. */ 

	}
	
}
