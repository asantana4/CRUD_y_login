/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejecutar;

import controlador.ControladorLogin;
import vista.LoginVista;


public class MainLogin {
     public static void main(String args[]) {
        LoginVista lv = new LoginVista();
        ControladorLogin cl = new ControladorLogin(lv);
        lv.setVisible(true);
        lv.setLocationRelativeTo(null);
    }
}
