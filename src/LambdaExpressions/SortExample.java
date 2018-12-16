package LambdaExpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Ellen", "Ava", "Mary", "Anna", "Mike");
		System.out.println("Original list: "+names);
		
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		
		System.out.println("Sorted list: "+names);
	}
	
}
