/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejecutar;

import controlador.ControladorLogin;
import Vista.LoginVista;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainLogin {
     public static void main(String args[]) {
        LoginVista lv = new LoginVista();
        ControladorLogin cl = new ControladorLogin(lv);
        lv.setVisible(true);
        lv.setLocationRelativeTo(null);
        
        
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
