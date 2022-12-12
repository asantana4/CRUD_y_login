
package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Seccion;
import modelo.SeccionDAO;
import vista.VistaSec;

public class ControladorSec implements ActionListener {

    SeccionDAO dao = new SeccionDAO();
    Seccion p = new Seccion();
    VistaSec vista = new VistaSec();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorSec(VistaSec v) {
        this.vista = v;
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource() == vista.btnEditar) {
            int fila = vista.tblSecciones.getSelectedRow();
            
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione una fila de la  tabla");
            } else {
                int Id_seccion = Integer.parseInt((String)vista.tblSecciones.getValueAt(fila, 0).toString());
                int Clave = Integer.parseInt((String)vista.tblSecciones.getValueAt(fila, 1).toString());
                String Asignatura = (String)vista.tblSecciones.getValueAt(fila, 2);
                int Id_prof = Integer.parseInt((String)vista.tblSecciones.getValueAt(fila, 1).toString());
                String Horario = (String)vista.tblSecciones.getValueAt(fila, 4);
                vista.txtID.setText(""+Id_seccion);
                vista.txtClave.setText(""+Clave);
                vista.txtAsignatura.setText(Asignatura);
                vista.txtId_prof.setText(""+Id_prof);
                vista.txtHorario.setText(Horario);
            }
             limpiarTabla();
             listar(vista.tblSecciones);
        }
        
        if (e.getSource() == vista.btnAgregar) {
            
            
            if (validarCampos(vista) > 0) {
                JOptionPane.showMessageDialog(vista, "Sección agregada con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                agregar();
                limpiarCampos(vista);
                limpiarTabla();
                listar(vista.tblSecciones);
            } else {
                JOptionPane.showMessageDialog(vista, "Error: Los campos Clave, Asignatura y ID del profesor no pueden estar vacíos", "Error!", JOptionPane.ERROR_MESSAGE);
                limpiarCampos(vista);
                listar(vista.tblSecciones);
            }
            
            
            
        }
        
        if (e.getSource() == vista.btnEliminar) {
             eliminar();
             limpiarTabla();
             listar(vista.tblSecciones);
            
        }
        
        if (e.getSource() == vista.btnActualizar){
            actualizar();
            limpiarCampos(vista);
            limpiarTabla();
            listar(vista.tblSecciones);
            vista.txtAsignatura.requestFocus();
        }
        
         if (e.getSource() == vista.btnBuscar) {
            if (!this.vista.txtBuscar.getText().equals("")) {
                limpiarTabla();
                limpiarCampos(vista);
                buscarFila(vista.tblSecciones);
            } else {
//                this.vista.btnCancelar.setEnabled(true);
                JOptionPane.showMessageDialog(vista, "El campo de busqueda esta vacio.");
            }
        }
         
         if (e.getSource() == vista.btnCancelar) {
            vista.txtBuscar.setText("");
             limpiarTabla();
             limpiarCampos(vista);
        }
    }

    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Seccion> lista = dao.listar();
        Object[] object = new Object[5];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_seccion();
            object[1] = lista.get(i).getClave();
            object[2] = lista.get(i).getAsignatura();
            object[3] = lista.get(i).getId_prof();
            object[4] = lista.get(i).getHorario();
            modelo.addRow(object);
        }
        vista.tblSecciones.setModel(modelo);
    }
    
    public void agregar() {
         
        int Clave = Integer.parseInt((String)vista.txtClave.getText());
        String Asignatura = vista.txtAsignatura.getText();
        int Id_prof = Integer.parseInt((String)vista.txtId_prof.getText());
        String Horario = vista.txtHorario.getText();
        p.setClave(Clave);
        p.setAsignatura(Asignatura);
        p.setId_prof(Id_prof);
        p.setHorario(Horario);
        int res = dao.agregar(p);
        
        
    }
    
    public void eliminar() {
         int fila = vista.tblSecciones.getSelectedRow();
            
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una sección");
            } else {
                int id = Integer.parseInt((String)vista.tblSecciones.getValueAt(fila, 0).toString());
                dao.eliminar(id);
                JOptionPane.showMessageDialog(vista, "Seccion eliminada");
            }
    }
    
    public void actualizar() {
        int id = Integer.parseInt((String)vista.txtID.getText());
        int Clave = Integer.parseInt((String)vista.txtClave.getText());
        String Asignatura = vista.txtAsignatura.getText();
        int Id_prof = Integer.parseInt((String)vista.txtId_prof.getText());
        String Horario = vista.txtHorario.getText();
        p.setId_seccion(id);
        p.setClave(Clave);
        p.setAsignatura(Asignatura);
        p.setId_prof(Id_prof);
        p.setHorario(Horario);
        int res = dao.actualizar(p);
        
        if (res == 1) {
            JOptionPane.showMessageDialog(vista, "Seccion actualizada");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");

        }
        
    }
    
    void limpiarTabla() {
        for (int i = 0; i < vista.tblSecciones.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
     public final void limpiarCampos(VistaSec v) {
        v.txtID.setText("");
        v.txtClave.setText("");
        v.txtAsignatura.setText("");
        v.txtId_prof.setText("");
        v.txtHorario.setText("");
        v.txtAsignatura.requestFocus();
    }
    
     public void buscarFila(JTable tabla) {
        limpiarTabla();
        modelo = (DefaultTableModel) tabla.getModel();
        List<Seccion> lista = (List<Seccion>) dao.buscarFila(vista.txtBuscar.getText());
        Object[] object = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_seccion();
            object[1] = lista.get(i).getClave();
            object[2] = lista.get(i).getAsignatura();
            object[3] = lista.get(i).getId_prof();
            object[4] = lista.get(i).getHorario();
            modelo.addRow(object);
        }
        vista.tblSecciones.setModel(modelo);
    }
     
      public int validarCampos(VistaSec v) {

        int validacion = 1;

        if (v.txtClave.getText().equals("")) {
            
            v.txtClave.requestFocus();
            validacion = 0;
        } else if (v.txtAsignatura.getText().equals("")) {
            v.txtAsignatura.requestFocus();
            validacion = 0;
        } else if (v.txtId_prof.getText().equals("")) {
            v.txtId_prof.requestFocus();
            validacion = 0;
        } 
//        } else {
//            validacion = 1;
//        }

        return validacion;
    }

}