package com.chd.thrift;

import org.apache.thrift.transport.THttpClient;

public class chdclienthttp {

	public static void main(String[] args) {
		THttpClient sockt = new THttpClient("localhost", 8888, "/chdserver.php");
	}

}
