
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVER.communication;

import SERVER.logic.Service;
import communication.Protocol;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import logic.Usuario;

public class Worker {

    Socket s;
    ObjectInputStream in;
    ObjectOutputStream out;
    Usuario usuario;

    public Worker(Socket s, ObjectInputStream in, ObjectOutputStream out, Usuario usuario) {
        this.s = s;
        this.in = in;
        this.out = out;
        this.usuario = usuario;
    }

    private boolean condition = false;

    public void start() {

        System.out.println("Worker " + usuario.getUserName() + " atendiendo peticiones...");
        Runnable tarea = new Runnable() {
            public void run() {
                while (condition) {
                    listen();
                }
                System.out.println("Worker " + usuario.getUserName() + " finalizo...");
            }
        };
        Thread hilo = new Thread(tarea);
        condition = true;
        hilo.start();
    }

    public void listen() {
        int method;
        try {
            method = in.readInt();
            System.out.println("Operacion: " + method + usuario.getUserName());
            switch (method) {
                case Protocol.PASSWORD:
                    String parameter = "";
                    try {
                        parameter = (String) in.readObject();
                    } catch (ClassNotFoundException ex) {
                    }
                    try {
                        Service.instance().cambioClave(usuario, parameter);
                        out.writeInt(Protocol.STATUS_OK);
                // out.writeObject(result);
                    } catch (Exception e) {
                
                        out.writeInt(Protocol.STATUS_ERROR);
                    }
                    break;
                case Protocol.RETIRO:
                    int parameter1 = 0;
                    try {
                        parameter1 = (int) in.readObject();
                    } catch (ClassNotFoundException ex) {
                        
                    }
                    try {
                        Service.instance().retiro(usuario, parameter1);
                        out.writeInt(Protocol.STATUS_OK);
                       // out.writeObject(result);
                    } catch (Exception e) {
                         System.out.println("Error4");
                        out.writeInt(Protocol.STATUS_ERROR);
                    }
                    break;
                case Protocol.SALDO:
              
                    try {
                    int result = Service.instance().getSaldo(usuario);
                    out.writeInt(Protocol.STATUS_OK);
                    out.writeObject(result);
                } catch (Exception e) {
                     System.out.println("Error5");
                    out.writeInt(Protocol.STATUS_ERROR);
                }
                break;
            }
            out.flush();
        } catch (IOException io) {
             
            System.out.println(io);
            condition = false;
        }
    }
}
