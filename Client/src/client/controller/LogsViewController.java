package client.controller;

import client.ThreadClient;
import client.ViewManager;

public class LogsViewController {
    private ViewManager viewManager;
    private ThreadClient threadClient;


    public void initialize() {

    }

    public void sendRestorePasswordRequest() {
       //RESTORE EMAIL POP UP
    }

    public void back(){
        viewManager.setLoggedScene();

    }




    public void setThreadClient(ThreadClient threadClient) {
        this.threadClient = threadClient;
    }

    public void setViewManager(ViewManager viewManager) {
        this.viewManager = viewManager;
    }
}
