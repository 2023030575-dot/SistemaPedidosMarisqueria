package admin;

import cliente.VUsuarioCliente;
import javax.swing.JOptionPane;
import conexion.ConexionDB;
import java.sql.*;
import javax.swing.JFrame;
import main.AbrirVentana;
import repartidor.VPerfilRepartidor;

public class VCambiarContra extends javax.swing.JFrame {
    public static VCambiarContra instancia = null;
    JFrame perfilAnterior;
    int idUsuario;

    private VCambiarContra(int idUsuario,JFrame perfilAnterior) {
        this.idUsuario = idUsuario;
        this.perfilAnterior = perfilAnterior;

        initComponents(); 
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        setLocationRelativeTo(null);
    }
    
    private void confirmChangePass() {
        String actual = txtContraseñaActual.getText();
        String nueva = txtContraseñaNueva.getText();
        String confirmar = txtConfirmarContraseña.getText();

        if (actual.isEmpty() || nueva.isEmpty() || confirmar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos.");
            return;
        }

        if (!nueva.equals(confirmar)) {
            JOptionPane.showMessageDialog(this, "La nueva contraseña no coincide con la confirmación.");
            return;
        }

        try {
            Connection con = new ConexionDB().clientConnection();
            String sql = "SELECT contrasena FROM usuarios WHERE id_usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String passBD = rs.getString("contrasena");
                if (!actual.equals(passBD)) {
                    JOptionPane.showMessageDialog(this, "La contraseña actual es incorrecta.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el usuario.");
                return;
            }
            rs.close();
            ps.close();

            String update = "UPDATE usuarios SET contrasena = ? WHERE id_usuario = ?";
            PreparedStatement ps2 = con.prepareStatement(update);
            ps2.setString(1, nueva);
            ps2.setInt(2, idUsuario);
            int rows = ps2.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Se ha cambiado correctamente la contraseña.");
                perfilAnterior.dispose();

                switch (perfilAnterior) {
                    case VEditarCliente ventana -> ventana.updatePass(nueva);
                    case VEditarRepartidor ventana -> ventana.updatePass(nueva);
                    case VEditarAdmin ventana -> ventana.updatePass(nueva);
                    default -> {
                    }
                }
                perfilAnterior.setLocationRelativeTo(null);
                perfilAnterior.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar la contraseña.");
            }
            ps2.close();
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        iblContraseñaNueva = new javax.swing.JLabel();
        iblConfirmarContraseña = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        iblContraseñaActual = new javax.swing.JLabel();
        txtContraseñaActual = new javax.swing.JPasswordField();
        txtConfirmarContraseña = new javax.swing.JPasswordField();
        txtContraseñaNueva = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("CAMBIAR CONTRASEÑA");

        iblContraseñaNueva.setText("Nueva Contraseña:");

        iblConfirmarContraseña.setText("Confirmar Contraseña:");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        iblContraseñaActual.setText("Contraseña Actual:");

        txtContraseñaActual.setEchoChar((char) 0);
        txtContraseñaActual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraseñaActualFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContraseñaActualFocusLost(evt);
            }
        });
        txtContraseñaActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContraseñaNueva)
                                    .addComponent(txtConfirmarContraseña)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(iblConfirmarContraseña)
                                            .addComponent(iblContraseñaNueva)
                                            .addComponent(iblContraseñaActual)
                                            .addComponent(txtContraseñaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel1)))
                        .addGap(78, 78, 78)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(iblContraseñaActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtContraseñaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(iblContraseñaNueva)
                .addGap(18, 18, 18)
                .addComponent(txtContraseñaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iblConfirmarContraseña)
                .addGap(18, 18, 18)
                .addComponent(txtConfirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnRegresar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmChangePass();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        if(perfilAnterior instanceof VEditarCliente){
            AbrirVentana.getInstance().vEditClient(idUsuario);
        }else if(perfilAnterior instanceof VEditarRepartidor){
            AbrirVentana.getInstance().vEditDeliver(idUsuario);
        }else if(perfilAnterior instanceof VEditarAdmin){
            AbrirVentana.getInstance().vEditAdmin(idUsuario);
        }else if(perfilAnterior instanceof VUsuarioCliente){
            AbrirVentana.getInstance().vClientUser(idUsuario);
        }else if(perfilAnterior instanceof VPerfilRepartidor){
            AbrirVentana.getInstance().DeliverProfile(idUsuario);
        }else{
            JOptionPane.showConfirmDialog(null, "Error, no se llego a esta ventana de manera convencional");
            System.exit(0);
        }   
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtContraseñaActualFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseñaActualFocusGained

    }//GEN-LAST:event_txtContraseñaActualFocusGained

    private void txtContraseñaActualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseñaActualFocusLost

    }//GEN-LAST:event_txtContraseñaActualFocusLost

    private void txtContraseñaActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActualActionPerformed
      
    }//GEN-LAST:event_txtContraseñaActualActionPerformed
    
    public static VCambiarContra getInstance(int id, JFrame prev) {
        if (instancia == null || !instancia.isDisplayable()) {
            instancia = new VCambiarContra(id, prev);
        } else {
            instancia.toFront();
            instancia.requestFocus();
        }
        return instancia;
    }
    
    @Override
    public void dispose() {
        super.dispose();
        instancia = null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel iblConfirmarContraseña;
    private javax.swing.JLabel iblContraseñaActual;
    private javax.swing.JLabel iblContraseñaNueva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txtConfirmarContraseña;
    private javax.swing.JPasswordField txtContraseñaActual;
    private javax.swing.JPasswordField txtContraseñaNueva;
    // End of variables declaration//GEN-END:variables
}
