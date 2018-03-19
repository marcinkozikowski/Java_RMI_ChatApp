/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatApp_Client;

import ChatApp_Server.ChatServerIF;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatClientDriver {

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        System.setProperty("java.security.policy", "security.policy");
        System.setSecurityManager(new SecurityManager());
        System.out.print("Klient podłączony...");
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj nazwę użytkownika: ");
        String name = sc.nextLine();

        try {

            ChatServerIF chatServer = (ChatServerIF) Naming.lookup("//localhost/ABC");
             new Thread (new ChatClient(name,chatServer)).start();

        } catch (Exception e) {

            e.printStackTrace();

        }
        
       
    }
    
}
