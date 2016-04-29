/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.sender;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author kaique
 */
public interface Sender extends Remote {

    void reciveReciveApp(String msg) throws RemoteException;

    int lookupPing() throws RemoteException;

    String logErro() throws RemoteException;

    String logSucess() throws RemoteException;
}
