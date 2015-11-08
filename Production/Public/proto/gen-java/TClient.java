package com.chd;

import com.chd.proto.AllocObjResult;
import com.chd.proto.CloudHardDiskService;
import com.chd.proto.Errcode;
import com.chd.proto.FTYPE;
import com.chd.proto.LoginResult;
import com.chd.proto.RetHead;
import com.chd.proto.mLoginResult;

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
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TClient {

    private  static BasicHttpParams params;
    private ThreadSafeClientConnManager tscm;
    private  static CloudHardDiskService.Client mclient=null;
    private  static 	 TClient instacne=null;
    private  final String defaulturl="http://211.155.225.74:8888/chdserver.php";
    private  static Set<URLBean> servletUrl=null;
    private static String token;

    class URLBean
    {
        private String url;
        private int available;
        public  URLBean(String url1)
        {
            setUrl(url1);
            setAvailable(10);
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url1) {
            this.url = url;
        }


        public int getAvailable() {
            return available;
        }

        public void setAvailable(int available) {
            this.available = available;
        }
    }


    private String getServerUrl()
    {
        Iterator<URLBean> iterator= servletUrl.iterator();
        URLBean item0=null;
        String url=null;
        int mmax= Integer.MIN_VALUE;
        while (iterator.hasNext())
        {
            item0=iterator.next();
            if (mmax<item0.getAvailable())
            {
                mmax=item0.getAvailable();
                url=item0.getUrl();
            }
        }
        if (url==null)
            return defaulturl;
        return url;
    }

    public void addurl(String[] urls)
    {
        //if (servletUrl==null)
        //    servletUrl=new HashSet<URLBean>();
        for(String url:urls)
        {
            servletUrl.add(new URLBean(url));
        }

    }

    public static TClient getinstance() throws Exception
    {
        if (instacne==null) {
            servletUrl=new HashSet<>();
            instacne = new TClient();

        }
        return instacne;
    }

    private TClient() throws Exception {
        BasicHttpParams params= new BasicHttpParams();
        params.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        params.setParameter("http.protocol.content-charset", "UTF-8");
        params.setParameter("http.protocol.expect-continue", false);
        params.setParameter("http.connection.stalecheck", true);
        HttpConnectionParams.setSoTimeout(params, 10000); // 10 secondes
        HttpConnectionParams.setConnectionTimeout(params, 10000); // 10 secondes
        //Configuration.
        ConnManagerParams.setMaxTotalConnections(params, 2);
        ConnPerRouteBean connPerRoute = new ConnPerRouteBean(20);
        ConnManagerParams.setMaxConnectionsPerRoute(params, connPerRoute);
//
        // Registry registry=new Registry();
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 8080));
//
        tscm = new ThreadSafeClientConnManager(params, schemeRegistry);

        String servletUrl = getServerUrl();

        THttpClient thc= new THttpClient(servletUrl, new DefaultHttpClient(tscm, params));

        TProtocol loPFactory = new TBinaryProtocol(thc);
        mclient = new CloudHardDiskService.Client(loPFactory);
    }




    public mLoginResult loginAuth0(String username, String password, int salt) throws Exception {
        String uname = "hzshark";
        String pwd = "aerohive";
        int s = 1;
        LoginResult lg=mclient.loginAuth(uname,pwd,s);
        if (lg.isSetToken())
            token=lg.getToken();
        return  new mLoginResult(mclient.loginAuth(uname,pwd,s));
    }

    public LoginResult loginAuth(String username, String password, int salt) throws Exception {
        String uname = "hzshark";
        String pwd = "aerohive";
        int s = 1;
        LoginResult lg=mclient.loginAuth(uname,pwd,s);
        if (lg.isSetToken())
            token=lg.getToken();
        return  lg;
    }


    public void uploadImage(File file)
    {
        boolean ret= uploadBigFile(file,FTYPE.SMS);
    }

    public void uploadMusic(File file)
    {
        boolean ret= uploadBigFile(file,FTYPE.SMS);
    }

    public void uploadSms(File file)
    {
        boolean ret= uploadBigFile(file,FTYPE.SMS);
    }

    public void uploadAddressbook(File file)
    {
        boolean ret= uploadBigFile(file,FTYPE.ADDRESS);
    }

    protected boolean uploadBigFile(File bitmap,FTYPE ftype)
    {
            /*
            TO DO
            * */
        return true;
    }

    protected boolean downloadBigfile()
    {
        return true;
    }

    public List<?> queryfile(FTYPE ftype)
    {
        return  new ArrayList<>();
    }

    private String  AllocObj(FTYPE ftype,String fname) throws TException
    {

            AllocObjResult aret=mclient.allocobj(token, ftype, fname);
            if (aret.getResult().getRet()== Errcode.SUCCESS)
            {
                return  aret.getResourceid();

            }

        return  null;
    }

    private void  AppendObj(String objid,ByteBuffer bins) throws Exception
    {


        RetHead ret=mclient.appendObj(token,objid,bins);
        if (ret.getRet()!= Errcode.SUCCESS)
        {
            throw  new Exception("append remote obj failed ");
        }

    }

    // 该类是对外开放的,用来实现通讯录之类的 逐条备份
    public class TFilebuilder {

        private String obj=null;
        ByteBuffer bin= null;

        public TFilebuilder(String fname,FTYPE ftype) throws Exception
        {
            String obj=AllocObj(ftype,fname);
            if (obj==null)
                throw new Exception("alloc stroge obj fail");
        }

        public void   Append(byte[] bytes) throws Exception {
            bin= ByteBuffer.wrap(bytes);
            AppendObj(obj, bin);
            bin.clear();
        }




    }

}
