package com.mychat.server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import com.mychat.userlist.ClientList;
import com.mychat.view.ChatServerView;

public class ChatServer {
	private ServerSocket serverSock; 
	public void go(){
//		JFrame frame=new JFrame("Server");
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChatServerView view=new ChatServerView(); 
		view.launchFrame();
		try{
			
			serverSock = new ServerSocket(6000);
			while(true){
				Socket clientSocket=serverSock.accept();
				PrintWriter writer=new PrintWriter(clientSocket.getOutputStream());
				ClientList.addClient(writer);
				Thread t =new Thread(new ClientHandler(clientSocket));
				t.start();
				System.out.println("We got a connection");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
