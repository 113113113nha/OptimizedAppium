package com.refrence.javacore;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class httpResponse {

	public static void main(String[] args) throws IOException, ParserConfigurationException {

		System.out.println("Welcome Testing!!!");
		System.out.println("-----------------------------------------------");

		// Get connection
		URL url = new URL("http://testingpool.com/wp-content/uploads/2015/08/AlertHandles.html");
		URLConnection con = url.openConnection();

		// Case 1: ==============Get Html body response: UTF-8
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);
		System.out.println(body);

		
		
		// Case 2: ==============Get Html body response:
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod("http://testingpool.com/wp-content/uploads/2015/08/AlertHandles.html");

		client.executeMethod(method);

		if (method.getStatusCode() == HttpStatus.SC_OK) {
			InputStream methodRes = method.getResponseBodyAsStream();
			String response = IOUtils.toString(methodRes);
			System.out.println("Response = " + response);

			// Print doc
			Document doc = Jsoup.parse(response);
			System.out.println(doc);
			
			// Print Element
			Elements element = doc.select("input[id=btnConfirm]");
			System.out.println(element);

			// Print select element
			System.out.println(doc.select("input[value=Show prompt]"));
			
			// All Element = Jsoup-docs
			Elements elements = doc.getAllElements();
			System.out.println(elements);
			
		}
		
		
		

	}
}
