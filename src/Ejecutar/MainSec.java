
package Ejecutar;


import controlador.ControladorSec;
import Vista.SeccionesVista;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainSec {
     public static void main(String args[]) {
       SeccionesVista v = new SeccionesVista();
       ControladorSec c  = new ControladorSec(v);
       v.setVisible(true);
       v.setLocationRelativeTo(v);
       
       
        Frame frame = new Frame();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        Frame frame = (Frame) evt.getSource();
        frame.setVisible(false);
        // frame.dispose();
      }
    });
    }
}
