package com.mychat.chatclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.mychat.view.ChatView;

public class ServerListener implements Runnable {
	private BufferedReader reader;
	private ChatView chat;
	public ServerListener(Socket socket, ChatView chat){
		this.chat=chat;
		try {
			InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
			reader=new BufferedReader(streamReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void run() {
		String message;
		try{
			while((message=reader.readLine())!=null){
				System.out.println(message);
				chat.outputArea.append(message+"\n");
				
			}
		}catch(IOException ex){
				ex.printStackTrace();
		}
	}
}
