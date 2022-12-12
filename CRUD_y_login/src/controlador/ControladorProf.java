
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ProfesorDAO;
import modelo.Profesor;
import vista.VistaProf;

public class ControladorProf implements ActionListener {

    ProfesorDAO dao = new ProfesorDAO();
    Profesor p = new Profesor();
    VistaProf vista = new VistaProf();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorProf(VistaProf v) {
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
            int fila = vista.tblProfesores.getSelectedRow();
            
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione una fila de la  tabla");
            } else {
                int Id_prof = Integer.parseInt((String)vista.tblProfesores.getValueAt(fila, 0).toString());
                String Nombre = (String)vista.tblProfesores.getValueAt(fila, 1);
                String Apellido = (String)vista.tblProfesores.getValueAt(fila, 2);
                String Sexo = (String)vista.tblProfesores.getValueAt(fila, 3);
                String Email = (String)vista.tblProfesores.getValueAt(fila, 4);
                vista.txtID.setText(""+Id_prof);
                vista.txtNombre.setText(Nombre);
                vista.txtApellido.setText(Apellido);
                vista.txtSexo.setText(Sexo);
                vista.txtEmail.setText(Email);
            }
             limpiarTabla();
             listar(vista.tblProfesores);
        }
        
        if (e.getSource() == vista.btnAgregar) {
            
            
            if (validarCampos(vista) > 0) {
                JOptionPane.showMessageDialog(vista, "Contacto agregado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                agregar();
                limpiarCampos(vista);
                limpiarTabla();
                listar(vista.tblProfesores);
            } else {
                JOptionPane.showMessageDialog(vista, "Error: Los campos Nombre, Apellido e Email no pueden estar vacíos", "Error!", JOptionPane.ERROR_MESSAGE);
                limpiarCampos(vista);
                listar(vista.tblProfesores);
            }
            
            
            
        }
        
        if (e.getSource() == vista.btnEliminar) {
             eliminar();
             limpiarTabla();
             listar(vista.tblProfesores);
            
        }
        
        if (e.getSource() == vista.btnActualizar){
            actualizar();
            limpiarCampos(vista);
            limpiarTabla();
            listar(vista.tblProfesores);
            vista.txtNombre.requestFocus();
        }
        
         if (e.getSource() == vista.btnBuscar) {
            if (!this.vista.txtBuscar.getText().equals("")) {
                limpiarTabla();
                limpiarCampos(vista);
                buscarFila(vista.tblProfesores);
            } else {
//                this.vista.btnCancelar.setEnabled(true);
                JOptionPane.showMessageDialog(vista, "El campo de busqueda esta vacio.");
            }
        }
         
         if (e.getSource() == vista.btnCancelar) {
            
//            this.vista.lblAviso.setVisible(false);
            vista.txtBuscar.setText("");
//            limpiarCampos(vista);
//            limpiarTabla();
             limpiarTabla();
             limpiarCampos(vista);
        }
    }

    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Profesor> lista = dao.listar();
        Object[] object = new Object[5];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_prof();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getApellido();
            object[3] = lista.get(i).getSexo();
            object[4] = lista.get(i).getEmail();
            modelo.addRow(object);
        }
        vista.tblProfesores.setModel(modelo);
    }
    
    public void agregar() {
        
       
        
        String Nombre = vista.txtNombre.getText();
        String Apellido = vista.txtApellido.getText();
        String Sexo = vista.txtSexo.getText();
        String Email = vista.txtEmail.getText();
        p.setNombre(Nombre);
        p.setApellido(Apellido);
        p.setSexo(Sexo);
        p.setEmail(Email);
        int res = dao.agregar(p);
        
        
    }
    
    public void eliminar() {
         int fila = vista.tblProfesores.getSelectedRow();
            
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un profesor");
            } else {
                int id = Integer.parseInt((String)vista.tblProfesores.getValueAt(fila, 0).toString());
                dao.eliminar(id);
                JOptionPane.showMessageDialog(vista, "Profesor eliminado");
            }
    }
    
    public void actualizar() {
        int id = Integer.parseInt((String)vista.txtID.getText());
        String Nombre = vista.txtNombre.getText();
        String Apellido = vista.txtApellido.getText();
        String Sexo = vista.txtSexo.getText();
        String Email = vista.txtEmail.getText();
        p.setId_prof(id);
        p.setNombre(Nombre);
        p.setApellido(Apellido);
        p.setSexo(Sexo);
        p.setEmail(Email);
        
        int res = dao.actualizar(p);
        
        if (res == 1) {
            JOptionPane.showMessageDialog(vista, "Profesor actualizado");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");

        }
        
    }
    
    void limpiarTabla() {
        for (int i = 0; i < vista.tblProfesores.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
     public final void limpiarCampos(VistaProf v) {
        v.txtID.setText("");
        v.txtNombre.setText("");
        v.txtApellido.setText("");
        v.txtSexo.setText("");
        v.txtEmail.setText("");
        v.txtNombre.requestFocus();
    }
    
     public void buscarFila(JTable tabla) {
        limpiarTabla();
        modelo = (DefaultTableModel) tabla.getModel();
        List<Profesor> lista = (List<Profesor>) dao.buscarFila(vista.txtBuscar.getText());
        Object[] object = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_prof();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getApellido();
            object[3] = lista.get(i).getSexo();
            object[4] = lista.get(i).getEmail();
            modelo.addRow(object);
        }
        vista.tblProfesores.setModel(modelo);
    }
     
      public int validarCampos(VistaProf v) {

        int validacion = 1;

        if (v.txtNombre.getText().equals("")) {
            
            v.txtNombre.requestFocus();
            validacion = 0;
        } else if (v.txtApellido.getText().equals("")) {
            v.txtApellido.requestFocus();
            validacion = 0;
        } else if (v.txtEmail.getText().equals("")) {
            v.txtEmail.requestFocus();
            validacion = 0;
        } 
//        } else {
//            validacion = 1;
//        }

        return validacion;
    }

}
