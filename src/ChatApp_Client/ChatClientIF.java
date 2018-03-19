/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatApp_Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dell
 */
public interface ChatClientIF extends Remote {
    void retriveMessage(String message) throws RemoteException;
    String getName() throws RemoteException;
    
}
