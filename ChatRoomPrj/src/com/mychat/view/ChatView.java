package com.mychat.view;
import java.awt.*;
import javax.swing.*;
import com.mychat.controller.Action;

public class ChatView extends JFrame{
private static final long serialVersionUID = 1L;
public JTextArea outputArea;
public JTextField inputField;
private JButton sendButton;
private JButton quitButton;
public JComboBox<String> comboBox;
public ChatView(){
}
public void launchFrame(){
	Action action=new Action();
	
	outputArea=new JTextArea(10,50);
	outputArea.setLineWrap(true);
	
	JMenuBar menuBar=new JMenuBar();
	JMenu file=new JMenu("File");
	JMenuItem quitMenuItem=new JMenuItem("Quit");
	quitMenuItem.setActionCommand("QUIT");
	quitMenuItem.addActionListener(action);
	file.add(quitMenuItem);
	menuBar.add(file);
	JMenu help=new JMenu("Help");
	JMenuItem about=new JMenuItem("About");
	about.setActionCommand("ABOUT");
	about.addActionListener(action);
	help.add(about);
	menuBar.add(help);
	setJMenuBar(menuBar);
	
	inputField=new JTextField(50);
	inputField.setActionCommand("INPUT_FIELD");
	
	sendButton=new JButton("Send");
	sendButton.addActionListener(action);
	sendButton.setActionCommand("SEND");
	
	quitButton=new JButton("Quit");
	quitButton.addActionListener(action);
	quitButton.setActionCommand("QUIT");
	String[] names={"assasin", "boss", "hugo boss", "dan", "mari"};
	comboBox=new JComboBox<String>(names);
	comboBox.setMaximumRowCount(3);
	
	JScrollPane scrollPane=new JScrollPane(outputArea);
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	add(scrollPane,BorderLayout.WEST);
	add(inputField, BorderLayout.SOUTH);
	JPanel panel=new JPanel();
	
	panel.setLayout(new GridLayout(3,1));
	panel.add(sendButton);
	panel.add(quitButton);
	panel.add(comboBox);
	add(panel, BorderLayout.CENTER);
	pack();
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void showDialog(){
	JOptionPane.showMessageDialog(this,"Simple Chat Client"+"\n"+"Autor: Udot Denis", "About this programm",JOptionPane.INFORMATION_MESSAGE);
}
}
