package Pratice;

import java.util.Arrays;
import java.util.List;

public class FilterStream {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("java", "springboot", "restapis", "sql", "angular");

		List<String> endResult = list.stream().map(str -> str.toUpperCase()).filter(str -> str.length() > 5).toList();
		System.out.println("EndResult In UpperCase and word character greater than 5 is :- "+endResult);

	}

}
