package BD;

import java.sql.*;

public class Conexion {
    
    Connection conexion = null;
    
    //Metodo que permite la conexion con la base de datos.
    public static Connection ConexionBD()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:GestProfSecc.db");
            System.out.println("¡La conexión con base de datos fue exitosa!");
            return conexion;
        }
        catch(Exception e)
        {
            System.out.println("La conexion a base de datos ha fallado: " + e);
            return null;
        }
    }
}
