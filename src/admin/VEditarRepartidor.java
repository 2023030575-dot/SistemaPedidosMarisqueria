package admin;

import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import login.Verificacion;

public class VEditarRepartidor extends javax.swing.JFrame {
    public static VEditarRepartidor instancia = null;
    int idUsuario;
    Verificacion check = new Verificacion();

    public VEditarRepartidor(int idUsuario) {
        this.idUsuario = idUsuario; 
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        
        cargarDatosRepartidor();

    }
    private void cargarDatosRepartidor() {
        Connection con = (Connection) new ConexionDB().deliverConnection();
        if (con != null) {
            try {
                String sql = "SELECT r.nombre, r.apellidos, r.rfc, r.curp, r.genero, r.placa, u.correo, u.contrasena " +
                 "FROM repartidores r " +
                 "JOIN usuarios u ON r.id_usuario = u.id_usuario " +
                 "WHERE r.id_usuario = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, this.idUsuario);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    txtNombre.setText(rs.getString("nombre"));
                    txtApellidos.setText(rs.getString("apellidos"));
                    txtRfc.setText(rs.getString("rfc"));
                    txtCurp.setText(rs.getString("curp"));
                    txtGenero.setText(rs.getString("genero"));
                    txtPlaca.setText(rs.getString("placa"));
                    txtCorreo.setText(rs.getString("correo"));
                    txtContrasena.setText(rs.getString("contrasena"));
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró información del repartidor.");
                }

                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.");
        }

    }
    public void updatePass(String nuevaPass) {
        txtContrasena.setText(nuevaPass);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenido = new javax.swing.JPanel();
        iblCorreo = new javax.swing.JLabel();
        btnCambiarNombre = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();
        btnCambiarApellidos = new javax.swing.JButton();
        btnCambiarContraseña = new javax.swing.JButton();
        btnCambiarGenero = new javax.swing.JButton();
        btnVolverPedidos = new javax.swing.JButton();
        btnCambiarRfc = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        btnCambiarCurp = new javax.swing.JButton();
        iblGenero = new javax.swing.JLabel();
        btnCambiarPlaca = new javax.swing.JButton();
        iblNombre = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        btnCambiarCorreo = new javax.swing.JButton();
        iblApellido = new javax.swing.JLabel();
        iblRFC = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtRfc = new javax.swing.JTextField();
        iblCURP = new javax.swing.JLabel();
        iblPlaca = new javax.swing.JLabel();
        txtCurp = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        iblCorreo1 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        iblCorreo.setText("Correo:");

        btnCambiarNombre.setText("Cambiar");
        btnCambiarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarNombreActionPerformed(evt);
            }
        });

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        btnCambiarApellidos.setText("Cambiar");
        btnCambiarApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarApellidosActionPerformed(evt);
            }
        });

        btnCambiarContraseña.setText("Cambiar");
        btnCambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraseñaActionPerformed(evt);
            }
        });

        btnCambiarGenero.setText("Cambiar");
        btnCambiarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarGeneroActionPerformed(evt);
            }
        });

        btnVolverPedidos.setText("Regresar");
        btnVolverPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverPedidosActionPerformed(evt);
            }
        });

        btnCambiarRfc.setText("Cambiar");
        btnCambiarRfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarRfcActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnCambiarCurp.setText("Cambiar");
        btnCambiarCurp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCurpActionPerformed(evt);
            }
        });

        iblGenero.setText("Genero:");

        btnCambiarPlaca.setText("Cambiar");
        btnCambiarPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarPlacaActionPerformed(evt);
            }
        });

        iblNombre.setText("Nombre:  ");

        btnCambiarCorreo.setText("Cambiar");
        btnCambiarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCorreoActionPerformed(evt);
            }
        });

        iblApellido.setText("Apellidos:");

        iblRFC.setText("RFC");

        iblCURP.setText("CURP:");

        iblPlaca.setText("Placa:");

        iblCorreo1.setText("Contraseña:");

        txtContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlContenidoLayout = new javax.swing.GroupLayout(pnlContenido);
        pnlContenido.setLayout(pnlContenidoLayout);
        pnlContenidoLayout.setHorizontalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenidoLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iblCorreo1)
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCambiarContraseña))
                    .addComponent(iblCorreo)
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCambiarPlaca))
                    .addComponent(iblRFC)
                    .addComponent(iblCURP)
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCambiarRfc))
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCurp, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iblGenero, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGenero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContenidoLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnCambiarGenero))
                            .addGroup(pnlContenidoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCambiarCurp))
                            .addGroup(pnlContenidoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnVolverPedidos)
                                    .addComponent(btnCambiarCorreo)))))
                    .addComponent(iblPlaca)
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCambiarApellidos))
                    .addComponent(iblNombre)
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iblApellido, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCambiarNombre)))
                .addGap(33, 33, 33))
        );
        pnlContenidoLayout.setVerticalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(iblApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iblGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iblRFC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iblCURP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarCurp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(iblPlaca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iblCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iblCorreo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarContraseña))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnVolverPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnVolverPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverPedidosActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverPedidosActionPerformed

    private void btnCambiarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarNombreActionPerformed
        CambiarNombreDialogo();
    }//GEN-LAST:event_btnCambiarNombreActionPerformed

    private void btnCambiarApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarApellidosActionPerformed
        CambiarApellidosDialogo();
    }//GEN-LAST:event_btnCambiarApellidosActionPerformed

    private void btnCambiarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarGeneroActionPerformed
        CambiarGeneroDialogo();
    }//GEN-LAST:event_btnCambiarGeneroActionPerformed

    private void btnCambiarRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarRfcActionPerformed
        CambiarRfcDialogo();
    }//GEN-LAST:event_btnCambiarRfcActionPerformed

    private void btnCambiarCurpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarCurpActionPerformed
        CambiarCurpDialogo();
    }//GEN-LAST:event_btnCambiarCurpActionPerformed

    private void btnCambiarPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarPlacaActionPerformed
        CambiarPlacaDialogo();
    }//GEN-LAST:event_btnCambiarPlacaActionPerformed

    private void btnCambiarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarCorreoActionPerformed
        CambiarCorreoDialogo();
    }//GEN-LAST:event_btnCambiarCorreoActionPerformed

    private void btnCambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraseñaActionPerformed
        VCambiarContra.getInstance(idUsuario, this).setVisible(true);
        VCambiarContra.getInstance(idUsuario, this).setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnCambiarContraseñaActionPerformed

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed

    }//GEN-LAST:event_txtContrasenaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarApellidos;
    private javax.swing.JButton btnCambiarContraseña;
    private javax.swing.JButton btnCambiarCorreo;
    private javax.swing.JButton btnCambiarCurp;
    private javax.swing.JButton btnCambiarGenero;
    private javax.swing.JButton btnCambiarNombre;
    private javax.swing.JButton btnCambiarPlaca;
    private javax.swing.JButton btnCambiarRfc;
    private javax.swing.JButton btnVolverPedidos;
    private javax.swing.JLabel iblApellido;
    private javax.swing.JLabel iblCURP;
    private javax.swing.JLabel iblCorreo;
    private javax.swing.JLabel iblCorreo1;
    private javax.swing.JLabel iblGenero;
    private javax.swing.JLabel iblNombre;
    private javax.swing.JLabel iblPlaca;
    private javax.swing.JLabel iblRFC;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtRfc;
    // End of variables declaration//GEN-END:variables

    private void CambiarNombreDialogo() {
        String nuevoNombre = JOptionPane.showInputDialog(this, "Ingresa el nuevo nombre:");
        if (nuevoNombre != null && check.validName(nuevoNombre)) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres actualizar el nombre?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Connection con = new ConexionDB().deliverConnection();
                    String sql = "UPDATE repartidores SET nombre = ? WHERE id_usuario = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, nuevoNombre);
                    ps.setInt(2, idUsuario);
                    int rows = ps.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "Nombre actualizado exitosamente.");
                        txtNombre.setText(nuevoNombre);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo actualizar el nombre.");
                    }
                    ps.close();
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
                }
            }
        }
    }

    private void CambiarApellidosDialogo() {
        String nuevoApellido = JOptionPane.showInputDialog(this, "Ingresa el nuevo apellido:");
        if (nuevoApellido != null && check.validLastname(nuevoApellido)) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres actualizar el apellido?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Connection con = new ConexionDB().deliverConnection();
                    String sql = "UPDATE repartidores SET apellidos = ? WHERE id_usuario = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, nuevoApellido);
                    ps.setInt(2, idUsuario);
                    int rows = ps.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "Apellido actualizado exitosamente.");
                        txtApellidos.setText(nuevoApellido);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo actualizar el apellido.");
                    }
                    ps.close();
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
                }
            }
        }
    }

    private void CambiarGeneroDialogo() {
        String nuevoGenero = JOptionPane.showInputDialog(this, "Ingresa el nuevo género:");
        if (nuevoGenero != null && check.validGender(nuevoGenero)) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres actualizar el género?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Connection con = new ConexionDB().deliverConnection();
                    String sql = "UPDATE repartidores SET genero = ? WHERE id_usuario = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, nuevoGenero);
                    ps.setInt(2, idUsuario);
                    int rows = ps.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "Género actualizado exitosamente.");
                        txtGenero.setText(nuevoGenero);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo actualizar el género.");
                    }
                    ps.close();
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
                }
            }
        }
    }

    private void CambiarRfcDialogo() {
        String nuevoRfc = JOptionPane.showInputDialog(this, "Ingresa el nuevo RFC:");
        if (nuevoRfc != null && check.validRFC(nuevoRfc)) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres actualizar el RFC?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Connection con = new ConexionDB().deliverConnection();
                    String sql = "UPDATE repartidores SET rfc = ? WHERE id_usuario = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, nuevoRfc);
                    ps.setInt(2, idUsuario);
                    int rows = ps.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "RFC actualizado exitosamente.");
                        txtRfc.setText(nuevoRfc);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo actualizar el RFC.");
                    }
                    ps.close();
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
                }
            }
        }
    }

    private void CambiarCurpDialogo() {
        String nuevoCurp = JOptionPane.showInputDialog(this, "Ingresa el nuevo CURP:");
        if (nuevoCurp != null && check.validCURP(nuevoCurp)) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres actualizar el CURP?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Connection con = new ConexionDB().deliverConnection();
                    String sql = "UPDATE repartidores SET curp = ? WHERE id_usuario = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, nuevoCurp);
                    ps.setInt(2, idUsuario);
                    int rows = ps.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "CURP actualizado exitosamente.");
                        txtCurp.setText(nuevoCurp);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo actualizar el CURP.");
                    }
                    ps.close();
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
                }
            }
        }
    }

    private void CambiarPlacaDialogo() {
        String nuevaPlaca = JOptionPane.showInputDialog(this, "Ingresa la nueva placa:");
        if (nuevaPlaca != null && check.validPlate(nuevaPlaca)) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres actualizar la placa?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Connection con = new ConexionDB().deliverConnection();
                    String sql = "UPDATE repartidores SET placa = ? WHERE id_usuario = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, nuevaPlaca);
                    ps.setInt(2, idUsuario);
                    int rows = ps.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "Placa actualizada exitosamente.");
                        txtPlaca.setText(nuevaPlaca);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo actualizar la placa.");
                    }
                    ps.close();
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
                }
            }
        }
    }

    private void CambiarCorreoDialogo() {
        String nuevoCorreo = JOptionPane.showInputDialog(this, "Ingresa el nuevo correo:");
        if (nuevoCorreo != null && check.validEmail(nuevoCorreo)) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres actualizar el correo?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Connection con = new ConexionDB().deliverConnection();
                    String sql = "UPDATE usuarios SET correo = ? WHERE id_usuario = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, nuevoCorreo);
                    ps.setInt(2, idUsuario);
                    int rows = ps.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "Correo actualizado exitosamente.");
                        txtCorreo.setText(nuevoCorreo);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo actualizar el correo.");
                    }
                    ps.close();
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
                }
            }
        }
    }
    
    public static VEditarRepartidor getInstance(int id) {
        if (instancia == null || !instancia.isDisplayable()) {
            instancia = new VEditarRepartidor(id);
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
}

