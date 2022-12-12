
package Ejecutar;

import controlador.ControladorProf;
import Vista.ProfesoresVista;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainProf {
     public static void main(String args[]) {
       ProfesoresVista v = new ProfesoresVista();
       ControladorProf c  = new ControladorProf(v);
       v.setVisible(true);
       v.setLocationRelativeTo(v);

 Frame frame = new Frame();
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent evt) {
        Frame frame = (Frame) evt.getSource();
        frame.setVisible(false);
        // frame.dispose();
      }
    });

    }
}
