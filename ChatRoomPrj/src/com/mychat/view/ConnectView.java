package com.mychat.view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mychat.controller.Action;

public class ConnectView extends JFrame implements MyView {
	private static final long serialVersionUID = 1L;
	public JTextField[] serverIp=new JTextField[4];
	private JPanel panel;
	private JButton setIp;
	
	public void launchFrame(){
		panel=new JPanel();
		setIp=new JButton("Setup IP");
		setIp.setActionCommand("SET IP");
		setIp.addActionListener(new Action());
		add(new JLabel("Insert server IP"),BorderLayout.NORTH);
		for(int i=0; i<serverIp.length; i++){
			serverIp[i]=new JTextField();
			serverIp[i].setColumns(3);
			panel.add(serverIp[i]);
				if(i<(serverIp.length-1)){
					panel.add(new JLabel("."));
				}
		}
		add(panel,BorderLayout.CENTER);
		add(setIp, BorderLayout.SOUTH);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}		
}
