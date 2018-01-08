package com.mychat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.mychat.userlist.ClientList;

public class ClientHandler implements Runnable{
	private BufferedReader bReader;
	private Socket socket;
	public ClientHandler(Socket clientSocket){
		try{
			socket=clientSocket;
			InputStreamReader isReader=new InputStreamReader(socket.getInputStream());
			bReader=new BufferedReader(isReader);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void run() {
		String message;
		try{
			while ((message=bReader.readLine())!=null){
				tellEveryone(message);
			}
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public void tellEveryone(String message){
		for (int i=0; i<ClientList.getSize();i++){
			try{System.out.println(message);
				ClientList.getClient(i).println(message);
				ClientList.getClient(i).flush();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

}
