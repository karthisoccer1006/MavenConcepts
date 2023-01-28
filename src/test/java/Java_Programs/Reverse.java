package Java_Programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Reverse {

	public static void reverseString() {
		String s = "greens12345@mail.com";

		char[] charArray = s.toCharArray();
		for (int i = charArray.length - 1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
		System.out.println();

	}

	public static void palindrome() {
		String s = "malayalam";
		String reverseString = "";

		char[] charArray = s.toCharArray();
		for (int i = charArray.length - 1; i >= 0; i--) {
			reverseString = reverseString + charArray[i];

		}
		if (s.equalsIgnoreCase(reverseString)) {
			System.out.println("palindrome");
		} else {
			System.out.println("not a palindrome");
		}
		System.out.println(reverseString);
	}

	public static void wordReverse() {
		String s = "welcome to greens";
		String[] split = s.split(" ");
		for (String word : split) {
			// System.out.println(word);
			for (int i = word.length() - 1; i >= 0; i--) {
				System.out.print(word.charAt(i));
			}
			System.out.println();
		}
	}

	public static void charCount() {
		String s = "greens12345@gmil.com";
		char[] charArray = s.toCharArray();
		int alpha = 0;
		int num = 0;
		int spl = 0;

		for (char c : charArray) {
			if (Character.isAlphabetic(c)) {
				++alpha;
			} else if (Character.isDigit(c)) {
				++num;
			} else {
				++spl;
			}
		}
		System.out.println("number of alphabets is " + alpha);
		System.out.println("number of digits is " + num);
		System.out.println("number of special characer is " + spl);
		System.out.println("==================================================");

	}

	public static void alternateCount() {
		String s = "greens12345@gmil.com";

		int alphabets = s.replaceAll("[^a-z A-Z]", "").length();
		int numbers = s.replaceAll("[^0-9]", "").length();
		int spl = s.replaceAll("[a-z A-Z 0-9]", "").length();

		System.out.println(alphabets);
		System.out.println(numbers);
		System.out.println(spl);
	}

	public static void countUsingMap() {

		String s = "greens12345@gmil.com";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}

		}
		// System.out.println(map);
		System.out.println("==================================");
	}

	public static void wordCount() {
		String a = "welcome to java welcome to selenium";
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		String[] split = a.split(" ");

		for (String s : split) {
			if (map.containsKey(s)) {
				Integer count = map.get(s);
				count++;
				map.put(s, count);
			} else {
				map.put(s, 1);

			}

		}
		System.out.println(map);
		System.out.println("=================================");
	}

	public static void letterCount() {
		String a = "welcome to java welcome to selenium";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < a.length() - 1; i++) {
			char c = a.charAt(i);
			if (map.containsKey(c)) {
				Integer count = map.get(c);
				count++;
				map.put(c, count);
			} else {
				map.put(c, 1);
			}

		}
		System.out.println(map);
		System.out.println("=====================================");
	}

	public static void duplicateValue() {
		String a = "welcome to java welcome to selenium";
		Set<Character> set = new HashSet<Character>();
		String letters = a.replaceAll(" ", "");
		for (int i = 0; i < letters.length() - 1; i++) {
			char c = letters.charAt(i);
			set.add(c);
		}

		System.out.println(set);
	}

	public static void reversing() {
		String a = "Iam a java developer";
		String[] split = a.split(" ");
		for (int i = split.length - 1; i >= 0; i--) {
			System.out.print(split[i] + " ");

		}
		System.out.println();
	}

	public static void reverse1() {
		String a = "Iam a java developer";
		char[] c = a.toCharArray();
		for (int i = c.length - 1; i >= 0; i--) {
			System.out.print(c[i]);

		}
	}
	private void reverse2() {
		String a ="Iam a java developer";
		String[] split = a.split(" ");
		for (String s : split) {
			for(int i=s.length();i>0;i--) {
				System.out.print(s.charAt(i));
			}
			
		}
	}

	public static void main(String[] args) {
		reverseString();
		palindrome();
		wordReverse();
		charCount();
		alternateCount();
		countUsingMap();
		wordCount();
		letterCount();
		duplicateValue();
		reversing();
	

	}

}
