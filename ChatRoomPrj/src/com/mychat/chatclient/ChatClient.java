package com.mychat.chatclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import com.mychat.view.ChatView;

public class ChatClient {
	private static PrintWriter writer;
	private static Socket socket;
public static void setUpNetwok(ChatView chat){
	try{
		socket=new Socket("127.0.0.1",6000);
		writer=new PrintWriter(socket.getOutputStream());
		Thread t =new Thread(new ServerListener(socket,chat));
		t.start();
		System.out.println("network was setup");
	}catch(IOException ex){
		ex.printStackTrace();
	}
}
public static void sendMessage(String message){
	writer.println(message);
	writer.flush();
}
}
