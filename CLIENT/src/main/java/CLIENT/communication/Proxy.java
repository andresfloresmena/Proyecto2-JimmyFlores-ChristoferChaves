package CLIENT.communication;


import communication.Protocol;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import logic.Usuario;

public class Proxy {
    
    private static Proxy theInstance;

    public static Proxy instance() {
        if (theInstance == null) {
            theInstance = new Proxy();
        }
        return theInstance;
    }
    
    Socket s;
    ObjectInputStream in;
    ObjectOutputStream out;

    public Proxy() {

    }

    public Usuario login(Usuario u) throws Exception {
     
        try {
            s = new Socket(Protocol.SERVER, Protocol.PORT);
            out = new ObjectOutputStream(s.getOutputStream());
            in = new ObjectInputStream(s.getInputStream());
        }
            catch(IOException ex){
                   System.out.println("Error de comunicación"); 
                    System.exit(-1);
                    }
          out.writeInt(Protocol.LOGIN);
           out.writeObject(u);
           out.flush();
           int status=in.readInt();
           switch(status){
               case Protocol.STATUS_OK:
                   return (Usuario)in.readObject();
               case Protocol.STATUS_ERROR:
                   throw new Exception("Error de comunicación");
               default: return null;
           }
    }

    public void logout() throws Exception {
        out.writeInt(Protocol.LOGOUT);
        out.flush();

    }

    public void retiro(int parameter) throws Exception {
        out.writeInt(Protocol.RETIRO);
        out.writeObject(parameter);
        out.flush();
        int status = in.readInt();
        switch (status) {
            case Protocol.STATUS_OK:
               // return (String) in.readObject();
            case Protocol.STATUS_ERROR:
                throw new Exception("Error de metodo");
            default:
               // return null;
        }
    }
    
    public void changePassword(String parameter) throws Exception {
        out.writeInt(Protocol.PASSWORD);
     
        out.writeObject(parameter);
        
        out.flush();
        int status = in.readInt();
        switch (status) {
            case Protocol.STATUS_OK:
              //  return (String) in.readObject();
            case Protocol.STATUS_ERROR:
               // throw new Exception("Error de metodo");
            default:
               // return null;
        }
    }


  public int saldoActual() throws Exception {
        out.writeInt(Protocol.SALDO);
       // out.writeObject(parameter);
        out.flush();
        int status = in.readInt();
        switch (status) {
            case Protocol.STATUS_OK:
                return (int) in.readObject();
            case Protocol.STATUS_ERROR:
                throw new Exception("Error de metodo");
            default:
                return -1;
        }
    }
}
