package com.reference.javacore;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class readIP {

	public static void main(String[] args) throws UnknownHostException, SocketException {

		// Case 1:
		System.out.println("-------------- Case 1 --------------");
		InetAddress IP = InetAddress.getLocalHost();
		System.out.println("IP of my system is: " + IP.getHostAddress());

		// Ext
		InetAddress inetAddr = InetAddress.getLocalHost();
		byte[] addr = inetAddr.getAddress();

		String ipAddr = "";
		for (int i = 0; i < addr.length; i++) {
			if (i > 0) {
				ipAddr += ".";
			}
			ipAddr += addr[i] & 0xFF;
		}

		String hostname = inetAddr.getHostName();
		System.out.println("IP Address: " + ipAddr);
		System.out.println("Hostname: " + hostname);

		// Case 2:
		System.out.println("-------------- Case 2 --------------");
		System.out.println(Inet4Address.getLocalHost().getHostAddress());
		System.out.println(Inet4Address.getLocalHost());
		System.out.println("Loopback:" + InetAddress.getLoopbackAddress());

		// Case 3:
		System.out.println("-------------- Case 3 --------------");
		try {
			InetAddress inet = InetAddress.getLocalHost();
			InetAddress[] ips = InetAddress.getAllByName(inet.getCanonicalHostName());
			if (ips != null) {
				for (int i = 0; i < ips.length; i++) {
					System.out.println(ips[i]);
				}
			}
		} catch (UnknownHostException e) {

		}

		// Case 4:
		System.out.println("-------------- Case 4 --------------");
		Enumeration<?> e = NetworkInterface.getNetworkInterfaces();
		while (e.hasMoreElements()) {
			NetworkInterface n = (NetworkInterface) e.nextElement();
			Enumeration<?> ee = n.getInetAddresses();
			while (ee.hasMoreElements()) {
				InetAddress i = (InetAddress) ee.nextElement();
				System.out.println(i.getHostAddress());
			}
		}
	}

}
