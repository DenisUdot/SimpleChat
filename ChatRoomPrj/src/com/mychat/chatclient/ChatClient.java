package com.mychat.chatclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import com.mychat.view.ChatView;

public class ChatClient {
	private static PrintWriter writer;
	private static Socket socket=null;
	public static String socketIp="127.0.0.1";
	private static ChatView chat=null;
public static boolean setUpNetwok(){
		try{
			socket=new Socket(socketIp,6000);
			writer=new PrintWriter(socket.getOutputStream());
			Thread t =new Thread(new ServerListener(socket,getChat()));
			t.start();
			System.out.println("network was setup");
			return true;
		}catch(IOException ex){
			ex.printStackTrace();
			return false;
		}
}
public static void sendMessage(String message){
	writer.println(message);
	writer.flush();
}
public static ChatView getChat() {
	return chat;
}
public static void setChat(ChatView chat) {
	ChatClient.chat = chat;
}
}
