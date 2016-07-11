package com.refrence.javacore;

import java.util.Arrays;

public class stringWork {

	public static void main(String[] args) {

		// char[] to string
		char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
		System.out.println("charArray: " + helloArray.length);
		String helloString = new String(helloArray); // char to string
		
		System.out.println("arrayNewString: " + helloString);

		// String to Char
		String sample = "hello world";
		char arraysample[] = sample.toCharArray();
		System.out.println("LengthArray: "+ arraysample.length);
		System.out.println("arrayAt: " + arraysample[10]);
		System.out.println("array: " + new String(arraysample));
		System.out.println("Difference array: " + Arrays.toString(arraysample));
		
		// String length
		String palindrome = "  1 3 5 7#9  ";
		int len = palindrome.length();
		
		System.out.println("String Length is : " + len);
		System.out.println("Hashcode is : " + palindrome.hashCode());
		
		// Trim leading and trailing whitespace ommitted
		System.out.println("Trim is : " + palindrome.trim());
		System.out.println("Trim.length is : " + palindrome.trim().length());

	}

}
