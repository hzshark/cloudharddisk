package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class testServer implements Runnable
{
    private final Socket m_socket;
    private final int m_num;

    public testServer( Socket socket, int num )
    {
        m_socket = socket;
        m_num = num;
        
        Thread handler = new Thread( this, "handler-" + m_num );
        handler.start();
    }
    
    private static String getCommendTpye(String cmd) {
    	if (cmd.isEmpty()){
    		return "";
    	}
    	return cmd.split(" ")[0];
    }
    
    public void run()
    {
        try
        {
            try
            {
                System.out.println( m_num + " Connected." );
                BufferedReader in = new BufferedReader( new InputStreamReader( m_socket.getInputStream() ) );
                OutputStreamWriter out = new OutputStreamWriter( m_socket.getOutputStream() );
                out.write( "Welcome connection #" + m_num + "\n\r" );
                out.flush();
                
                while ( true )
                {
                    String line = in.readLine();
                    if ( line == null )
                    {
                        System.out.println( m_num + " Closed." );
                        return;
                    }
                    else
                    {
                        System.out.println( m_num + " Read: " + line );
                        
                        switch (getCommendTpye(line)){
                        case "exit":
                        	System.out.println( m_num + " Closing Connection." );
                            return ;
                        case "quit":
                        	System.out.println( m_num + " Closing Connection." );
                        	return ;
                        case "show":
                        	System.out.println( m_num + " Write: echo " + line );
                            out.write( "version: 1.0 \n\r" );
                            out.flush();
                            break;
                        case "resource":
                        	System.out.println( m_num + " Write: echo " + line );
                            out.write( "resource: ap350  3 busy \n\r         ap340  3 frees \n\r" );
                            out.flush();
                            break;
                        case "run":
                        	System.out.println( m_num + " Write: echo " + line );
                            out.write( "running job list: 1.0 \n\r" );
                            out.flush();
                            break;
                        case "init":
                        	System.out.println( m_num + " Write: echo " + line );
                            out.write( "start init all pool? \n\r" );
                            out.flush();
                            break;
                         default :
                        	 System.out.println( m_num + " Write: echo " + line );
                             out.write( "echo " + line + "\n\r" );
                             out.flush();
                    
                    }
                        
//                        if ( line.equals( "exit" ) )
//                        {
//                            System.out.println( m_num + " Closing Connection." );
//                            return;
//                        }
//                        //else if ( line.equals( "crash" ) )
//                        //{
//                        //    System.out.println( m_num + " Simulating a crash of the Server..." );
//                        //    Runtime.getRuntime().halt(0);
//                        //}
//                        else if (line.equals( "version" )) {
//                        	System.out.println( m_num + " Write: echo " + line );
//                            out.write( "version: 1.0 \n\r" );
//                            out.flush();
//                        }
//                        else
//                        {
//                            System.out.println( m_num + " Write: echo " + line );
//                            out.write( "echo " + line + "\n\r" );
//                            out.flush();
//                        }
                    }
                }
            }
            finally
            {
                m_socket.close();
            }
        }
        catch ( IOException e )
        {
            System.out.println( m_num + " Error: " + e.toString() );
        }
    }
    
    public static void main( String[] args )
        throws Exception
    {
        int port = 9000;
        if ( args.length > 0 )
        {
            port = Integer.parseInt( args[0] );
        }
        System.out.println( "Accepting connections on port: " + port );
        int nextNum = 1;
        ServerSocket serverSocket = new ServerSocket( port );
        while ( true )
        {
            Socket socket = serverSocket.accept();
            testServer hw = new testServer( socket, nextNum++ );
        }
    }
}