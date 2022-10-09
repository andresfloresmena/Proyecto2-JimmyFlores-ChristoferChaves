package SERVER.communication;

import SERVER.logic.Service;
import communication.Protocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import logic.Usuario;


public class Server {
    ServerSocket ss;
    
    public Server() throws IOException {
        ss = new ServerSocket(Protocol.PORT);
        System.out.println("Servidor iniciado...");
    }
    
    public void run(){
        boolean continuar = true;
        Usuario usuario=null;
         
        Socket s;
        ObjectInputStream in;
        ObjectOutputStream out;
        while (continuar) {
            try {
                
                s = ss.accept();
                out = new ObjectOutputStream(s.getOutputStream() );
                in = new ObjectInputStream(s.getInputStream());  
                in.readInt();
                try {
                    usuario=(Usuario)in.readObject();
                    
                    usuario=(Usuario) Service.instance().login(usuario);
                    out.writeInt(Protocol.STATUS_OK);
                    out.writeObject(usuario);
                    
                    out.flush();
                    System.out.println("Conexion Establecida...");
                    Worker worker = new Worker(s,in,out,usuario); 
                    worker.start();                    
                } catch (Exception ex) {  
                    System.out.print(ex.getMessage());
                    out.writeInt(Protocol.STATUS_ERROR);
                    out.writeObject(new Usuario("","","",0));
                    out.flush();
                    s.close();
                }     
                  

            } catch (IOException ex) { }
        }
    }
    
}
   