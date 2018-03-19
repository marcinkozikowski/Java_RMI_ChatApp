/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatApp_Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class ChatServerDriver {


    public static void main(String[] args) throws RemoteException, MalformedURLException {
            try {
            System.setProperty("java.security.policy", "security.policy");
            if (System.getSecurityManager() == null) {

                System.setSecurityManager(new SecurityManager());

            }
          System.setProperty("java.rmi.server.codebase", "file:/C:/Users/Dell/Documents/NetBeansProjects/Java_RMI_ChatApp/");

            LocateRegistry.createRegistry(1099);

            Naming.rebind("//localhost/ABC", new ChatServer());

            System.out.println("Serwer oczekuje ...");

        } catch (RemoteException | MalformedURLException e) {

            e.printStackTrace();

        }
    }
    
}
