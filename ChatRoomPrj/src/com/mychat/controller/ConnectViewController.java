package com.mychat.controller;

import com.mychat.chatclient.ChatClient;
import com.mychat.view.ConnectView;
import com.mychat.view.MyView;

public class ConnectViewController implements Controller {
	private ConnectView view;
	private StringBuffer ipAdress;
	public ConnectViewController(MyView view){
		this.view=(ConnectView)view;
		
	}
	
	public void keyPressed(String Name) {
		System.out.println(Name);
		ipAdress=new StringBuffer();
		for(int i=0; i<view.serverIp.length; i++){
		ipAdress.append(view.serverIp[i].getText());
			if(i<(view.serverIp.length-1)){
				ipAdress.append(".");
			}
		}
		ChatClient.socketIp=ipAdress.toString();
		if(ChatClient.setUpNetwok()==true){
			System.out.println(ipAdress);
			view.dispose();
		}
		
	}

}
