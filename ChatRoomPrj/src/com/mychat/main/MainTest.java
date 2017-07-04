package com.mychat.main;

import com.mychat.chatclient.ChatClient;
import com.mychat.view.ChatView;

public class MainTest {

	public static void main(String[] args) {
		ChatView chat=new ChatView();
		chat.launchFrame();
		ChatClient.setUpNetwok(chat);
	}
}
