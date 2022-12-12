
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Login;
import modelo.LoginDAO;
import modelo.Menu;
import vista.LoginVista;
import vista.MenuVista;
import vista.VistaProf;
import vista.VistaSec;

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
        this.mv.btnCerrarsecion.addActionListener(this);
        this.mv.btnAcercade.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
        if (e.getSource() == mv.btnmtProf) {
             //CAMBIAR POR LA VISTA DE MENU
                    VistaProf vp = new VistaProf();
                    ControladorProf controlp = new ControladorProf(vp);
                    vp.setVisible(true);
                    vp.setLocationRelativeTo(null);
        }
        
        if (e.getSource() == mv.btnmtSec) {
             //CAMBIAR POR LA VISTA DE MENU
                    VistaSec vs = new VistaSec();
                    ControladorSec controls = new ControladorSec(vs);
                    vs.setVisible(true);
                    vs.setLocationRelativeTo(null);
        }
        
        }
    
}
