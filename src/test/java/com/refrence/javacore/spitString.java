package com.refrence.javacore;

public class spitString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String getText = "/ent/blog/gestion/visualisation/ba-con-ga-5";
		String [] pText = getText.split("/");
		System.out.println(pText[5]);
		
		String a = "I Am Boss";
		String [] arrayWord = a.split(" ");
		System.out.println(arrayWord[1]);
	}

}
