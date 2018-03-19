/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatApp_Server;

import ChatApp_Client.ChatClientIF;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class ChatServer extends UnicastRemoteObject implements ChatServerIF{
    
    private static final long serialVersionUID =1L;
    private ArrayList<ChatClientIF> chatClients;
    
    protected ChatServer() throws RemoteException{
        super();
        chatClients = new ArrayList<ChatClientIF>();
    }

    public synchronized void registerChatClient(ChatClientIF chatClient) throws RemoteException {
        this.chatClients.add(chatClient);
    }

    public synchronized void broadcastMessage(String message) throws RemoteException {
        for(int i=0;i<chatClients.size();i++)
        {
            if(!message.contains(chatClients.get(i).getName()))
            {
                chatClients.get(i).retriveMessage(message);
            }
        }
    }
    
}
