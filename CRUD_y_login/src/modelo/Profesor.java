
package modelo;

import javax.swing.JTextField;

/**
 *
 * @author MI EQUIPO
 */
public class Profesor {
    int Id_prof;
    String Nombre;
    String Apellido;
    String Sexo;
    String Email;

    public Profesor() {
    }

    public Profesor(int Id_prof, String Nombre, String Apellido, String Sexo, String Email) {
        this.Id_prof = Id_prof;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Sexo = Sexo;
        this.Email = Email;
    }

    public int getId_prof() {
        return Id_prof;
    }

    public void setId_prof(int Id_prof) {
        this.Id_prof = Id_prof;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
