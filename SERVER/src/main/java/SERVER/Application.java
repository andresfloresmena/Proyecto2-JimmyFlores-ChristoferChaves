package SERVER;

import SERVER.communication.Server;
import SERVER.logic.Service;
import java.io.IOException;
import logic.Usuario;


public class Application {

    public static void main(String[] args) throws IOException {
      
    /* try{
        Usuario u=  Service.instance().login(new Usuario("mari","1111","mari",0));
        //Service.instance().cambioClave(u, "1111");
        //int saldo= Service.instance().getSaldo(u);
          //System.out.print(saldo);
          
         Service.instance().retiro(u,5);
      }
   
        
      catch(Exception e){
          System.out.print("No sirve");
      }*/
        Server server = new Server();
        server.run();
    }

}
