/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.sender;

import br.ifpb.pod.pingclient.PingClient;
import br.ifpb.pod.reciver.Reciver;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaique
 */
public class SenderImpl extends UnicastRemoteObject implements Sender {

    private List<String> logErro;
    private List<String> logSucess;
    private int count;

    public SenderImpl() throws RemoteException {
        super();
        this.logErro = new ArrayList<String>();
        this.logSucess = new ArrayList<String>();
        int count = 0;
    }

    @Override
    public void reciveReciveApp(String msg) throws RemoteException {
        try {
            Reciver reciver = this.lookup();
            String resultado = reciver.reciver(msg);
            this.logSucess.add("Sucesso na entrega da mensagem: " + msg);
        } catch (RemoteException re) {
            this.logErro.add("Erro ao entregar a mensagem: " + msg + " Erro original: " + re.getMessage());
        } catch (NotBoundException nbe) {
            this.logErro.add("Reciver desconectado: " + msg);
        }

    }

    @Override
    public String logErro() throws RemoteException {
        if (this.logErro.size() > 0) {
            String erro = this.logErro.get(0);
            this.logErro.remove(erro);
            return erro;
        } else {
            return null;
        }
    }

    @Override
    public String logSucess() throws RemoteException {
        if (this.logSucess.size() > 0) {
            String sucess = this.logSucess.get(0);
            this.logSucess.remove(sucess);
            return sucess;
        } else {
            return null;
        }
    }

    public Reciver lookup() throws RemoteException, NotBoundException {
        try {
            Registry serverAppRegistry = LocateRegistry.getRegistry("localhost", 8081);
            Reciver reciver = (Reciver) serverAppRegistry.lookup("Reciver");
            return reciver;
        } catch (NotBoundException nbe) {
            throw new NotBoundException();
        }

    }

    @Override
    public int lookupPing() throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 8084);
            PingClient pingClient = (PingClient) registry.lookup("PingClient");
            return pingClient.getLatencia();
        } catch (NotBoundException nbe) {
            throw new RemoteException(nbe.getMessage());
        }
    }

}
