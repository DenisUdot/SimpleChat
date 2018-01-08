package com.mychat.main;

import com.mychat.chatclient.ChatClient;
import com.mychat.view.ChatView;
import com.mychat.view.ConnectView;

public class MainTest {
	private ChatView chat;
	public static void main(String[] args) {
		new MainTest().go();
	}
	public void go(){
		chat=new ChatView();
		chat.launchFrame();
		ChatClient.setChat(chat);
		getConnect();
	}
	public void getConnect(){
		ChatClient.setUpNetwok();
		if (ChatClient.setUpNetwok()==false){
			ConnectView view=new ConnectView();
			view.launchFrame();
		}
	}
}
