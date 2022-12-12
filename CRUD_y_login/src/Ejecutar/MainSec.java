
package Ejecutar;


import controlador.ControladorSec;
import vista.VistaSec;


public class MainSec {
     public static void main(String args[]) {
       VistaSec v = new VistaSec();
       ControladorSec c  = new ControladorSec(v);
       v.setVisible(true);
       v.setLocationRelativeTo(v);
    }
}
