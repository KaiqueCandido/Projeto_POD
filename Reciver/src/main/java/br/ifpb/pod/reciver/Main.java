/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.reciver;

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
        Reciver reciver = new ReciverImpl();

        Registry registry = LocateRegistry.createRegistry(8081);
        registry.bind("Reciver", reciver);
        System.out.println("Reciver Online!");
        
    }
}
