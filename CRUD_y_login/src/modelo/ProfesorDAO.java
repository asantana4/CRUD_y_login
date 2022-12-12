
package modelo;

/**
 *
 * @author MI EQUIPO
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {
    Conexion conectar = new Conexion();
    java.sql.Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
   public java.util.List listar(){
        String sql = "select * from Profesores";
        java.util.List<Profesor>datos = new ArrayList<>();
        try{
            
            con = conectar.getConnection();
            ps  = con.prepareStatement(sql);
            rs  = ps.executeQuery();
            
            while(rs.next()){
                Profesor p = new Profesor();
                p.setId_prof(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setSexo(rs.getString(4));
                p.setEmail(rs.getString(5));
                datos.add(p);
            }
        }catch(SQLException ex){
            System.out.println("Error al listar los profesores: " + ex);
        }
        return datos;
    }
   
   
   public int agregar(Profesor p) {
       
       String sql = "insert into Profesores (Nombre, Apellido, Sexo, Email) values (?, ?, ?, ?)";
       
       try {
           con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getSexo());
            ps.setString(4, p.getEmail());
            ps.executeUpdate();
       } catch(SQLException ex) {
           System.out.println("Error al listar los contactos: " + ex);
       }
       
       return 1;
   }
   
   public void eliminar (int id) {
       String sql = "delete from Profesores where Id_prof="+id;
       
       try {
           con = conectar.getConnection();
           ps = con.prepareStatement(sql);
           ps.executeUpdate();
       } catch(SQLException ex) {
           System.out.println("Error al eliminar registro: " + ex);
       }
           
    }
   
    /**
     *
     * @param p
     * @return
     */
    public int actualizar(Profesor p) {
        
        String sql = "update Profesores set Nombre=?, Apellido=?, Sexo=?, Email=? where Id_prof=?";
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getSexo());
            ps.setString(4, p.getEmail());
            ps.setInt(5, p.getId_prof());
            int res = ps.executeUpdate();
            
            if (res == 1) {
                return 1;
            } else {
                return 0;
            }
            
            
        } catch(SQLException ex) {
            System.out.println("Error al actualizar registro: " + ex);
        }
        return 1;
   }
    
    public List buscarFila(String valorBuscar) {
         
        String sql = "select * from Profesores "+
                     "where Nombre like '%"+valorBuscar+"%' or Apellido like '%"+valorBuscar+"%';";
        
        List<Profesor>datos = new ArrayList<>();
        try{
            
            con = conectar.getConnection();
            ps  = con.prepareStatement(sql);
            rs  = ps.executeQuery();
            
            while(rs.next()){
                Profesor p = new Profesor();
                p.setId_prof(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setSexo(rs.getString(4));
                p.setEmail(rs.getString(5));
                datos.add(p);
            }
        }catch(SQLException ex){
            System.out.println("Error al mostrar la fila: " + ex);
        }
        return datos;
    }
}
