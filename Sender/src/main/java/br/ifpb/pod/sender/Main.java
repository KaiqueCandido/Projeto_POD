/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.sender;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author kaique
 */
public class Main {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        //3 minutos
        //System.setProperty("sun.rmi.transport.tcp.responseTimeout", "180000");

        //10 segundos
        System.setProperty("sun.rmi.transport.tcp.responseTimeout", "10000");

        Sender sender = new SenderImpl();
        Registry registry = LocateRegistry.createRegistry(8082);
        registry.bind("Sender", sender);
        System.out.println("Sender Online!");

    }
}
