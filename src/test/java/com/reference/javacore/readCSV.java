package com.reference.javacore;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class readCSV {

	public static void main(String[] args) throws IOException {
		File file = new File("src/test/java/resources/testdata.csv");

		File check = new File("src/test/java/resources/writerLIST.csv");
		if(check.exists()){check.delete();}
		
		FileWriter writer = new FileWriter("src/test/java/resources/writerLIST.csv");

		// Way 1:
		FileReader fr = new FileReader(file);
		LineNumberReader lnr = new LineNumberReader(fr);
		lnr.setLineNumber(0);

		String line = "";
		while ((line = lnr.readLine()) != null) {
			System.out.println("Line Number " + lnr.getLineNumber() + " : " + line);

		}
		fr.close();
		System.out.println("-------------------------1---------------------------");

		// Way 2:
		List<String> stringLine = FileUtils.readLines(file);
		for (String S : stringLine) {
			System.out.println(S);
		}
		System.out.println("-------------------------2---------------------------");

		// Way 3:
		Scanner s = new Scanner(file);
		ArrayList<String> list = new ArrayList<String>();

		while (s.hasNext()) {
			list.add(s.next());
		}
		s.close();

		for (String l : list) {
			System.out.println(l);
		}
		System.out.println("-------------------------3---------------------------");

		// Read from START_LINE to TO_LINE
		List<String> stringLines = FileUtils.readLines(file);
		
		// A
		String lineList = "";
		for (int i = 4; i < stringLines.size(); i++) {
			lineList = stringLines.get(i);
			System.out.println(lineList);
		}
		System.out.println("-------------------------4---------------------------");
		System.out.println(lineList); // chi lay gia tri cuoi dc gan vao
		System.out.println("-------------------------5---------------------------");
		
		// B
		List<String> fromStartLine = new ArrayList<String>();
		for (int j = 4; j < stringLines.size(); j++) {
			fromStartLine.add(stringLines.get(j));
		}
		System.out.println(fromStartLine);

		// Write file
		for (String wr : fromStartLine) {
			writer.write(wr + "\n");
		}
		writer.close();
	}

}
