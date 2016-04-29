
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.pingclient;

import br.ifpb.pod.pingserver.PingServer;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jederson
 */

public class PingClientImpl extends UnicastRemoteObject implements PingClient, Runnable{
    
    private int latencia;
    
    public PingClientImpl() throws RemoteException, NotBoundException{
        super();
        this.latencia = test();
    }
    
     public int getLatencia() {
        
         return latencia;
    }

    public void setLatencia(int latencia) {
        this.latencia = latencia;
    }
    
    public int test() throws RemoteException, NotBoundException{
        long ti, tf;
        int sum = 0;
        for (int i = 1; i < 4; i++) {
             ti = System.currentTimeMillis();
            lookup().ping();
            tf = System.currentTimeMillis();
            Long aux = ((tf-ti)/1000);
            sum += Math.round(aux.doubleValue());
        }       
        return sum / 3;
    }
    
   
    private PingServer lookup() throws RemoteException, NotBoundException{
        Registry registry = LocateRegistry.getRegistry("localhost", 8083);
        PingServer pingServer = (PingServer) registry.lookup("PingServer");
        return pingServer;
    }

    @Override
    public void run() {
        try {
           while(true){
               setLatencia(test());
               Thread.sleep(3000);
           }
        } catch (RemoteException ex) {
            Logger.getLogger(PingClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(PingClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PingClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
