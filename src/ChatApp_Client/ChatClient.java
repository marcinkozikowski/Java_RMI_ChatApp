/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatApp_Client;

import ChatApp_Server.ChatServerIF;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class ChatClient extends UnicastRemoteObject implements ChatClientIF,Runnable {
    
    private ChatServerIF chatServer;
    private String name = null;

    public String getName() throws RemoteException {
        return name;
    }
    
    protected ChatClient(String _name, ChatServerIF _chatServer) throws RemoteException
    {
        name = _name;
        chatServer = _chatServer;
        chatServer.registerChatClient(this);
    }

    public void retriveMessage(String message) throws RemoteException {
        System.out.println(message);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String message;
        while(true)
        {
            message = scanner.nextLine();
            try{
                chatServer.broadcastMessage(name +": "+message);
            }catch(RemoteException e){
                e.printStackTrace();
            }
        }
    }
    
}
