package com.mychat.controller;

import com.mychat.chatclient.ChatClient;
import com.mychat.view.ChatView;

public class MyController implements Controller {
private ChatView chat;

public MyController(ChatView chat2){
	chat=chat2;
	
}

	public void keyPressed(String buttonName) {
		switch(buttonName){
		case "SEND":
		ChatClient.sendMessage((String)chat.comboBox.getSelectedItem()+": "+chat.inputField.getText());
		chat.inputField.setText("");
		//chat.outputArea.setCaretPosition(chat.outputArea.getDocument().getLength()-1);
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

