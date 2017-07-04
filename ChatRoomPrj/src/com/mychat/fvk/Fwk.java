package com.mychat.fvk;

import com.mychat.controller.Controller;
import com.mychat.controller.MyController;
import com.mychat.view.ChatView;

public class Fwk {
    private static Fwk _instance = null;
    private Controller myk = null;
    private Fwk(ChatView chat) {
    	//comparison: view1 have controller1
    	System.out.println(chat.getName());
    	myk=new MyController(chat);
    }

    public synchronized static Fwk getInstance(ChatView chat) {
        if (_instance == null)
            _instance = new Fwk(chat);
        return _instance;
    }
    public synchronized Controller getMyController() {
        return myk;
    }
}