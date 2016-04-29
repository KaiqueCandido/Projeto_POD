/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.serverapp;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author kaique
 */
public interface ServerApp extends Remote{

    String processMessage(String msg) throws RemoteException;

}
