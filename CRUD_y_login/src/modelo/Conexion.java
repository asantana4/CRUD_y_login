
package modelo;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author MI EQUIPO
 */
public class Conexion {
    java.sql.Connection con;
    public static final String URL = "jdbc:sqlite:C:\\SqliteDB\\ProyectoFinal.db";
    
   public static java.sql.Connection getConnection() {

        java.sql.Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = (java.sql.Connection) DriverManager.getConnection(URL);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return (java.sql.Connection) con;
    }
}
