
package controlador;

import Vista.AcercaDeVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Login;
import modelo.LoginDAO;
import Vista.LoginVista;
import Vista.MenuVista;
import Vista.ProfesoresVista;
import Vista.SeccionesVista;

/**
 *
 * @author MI EQUIPO
 */
public class ControladorMenu implements ActionListener {
    LoginDAO dao = new LoginDAO();
    Login l = new Login();
    MenuVista mv = new MenuVista();
    
     public ControladorMenu(MenuVista mv) {
        this.mv = mv;
        this.mv.btnmtSec.addActionListener(this);
        this.mv.btnmtProf.addActionListener(this);
        this.mv.btnCerrarsesion.addActionListener(this);
        this.mv.btnAcercade.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
        if (e.getSource() == mv.btnmtProf) {
             
                    ProfesoresVista vp = new ProfesoresVista();
                    ControladorProf controlp = new ControladorProf(vp);
                    vp.setVisible(true);
                    vp.setLocationRelativeTo(null);
        }
        
        if (e.getSource() == mv.btnmtSec) {
             
                    SeccionesVista vs = new SeccionesVista();
                    ControladorSec controls = new ControladorSec(vs);
                    vs.setVisible(true);
                    vs.setLocationRelativeTo(null);
        }
        
        if (e.getSource() == mv.btnCerrarsesion) {
            LoginVista vl = new LoginVista();
            ControladorLogin cl = new ControladorLogin(vl);
            mv.setVisible(false);
            vl.setVisible(true);
            vl.setLocationRelativeTo(null);
        }
        
        if (e.getSource() == mv.btnAcercade) {
            AcercaDeVista ac = new AcercaDeVista();
            ac.setVisible(true);
            ac.setLocationRelativeTo(ac);
        }
        
        }
    
}
