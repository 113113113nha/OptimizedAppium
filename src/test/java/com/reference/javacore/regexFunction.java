package com.reference.javacore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class regexFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regexInput = "ksas6846jdhks   abaETREYO6-51 -31";

		// Regex
		Pattern patternVowel = Pattern.compile("([aAoOiIuUeE])");
		Pattern patternConsonant = Pattern.compile("([a-zA-Z&&[^aAoOiIuUeE]])");
		Pattern patternNumber = Pattern.compile("\\d");
		Pattern patternSpace = Pattern.compile("\\s");

		// Matcher in String
		Matcher matcherVowel = patternVowel.matcher(regexInput);
		Matcher matcherConsonant = patternConsonant.matcher(regexInput);
		Matcher matcherNumber = patternNumber.matcher(regexInput);
		Matcher matcherSpace = patternSpace.matcher(regexInput);

		Matcher matcherNegative = Pattern.compile("(-[0-9])").matcher(regexInput);

		// Count variable
		int countVowel = 0;
		int countConsonat = 0;
		int countNumber = 0;
		int countSpace = 0;
		int countNegative = 0;

		// Find matcher
		while (matcherVowel.find()) {
			countVowel++;
		}

		while (matcherConsonant.find()) {
			countConsonat++;
		}

		while (matcherNumber.find()) {
			countNumber++;
		}

		while (matcherSpace.find()) {
			countSpace++;
		}

		while (matcherNegative.find()) {
			countNegative++;
		}

		// Println
		System.out.println("Count Number: " + regexInput.replaceAll("\\D", "").length());

		System.out.println("Vowel:" + countVowel);
		System.out.println("Consonant:" + countConsonat);
		System.out.println("Number:" + countNumber);
		System.out.println("Space:" + countSpace);
		System.out.println("Negative:" + countNegative);
		
//		System.out.println(regexS.Matches(regexInput).get_Count());

	}

	// returns true if the string does not have a number at the beginning
	public boolean isNoNumberAtBeginning(String s) {
		return s.matches("^[^\\d].*");
	}

	// returns true if the string contains a arbitrary number of characters
	// except b
	public boolean isIntersection(String s) {
		return s.matches("([\\w&&[^b]])*");
	}

	// returns true if the string contains a number less then 300
	public boolean isLessThenThreeHundred(String s) {
		return s.matches("[^0-9]*[12]?[0-9]{1,2}[^0-9]*");

	}
}
