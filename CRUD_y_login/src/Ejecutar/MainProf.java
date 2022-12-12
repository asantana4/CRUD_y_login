
package Ejecutar;

import controlador.ControladorProf;
import vista.VistaProf;


public class MainProf {
     public static void main(String args[]) {
       VistaProf v = new VistaProf();
       ControladorProf c  = new ControladorProf(v);
       v.setVisible(true);
       v.setLocationRelativeTo(v);
    }
}
