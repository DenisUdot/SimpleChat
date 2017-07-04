package com.mychat.userlist;

import java.io.PrintWriter;
import java.util.ArrayList;

public  class  ClientList {
	private static ArrayList<PrintWriter> clientList=new ArrayList<PrintWriter>();
	private ClientList(){
		
	}
	public static void addClient(PrintWriter writer){
		clientList.add(writer);
	}
	public static PrintWriter getClient(int i){
		return clientList.get(i);
	}
	public static int getSize(){
		return clientList.size();
	}
}
