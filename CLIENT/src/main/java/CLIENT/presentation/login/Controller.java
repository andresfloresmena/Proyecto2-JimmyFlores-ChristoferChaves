package CLIENT.presentation.login;

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

    public void show() {
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }

    public void hide() {
        this.view.setVisible(false);

    }

    public void navegacionShow() {
        this.hide();
        Application.NAVEGACION.show();
    }

    public void login(Usuario u)  {
        try{
            Usuario usuario1 = Proxy.instance().login(u);
             model.setUsuario(usuario1); 
             model.commit();
             this.hide();
             Application.NAVEGACION.show();
             Application.CLAVE.setUserModel(usuario1);
             Application.RETIRO.setUserModel(usuario1);
        }
        catch(Exception e){
            model.setUsuario(new Usuario("error","","",0));
                 model.commit();
        }
    }

    public void salir() {
        System.exit(0);

    }
    
    

    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
}
