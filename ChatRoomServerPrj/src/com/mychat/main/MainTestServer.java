package com.mychat.main;
 
import com.mychat.server.ChatServer;

public class MainTestServer {
	public static void main(String [] args){
		ChatServer cs=new ChatServer();
		cs.go();
	}
}
