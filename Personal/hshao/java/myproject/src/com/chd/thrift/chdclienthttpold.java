package com.chd.thrift;

import org.apache.http.HttpVersion;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.thrift.TException;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.http.conn.scheme.Scheme;

import com.chd.proto.*;

public class chdclienthttpold {
	private static BasicHttpParams params;
	private static ThreadSafeClientConnManager tscm;


	public static void main(String[] args) throws TException {
		 // Set up Thrift HTTP client connection parameters
		 params = new BasicHttpParams();
		 params.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
		 params.setParameter("http.protocol.content-charset", "UTF-8");
		 // Disable Expect-Continue
		 params.setParameter("http.protocol.expect-continue", false);
		 // Enable staleness check
		 params.setParameter("http.connection.stalecheck", true);
		 HttpConnectionParams.setSoTimeout(params, 10000); // 10 secondes
		 HttpConnectionParams.setConnectionTimeout(params, 10000); // 10 secondes
		 ConnManagerParams.setMaxTotalConnections(params, 20);
		 ConnPerRouteBean connPerRoute = new ConnPerRouteBean(20);
		 ConnManagerParams.setMaxConnectionsPerRoute(params, connPerRoute);

		 SchemeRegistry schemeRegistry = new SchemeRegistry();
		 schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 8080));
		 
		 tscm = new ThreadSafeClientConnManager(params, schemeRegistry);
		 
		 String servletUrl = "http://10.155.30.170:8888/chdserver.php";

		THttpClient thc = new THttpClient(servletUrl, new DefaultHttpClient(tscm, params));
		TProtocol loPFactory = new TBinaryProtocol(thc);
		CloudHardDiskService.Client client = new CloudHardDiskService.Client(loPFactory);

		int sum = client.testsum(1, 2);
		//Assert.assertEquals("OK", bean.getStringObject());
		System.out.println("1+1="+sum);
	}
		
	

}
