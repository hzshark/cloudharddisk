package com.chd;

import com.chd.proto.CloudHardDiskService;
import com.chd.proto.loginResult;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransportException;

import org.apache.http.HttpVersion;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;






public class TClient {

    private  static BasicHttpParams params;
    private  ThreadSafeClientConnManager tscm;
    private  static CloudHardDiskService.Client tclient;
    private  static 	 TClient instacne=null;


    public TClient getinstance() throws TTransportException
    {
        if (instacne==null)
            instacne=new TClient();
        return instacne;
    }

    public TClient() throws TTransportException {
        BasicHttpParams params= new BasicHttpParams();
        params.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        params.setParameter("http.protocol.content-charset", "UTF-8");
//		 // Disable Expect-Continue
        params.setParameter("http.protocol.expect-continue", false);
//		 // Enable staleness check
        params.setParameter("http.connection.stalecheck", true);
        HttpConnectionParams.setSoTimeout(params, 10000); // 10 secondes
        HttpConnectionParams.setConnectionTimeout(params, 10000); // 10 secondes
        ConnManagerParams.setMaxTotalConnections(params, 2);
        ConnPerRouteBean connPerRoute = new ConnPerRouteBean(20);
        ConnManagerParams.setMaxConnectionsPerRoute(params, connPerRoute);
//
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 8080));
//
        tscm = new ThreadSafeClientConnManager(params, schemeRegistry);
//
        String servletUrl = "http://211.155.225.74:8888/chdserver.php";
//
        THttpClient thc= new THttpClient(servletUrl, new DefaultHttpClient(tscm, params));

        TProtocol loPFactory = new TBinaryProtocol(thc);
        tclient = new CloudHardDiskService.Client(loPFactory);
    }

    public loginResult loginAuth(String username, String password, int salt) throws TException {
        String uname = "hzshark";
        String pwd = "aerohive";
        int s = 1;
        return  tclient.loginAuth(uname,pwd,s);
    }

}
