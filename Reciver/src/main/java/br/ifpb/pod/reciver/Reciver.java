/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.reciver;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author kaique
 */
public interface Reciver extends Remote {

    String senderServeApp(String msg) throws RemoteException;

    String reciver(String msg) throws RemoteException;

}
