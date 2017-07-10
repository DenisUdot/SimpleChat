package com.mychat.controller;

import com.mychat.chatclient.ChatClient;
import com.mychat.view.ChatView;
import com.mychat.view.MyView;

public class MyController implements Controller {
private ChatView chat;

public MyController(MyView chat2){
	chat=(ChatView)chat2;
	
}

	public void keyPressed(String buttonName) {
		switch(buttonName){
		case "SEND":
		ChatClient.sendMessage((String)chat.comboBox.getSelectedItem()+": "+chat.inputField.getText());
		chat.inputField.setText("");
		break;
		case "ABOUT":
			chat.showDialog();
			System.out.println("About");
		break;
		case "QUIT":
			System.exit(0);
		break;
		}
		}
	}

