package com.weibo.newbie.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;


public class Server {
	
	private int port; 
	  
    public Server(int port) { 
        this.port = port; 
    } 
  
    public void run() { 
        try { 
            TServerSocket serverTransport = new TServerSocket(port); 
            TProcessor tProcessor = new UserService.Processor<UserService.Iface>(
            		new UserServiceImpl());
            TServer tServer = new TSimpleServer((new TThreadPoolServer.Args(serverTransport)
            		.processor(tProcessor))); 
             
            tServer.serve(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
  
    public static void main(String[] args) { 
        new Server(Constants.PORT).run(); 
    } 

	
}
