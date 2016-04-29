/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.pingserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jederson
 */
public class PingServerImpl extends UnicastRemoteObject implements PingServer{
    
       
    public PingServerImpl() throws RemoteException{
        super();
    }

    @Override
    public boolean ping() throws RemoteException {
        return true;
    }
}
