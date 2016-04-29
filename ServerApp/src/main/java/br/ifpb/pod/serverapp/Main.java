/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.serverapp;

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
        ServerApp serverApp = new ServerAppImpl();

        Registry registry = LocateRegistry.createRegistry(8080);
        registry.bind("ServerApp", serverApp);
        System.out.println("Servidor Online!");

    }
}
