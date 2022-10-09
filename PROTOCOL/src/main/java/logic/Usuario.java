package logic;

import java.io.Serializable;
import java.util.Objects;


public class Usuario implements Serializable {
    private String userName;
    private String password;
    private String nombre;
     private  int balance;

    public Usuario(String userName, String password, String nombre, int balance) {
        this.userName = userName;
        this.password = password;
        this.nombre = nombre;
        this.balance = balance;
    }
    
    public Usuario(){
        this.userName = "";
        this.password = "";
        this.nombre="";
        this.balance=0;
    }

   
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

  /*  public String getUsername() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}

