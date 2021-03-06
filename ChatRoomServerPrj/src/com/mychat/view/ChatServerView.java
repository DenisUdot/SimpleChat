package com.mychat.view;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChatServerView {
	private JLabel label;
	public void launchFrame(){
		JFrame frame=new JFrame("Server");
		try {
			label=new JLabel();
			label.setText("<html>This Server IP Adress: " + Inet4Address.getLocalHost().getHostAddress()+
					"<br>"+	"Virtual port: 6000<br></html>");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		frame.add(label);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
