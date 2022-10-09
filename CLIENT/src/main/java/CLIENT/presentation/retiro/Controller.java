package CLIENT.presentation.retiro;

import CLIENT.Application;
import CLIENT.communication.Proxy;
import logic.Usuario;

public class Controller {
    Model model;
    View view;
    

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
        
        model.setUsuario(new Usuario());       
        view.setModel(model);
        view.setController(this);
        
    }
    public void hacerRetiro(int ret){
        try{
            Proxy.instance().retiro(ret);
           // model.setUsuario(new Usuario("EXITO","","",0));
            //model.commit();
        }
        catch(Exception e){
          //  model.setUsuario(new Usuario());
            //model.commit();
        }
    }
    
    public void setUserModel(Usuario u){
        this.model.setUsuario(u);
        model.commit();
    } 
    
    public int getSaldo(){
        try{
            return Proxy.instance().saldoActual();
           
        }
        catch(Exception e){
            return -1;
        }
    }
    public void show(){
        this.view.setVisible(true);
    }
    public void hide(){
        this.view.setVisible(false);
        Application.NAVEGACION.show();
    }
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
}
