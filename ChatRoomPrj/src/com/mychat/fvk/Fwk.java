package com.mychat.fvk;

import com.mychat.controller.ConnectViewController;
import com.mychat.controller.Controller;
import com.mychat.controller.MyController;
import com.mychat.view.MyView;

public class Fwk {
    private static Fwk _instance = null;
    private Controller myk = null;
    private Fwk() {
    	//comparison: view1 have controller1
    	
    	
    }

    public synchronized static Fwk getInstance() {
        if (_instance == null){
            _instance = new Fwk();
        }
        return _instance;
    }
    public synchronized Controller getMyController(MyView chat) {
    	if(chat.getClass().getSimpleName().equals("ChatView")){
    		myk=new MyController(chat);
    		System.out.println(myk.getClass().getSimpleName());
    		return myk;
    	}
    	if(chat.getClass().getSimpleName().equals("ConnectView")){
    		myk=new ConnectViewController(chat);
    		System.out.print(myk.getClass().getSimpleName());
    		return myk;
    	}
    	else{
    		return null;
    	}
    }
}