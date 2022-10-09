package SERVER.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.Usuario;

public class UsuarioDao {

    //UsuarioDao data
    DataBase db;

    //UsuarioDao methods 
     public Usuario login(Usuario us) throws Exception {  //PRIMER METODO
        String sql = "select * from usuario u where username=? and password=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, us.getUserName());
        stm.setString(2, us.getPassword());
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Usuario u = from(rs, "u");
            return u;
        } else {
            throw new Exception("Usuario no existe");
        }
    }
    
    public void retiro(Usuario u,int monto) throws Exception{ //SEGUNDO METODO
        String sql="update usuario set balance=balance-? "+
                "where username=? and balance>=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, monto);
        stm.setString(2, u.getUserName());
        stm.setInt(3,monto);
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Usuario no existe");
        }    
    }
    
     public void cambioClave(Usuario u,String C) throws Exception{ //TERCER METODO
       String sql="update Usuario set password=? "+
                "where username=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, C);
        stm.setString(2, u.getUserName());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Usuario no existe");
        }
        
    }
    
    public int Saldo(Usuario u) throws Exception{
        String sql="select * from Usuario u where username=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getUserName());
        ResultSet rs=db.executeQuery(stm);
        if (rs.next()){
            Usuario us=from(rs,"u");
            return us.getBalance();
        }
        else{
            throw new Exception("Usuario no existe");
        }
    }
    
    public void create(Usuario u) throws Exception {
        String sql = "insert into usuario (username, password, nombre, balance) " + "values (?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getUserName());
        stm.setString(2, u.getPassword());
        stm.setString(3, u.getNombre());
        stm.setString(4, Integer.toString(u.getBalance()));

        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Usuario ya existe");
        }

    } 

    public void update(Usuario u) throws Exception {
        String sql = "update usuario set nombre=?, password=?, balance=? " + "where userName=?";
        PreparedStatement stm = db.prepareStatement(sql);

        stm.setString(1, u.getNombre());
        stm.setString(2, u.getPassword());
        stm.setString(3, Integer.toString(u.getBalance()));

        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Usuario no existe");
        }

    }

    public void delete(Usuario u) throws SQLException, Exception {
        String sql = "delete from usuario where username=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getUserName());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Usuario no existe");
        }
    }

    public List<Usuario> findAll() throws SQLException {
        List<Usuario> resultado = new ArrayList<>();

        try {
            String sql = "select * from Usuario u";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Usuario u;
            while (rs.next()) {
                u = from(rs, "u");
                resultado.add(u);
            }
        } catch (SQLException ex) {

        }
        return resultado;
    }

    public List<Usuario> findByUsername(String un) throws SQLException {
        List<Usuario> resultado = new ArrayList<>();

        try {
            String sql = "select * from Usuario u" + "where u.username like ?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, un + "%");
            ResultSet rs = db.executeQuery(stm);
            Usuario u;
            while (rs.next()) {
                u = from(rs, "u");
                resultado.add(u);
            }
        } catch (SQLException ex) {

        }
        return resultado;
    }
    
    public Usuario from(ResultSet rs, String alias) throws SQLException {
        try {
            Usuario u = new Usuario();
            u.setUserName(rs.getString(alias + ".username"));
            u.setPassword(rs.getString(alias + ".password"));
            u.setBalance(rs.getInt(alias + ".balance"));
            u.setNombre(alias + ".nombre");
            return u;
            
        } catch (SQLException ex) {
            return null;
        }
    }

    public UsuarioDao() {
        db = DataBase.instance();
    }
}
