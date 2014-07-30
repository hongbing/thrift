package com.weibo.newbie.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class Client {
	
	private int port; 
    private String host; 
    public Client(String host, int port ) { 
        super(); 
        this.port = port; 
        this.host = host; 
    } 
  
    public User run() { 
        TTransport transport = null; 
        try { 
            transport = new TSocket(host, port); 
            TProtocol protocol = new TBinaryProtocol(transport); 
            UserService.Client client = new UserService.Client(protocol); 
            transport.open(); 
  
            long uid = 11011;
            return client.getUser(uid); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            if (transport != null) { 
                transport.close(); 
            } 
        } 
        return null;
    } 
  
    public static void main(String[] args) { 
        
        User user = new Client(Constants.HOSTNAME, Constants.PORT).run(); 
        System.out.println("user id: " + user.getUid() +"\n"
        		+ "user name: " + user.getUname());
    } 

	
}
