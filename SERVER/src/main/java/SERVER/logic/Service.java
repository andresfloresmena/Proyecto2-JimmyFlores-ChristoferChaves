package SERVER.logic;

import SERVER.data.UsuarioDao;
import java.sql.SQLException;
import java.util.List;
import logic.Usuario;

public class Service {

    // Singleton implementation
    private static Service theInstance;

    public static Service instance() {
        if (theInstance == null) {
            theInstance = new Service();
        }
        return theInstance;
    }

    // Service data
    UsuarioDao uDao;

    // Service methods
    public Usuario login(Usuario un) throws Exception { // PRIMER METODO
        return uDao.login(un);
    }

    public void retiro(Usuario u, int b) throws Exception { //SEGUNDO METODO
         uDao.retiro(u, b);
    }
    
    public int getSaldo(Usuario u) throws Exception{
        return uDao.Saldo(u);
    }
    
    public void cambioClave(Usuario u, String c) throws Exception { //TERCER METODO 
         uDao.cambioClave(u, c);
        
    }

    public List<Usuario> usuarioSearch(String un) throws SQLException {
        return uDao.findByUsername(un);
    }

    public List<Usuario> usuarioAll() throws SQLException {
        return uDao.findAll();
    }

    public void usuarioAdd(Usuario u) throws Exception {
        uDao.create(u);
    }

   

    public Service() {
        try {
            uDao = new UsuarioDao();
        } catch (Exception e) {

        }
    }

}
