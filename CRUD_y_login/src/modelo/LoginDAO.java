
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



  

/**
 *
 * @author jquezada
 */
public class LoginDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    /**
     * Este metodo se encarga de listar un registro. El mismo devuelve un objeto
     * tipo arrayList.
     *
     * @param usuariof
     * @param clavef
     * @return datos
     */
    public boolean realizarLogin(String usuario, String clave) {
        con = conectar.getConnection();

        String sql = "select * from Acceso where Usuario = ? and Contrasena = ?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, clave);

            rs = ps.executeQuery();

            while (rs.next()) {
                con.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
}
