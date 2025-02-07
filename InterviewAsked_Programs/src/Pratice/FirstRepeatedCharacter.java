package Pratice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstRepeatedCharacter {

	public void withoutCollection(String input) {
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					System.out.println("The First Repeated Character is '" + input.charAt(i) + "'");
					return;
				}
			}
		}
	}

	public void withCollectionMap(String input) {

		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (map.containsKey(input.charAt(i))) {
				map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
			} else {
				map.put(input.charAt(i), 1);
			}
		}
		System.out.println(map);
	

		Set<Character> mapkeys = map.keySet();
		for (Character key : mapkeys) {
			if (map.get(key) > 1) {
				System.out.println("The First Repeated Character is '" + key + "'");
				return;
			}
		}
	}

	public void withCollection(String input) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			if (map.containsKey(currentChar)) {
				System.out.println("The First Repeated Character is '" + currentChar + "'");
				return; // Return when the first repeated character is found
			} else {
				map.put(currentChar, 1);
			}
		}
		System.out.println("No repeated character found using Map Collection.");
	}
	

	public static void main(String[] args) {

		String input = "welcome to practice lab";

		FirstRepeatedCharacter firstRepeatedCharacter = new FirstRepeatedCharacter();
		firstRepeatedCharacter.withoutCollection(input);
		System.out.println("----------------------------------------------");
		firstRepeatedCharacter.withCollectionMap(input);
		System.out.println("----------------------------------------------");
		firstRepeatedCharacter.withCollection(input);

	}
}
