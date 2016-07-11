package com.refrence.javacore;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ipLocalHost {

	public static void main(String[] args) {

		try {
			InetAddress inet = InetAddress.getLocalHost();
			InetAddress[] ips = InetAddress.getAllByName(inet.getHostName());
			System.out.println(ips[1].toString().split("/")[1]);
		} catch (UnknownHostException e) {

		}
	}

}
