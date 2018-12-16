package LambdaExpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortExampleLambdaExpression {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Ellen", "Ava", "Mary", "Anna", "Mike");
		System.out.println("Original list: "+names);
		
		//Usage 1
		/*Collections.sort(names, (String a, String b) -> {
			return a.compareTo(b);
		});*/

		//Usage 2
		Collections.sort(names, (a, b) -> a.compareTo(b));
		
		System.out.println("Sorted list: "+names);
	}
	
}
