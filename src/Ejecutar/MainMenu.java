
package Ejecutar;

import Vista.MenuVista;
import controlador.ControladorMenu;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainMenu {
    public static void main(String[] arg) {
        MenuVista mv = new MenuVista();
        ControladorMenu cm = new ControladorMenu(mv);
        mv.setVisible(true);
        mv.setLocationRelativeTo(mv);
        
        
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
