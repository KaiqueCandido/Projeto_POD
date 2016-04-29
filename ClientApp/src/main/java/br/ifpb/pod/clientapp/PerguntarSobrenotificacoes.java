/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.clientapp;

import br.ifpb.pod.sender.Sender;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author kaique
 */
public class PerguntarSobrenotificacoes {

    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {

        Registry senderRegistry = LocateRegistry.getRegistry("localhost", 8082);
        Sender sender = (Sender) senderRegistry.lookup("Sender");        

        //java.rmi.server.hotname();
        System.out.println("Verificando Logs");
        while (true) {
            String sucesso = sender.logSucess();
            String erro = sender.logErro();
            int latencia = sender.lookupPing();

            if (sucesso != null) {
                System.out.println("Log S.: " + sucesso + "\n");
            }

            if (erro != null) {
                System.out.println("Log E.: " + erro + "\n");
            }

            if (latencia >= 3) {
                System.out.println("Log L.: " + "Latencia maior que o desejado! Valor: (" + latencia + ")");
            }

            Thread.sleep(4000);
        }
    }
}
