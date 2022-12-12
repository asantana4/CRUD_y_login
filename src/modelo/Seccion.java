
package modelo;


public class Seccion {
    int Id_seccion;
    int Clave;
    String Asignatura;
    int Id_prof;
    String Horario;

    
    public Seccion() {
        
    }
    
    
    public Seccion(int Id_seccion, int Clave, String Asignatura, int Id_prof, String Horario) {
        this.Id_seccion = Id_seccion;
        this.Clave = Clave;
        this.Asignatura = Asignatura;
        this.Id_prof = Id_prof;
        this.Horario = Horario;
    }

    public int getId_seccion() {
        return Id_seccion;
    }

    public void setId_seccion(int Id_seccion) {
        this.Id_seccion = Id_seccion;
    }

    public int getClave() {
        return Clave;
    }

    public void setClave (int Clave) {
        this.Clave = Clave;
    }

    public String getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(String Asignatura) {
        this.Asignatura = Asignatura;
    }

    public int getId_prof() {
        return Id_prof;
    }

    public void setId_prof(int Id_prof) {
        this.Id_prof = Id_prof;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }
    
}
