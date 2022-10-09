package CLIENT.presentation.clave;

import java.util.Observable;
import java.util.Observer;
import logic.Usuario;

public class Model extends Observable{
    
    // Model attributes here
    Usuario usuario;

    // Model gets and sets here
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); 
        this.commit();
    }
    
    public void commit(){
        this.setChanged();
        this.notifyObservers();
    }
    
}











