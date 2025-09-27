package Registro_Medico;

import java.sql.*;
import javax.swing.*;
import javax.swing.DefaultListModel;

public class Registro extends javax.swing.JFrame {

    public Registro() {
        initComponents();
        cargarCombos();
    }

    private void cargarCombos() {
        cbxDireccion.addItem("Calle 123");
        cbxDireccion.addItem("Avenida Siempre Viva");
        cbxDireccion.addItem("Boulevard Central");

        cbxTipoSangre.addItem("A+");
        cbxTipoSangre.addItem("A-");
        cbxTipoSangre.addItem("B+");
        cbxTipoSangre.addItem("B-");
        cbxTipoSangre.addItem("AB+");
        cbxTipoSangre.addItem("AB-");
        cbxTipoSangre.addItem("O+");
        cbxTipoSangre.addItem("O-");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        // Aquí va el código generado por NetBeans
        // Asegúrate de que los nombres coincidan con los que mencionaste
    }
    // </editor-fold>

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultListModel<String> model = new DefaultListModel<>();
        String sql = "SELECT * FROM Pacientes";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String fila = "ID: " + rs.getInt("Id") + " | Nombre: " + rs.getString("Nombre") +
                              " | Teléfono: " + rs.getString("Telefono");
                model.addElement(fila);
            }

            JList<String> lista = new JList<>(model);
            JScrollPane scroll = new JScrollPane(lista);
            panelDatos.removeAll();
            panelDatos.add(scroll);
            panelDatos.revalidate();
            panelDatos.repaint();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al listar: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Registro().setVisible(true);
        });
    }

    // Declaración de variables
    private javax.swing.JButton btnBuscarId;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<String> cbxDireccion;
    private javax.swing.JComboBox<String> cbxTipoSangre;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JTextField txtAlergias;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
}