/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.reciver;

import br.ifpb.pod.serverapp.ServerApp;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kaique
 */
public class ReciverImpl extends UnicastRemoteObject implements Reciver {

    public ReciverImpl() throws RemoteException {
        super();
    }

    @Override
    public String senderServeApp(String msg) throws RemoteException {
        ServerApp serverApp = this.lookup();
        String processMessage = serverApp.processMessage(msg);
        return processMessage;
    }

    @Override
    public String reciver(String msg) throws RemoteException {
            return this.senderServeApp(msg);
    }

    public ServerApp lookup() throws RemoteException {
        try {
            Registry serverAppRegistry = LocateRegistry.getRegistry("localhost", 8080);
            ServerApp serverApp = (ServerApp) serverAppRegistry.lookup("ServerApp");
            return serverApp;
        } catch (NotBoundException nbe) {
            throw new RemoteException("ServeApp indisponível");
        }
    }
}
