package CLIENT.presentation.navegación;

import CLIENT.Application;

public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
        view.setModel(model);
        view.setController(this);
    }
    
    public void show(){
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }
    
    public void hide(){
        this.view.setVisible(false);
    }
    
    public void exit(){
    }
    
    public void retiroShow(){
        this.hide();
        Application.RETIRO.show();
    }
    
    public void cambioContraseñaShow(){
        this.hide();
        Application.CLAVE.show();
    }    
    public void salir(){
         System.exit(0);
    }
}

    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 

