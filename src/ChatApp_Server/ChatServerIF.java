/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatApp_Server;

import ChatApp_Client.ChatClientIF;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dell
 */
public interface ChatServerIF extends Remote{
    void registerChatClient (ChatClientIF chatClient) throws RemoteException;
    void broadcastMessage(String message) throws RemoteException;
    
}
