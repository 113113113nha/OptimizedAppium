package com.reference.javacore;

//import org.apache.commons.lang3.StringEscapeUtils;

import org.apache.commons.lang.StringEscapeUtils;

public class escapeHtml {

	public static void main(String[] args) {

		// 1 - String pattern
		String str = "<tag>text</tag>";		
		
		// 2 - Convert to escape
		String escapeString = StringEscapeUtils.escapeXml(str);

		// 3 - Convert to unescape
		String unescapeString = StringEscapeUtils.unescapeXml(escapeString);
		
		// 4 - Print
		System.out.println("Escapse String: "  + escapeString);
		System.out.println("Unescape String: " + unescapeString);
		
	}

}
