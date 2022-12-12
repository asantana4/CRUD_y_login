
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeccionDAO {
    Conexion conectar = new Conexion();
    java.sql.Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
   public java.util.List listar(){
        String sql = "select * from Secciones";
        java.util.List<Seccion>datos = new ArrayList<>();
        try{
            
            con = conectar.getConnection();
            ps  = con.prepareStatement(sql);
            rs  = ps.executeQuery();
            
            while(rs.next()){
                Seccion s = new Seccion();
                s.setId_seccion(rs.getInt(1));
                s.setClave(rs.getInt(2));
                s.setAsignatura(rs.getString(3));
                s.setId_prof(rs.getInt(4));
                s.setHorario(rs.getString(5));
                datos.add(s);
            }
        }catch(SQLException ex){
            System.out.println("Error al listar las secciones: " + ex);
        }
        return datos;
    }
   
   
   public int agregar(Seccion s) {
       
       String sql = "insert into Secciones (Clave, Asignatura, Id_prof, Horario) values (?, ?, ?, ?)";
       
       try {
           con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, s.getClave());
            ps.setString(2, s.getAsignatura());
            ps.setInt(3, s.getId_prof());
            ps.setString(4, s.getHorario());
            ps.executeUpdate();
       } catch(SQLException ex) {
           System.out.println("Error al listar las secciones: " + ex);
       }
       
       return 1;
   }
   
   public void eliminar (int id) {
       String sql = "delete from Secciones where Id_seccion="+id;
       
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
     * @param s
     * @param p
     * @return
     */
    public int actualizar(Seccion s) {
        
        String sql = "update Secciones set Clave=?, Asignatura=?, Id_prof=?, Horario=? where Id_seccion=?";
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, s.getClave());
            ps.setString(2, s.getAsignatura());
            ps.setInt(3, s.getId_prof());
            ps.setString(4, s.getHorario());
            ps.setInt(5, s.getId_seccion());
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
         
        String sql = "select * from Secciones "+"where Asignatura like '%"+valorBuscar+"%';";
//        "%' or Id_seccion = "+valorBuscar;
//                + ""
//                + "or Id_prof = "+valorBuscar+" or Horario like '%"+valorBuscar+"%' or Id_seccion = "+valorBuscar+";";
        
        List<Seccion>datos = new ArrayList<>();
        try{
            
            con = conectar.getConnection();
            ps  = con.prepareStatement(sql);
            rs  = ps.executeQuery();
            
            while(rs.next()){
                Seccion s = new Seccion();
                s.setId_seccion(rs.getInt(1));
                s.setClave(rs.getInt(2));
                s.setAsignatura(rs.getString(3));
                s.setId_prof(rs.getInt(4));
                s.setHorario(rs.getString(5));
                datos.add(s);
            }
        }catch(SQLException ex){
            System.out.println("Error al mostrar la fila: " + ex);
        }
        return datos;
    }
}
