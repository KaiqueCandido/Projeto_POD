/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.clientapp;

import br.ifpb.pod.sender.Sender;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author kaique
 */
public class EnviaMensagem {

    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        Registry senderRegistry = LocateRegistry.getRegistry("localhost", 8082);
        Sender sender = (Sender) senderRegistry.lookup("Sender");        

        while (true) {
            
            System.out.println("Enviando Mensagem");
            sender.reciveReciveApp("Kaique");            
            Thread.sleep(5000);
        }
    }
}
