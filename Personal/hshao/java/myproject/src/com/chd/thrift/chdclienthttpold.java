package com.chd.thrift;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

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
		
		System.out.println("loginAuth************************");
		String username = "hzshark";
		String password = "aerohive";
		int salt = 1;
		loginResult login_ret = client.loginAuth(username, password, salt);
		System.out.println(login_ret.toString());
		System.out.println("loginAuthApp************************");
		String imie = "imie";
		salt = 2;
		loginResult loginapp_ret = client.loginAuthApp(imie, username, password, salt);
		System.out.println(loginapp_ret.toString());
		System.out.println("verificationLoginAuth************************");
		String authcode = "authcode";
		loginResult v_login_ret = client.verificationLoginAuth(username, password, authcode);
		System.out.println(v_login_ret.toString());
		System.out.println("queryFileList************************");
		String token = "token";
		FTYPE type = FTYPE.findByValue(1);
		queryResult files = client.queryFileList(token, type);
		System.out.println(files.toString());
		System.out.println("uploadFile************************");
		String upload_token = "test token";
		String filename = "test1.txt";
		long offerset = 0;
		UploadParam uploadparam = new UploadParam(upload_token, filename, offerset);
		uploaddResult upload_ret = client.uploadFile(uploadparam);
		System.out.println(upload_ret.toString());
		
		System.out.println("allocobj************************");
		String tagname = "tagname";type = FTYPE.findByValue(2);
		AllocObjResult aor = client.allocobj(token, type, tagname);
		System.out.println(aor.toString());
		
		System.out.println("appendObj************************");
		String oid = "oid";
		ByteBuffer bin = ByteBuffer.allocateDirect(1);
		RetHead aob = client.appendObj(token, oid, bin);
		System.out.println(aob.toString());
		
		System.out.println("appendObj************************");
		Map<String, String> odescr = new HashMap();
		odescr.put("test", "test val");
		RetHead cob = client.commitObj(token, oid, odescr);
		System.out.println(cob.toString());

	}
		
	

}
