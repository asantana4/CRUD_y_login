/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.LoginDAO;
import modelo.Login;
import vista.LoginVista;
import vista.MenuVista;

/**
 *
 * @author jquezada
 */
public class ControladorLogin implements ActionListener {

    /**
     * Declaracion de los objetos necesarios: dao = Data Access Object c =
     * Estructura de datos del objeto vista = Formulario de contactos modelo =
     * Modelo donde se cargan los datos de la tabla
     */
    LoginDAO dao = new LoginDAO();
    Login l = new Login();
    LoginVista loginv = new LoginVista();
    
    public ControladorLogin(LoginVista l) {
        this.loginv = l;
        this.loginv.btnIngresar.addActionListener(this);
        //Limpiar campos
        limpiarCampos(l);
    }

   

    /**
     * Este metodo se encarga de limpiar los campos del formulario de ingreso o
     * login.
     *
     * @param l
     */
    private void limpiarCampos(LoginVista l) {
        l.txtUsuario.setText("");
        l.txtContrasena.setText("");
        l.txtUsuario.requestFocus();
    }

    /**
     * Este metodo se encarga de validar que tanto el usuario como la clave no
     * esten vacios al momento de realizar el ingreso o login.
     */
    private boolean validarCampos(LoginVista l) {
        if (l.txtUsuario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(loginv, "El campo de usuario no debe estar vacio!", "Error!", JOptionPane.ERROR_MESSAGE);
            l.txtUsuario.requestFocus();
            return false;
        }
        if (l.txtContrasena.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(loginv, "El campo de clave no debe estar vacio!", "Error!", JOptionPane.ERROR_MESSAGE);
            l.txtContrasena.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * Este metodo se encarga de validar los datos del login de usuario.
     *
     * @param usuario
     * @param clave
     * @param login
     * @return boolean
     */
    public boolean AccionarLogin(String usuario, String clave, LoginVista login) {
        if (validarCampos(login)) {
            System.out.println("Campos del formulario validados que no esten vacios!");
            try {
                System.out.println("Verificando si los datos existen!");
                if (dao.realizarLogin(usuario, clave)) {
                    JOptionPane.showMessageDialog(loginv, "Ingresado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                    login.setVisible(false);
                    System.out.println("Ingresando a formulario de contactos contactos!");
                  
                    //CAMBIAR POR LA VISTA DE MENU
                    MenuVista mv = new MenuVista();
                    
                    
                    //CAMBIAR POR EL CONTROLADOR DE MENU
                    ControladorMenu control = new ControladorMenu(mv);
                    mv.setVisible(true);
                    mv.setLocationRelativeTo(null);
                    return true;
                } else{
                    JOptionPane.showMessageDialog(login,"Error al tratar de ingresar.\n El usuario o la clave estan incorrectos!", "Error!",JOptionPane.ERROR_MESSAGE);
                    limpiarCampos(login);
                    return false;
                }
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(loginv, "Error al tratar de ingresar: " + e, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    /**
     * Este metodo verifica si se ha producido algun evento dentro del
     * formulario.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      String nu;

//Validando si se presiono la tecla de ingreso
        if (e.getSource() == loginv.btnIngresar) {
            String usuario = loginv.txtUsuario.getText();
            String contrasena   = loginv.txtContrasena.getText();
            AccionarLogin(usuario, contrasena, loginv);
        }
        //Validando si se presiono la tecla de cancelar
//        if (e.getSource() == loginv.btnCancelar) {
//            System.exit(0);
        }
    
       
        }
    



