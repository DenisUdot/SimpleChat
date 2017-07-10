package com.mychat.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import com.mychat.fvk.Fwk;
import com.mychat.view.MyView;

public class Action implements ActionListener {
	private MyView chat;
	public Action(){
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().getClass().getSimpleName().equals("JButton")){
			JButton button=(JButton) e.getSource();
			chat=((MyView)SwingUtilities.windowForComponent(button));
			Fwk.getInstance().getMyController(chat).keyPressed(button.getActionCommand());
		}
		if(e.getSource().getClass().getSimpleName().equals("JMenuItem")){
			JMenuItem item=(JMenuItem)e.getSource();
			chat=(MyView)SwingUtilities.windowForComponent(getMenuBarMenu(item));
			Fwk.getInstance().getMyController(chat).keyPressed(item.getActionCommand());
			
		}
	}
	 private JMenu getMenuBarMenu(JMenuItem item){
	        JMenu menu = null;
	        while (menu == null){
	            JPopupMenu popup = (JPopupMenu)item.getParent();
	            item = (JMenuItem)popup.getInvoker();
	            if (!(item.getParent() instanceof JPopupMenu)){
	                menu = (JMenu)item;
	            }    
	        }
	        return menu;
	 }
}
	