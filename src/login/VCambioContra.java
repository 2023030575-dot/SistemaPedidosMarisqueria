package login;

import java.awt.Color;
import javax.swing.JOptionPane;
import main.AbrirVentana;

public class VCambioContra extends javax.swing.JFrame {

    public VCambioContra() {
        setUndecorated(true);
        initComponents();
        
        txtContrasena.setEnabled(false);
        txtConfirmarContrasena.setEnabled(false);
        btnCambiarContrasena.setEnabled(false);
        
        getContentPane().removeAll();
        getContentPane().setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = java.awt.GridBagConstraints.CENTER;
        getContentPane().add(pnlContenido, gbc);
    }
    
    Login login = new Login(); 
    Verificacion check = new Verificacion();
    
    int code;
    String email;
    boolean verificado = false; 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenido = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnEnviarCorreo = new javax.swing.JButton();
        btnConfirmarCodigo = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        txtConfirmarContrasena = new javax.swing.JPasswordField();
        btnCambiarContrasena = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        pnlConfirmacion = new javax.swing.JPanel();
        lblConfirmacion = new javax.swing.JLabel();
        lblCorreo1 = new javax.swing.JLabel();
        lblCorreo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("CAMBIAR CONTRASEÑA");

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });

        lblCorreo.setText("Correo:");

        txtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoFocusLost(evt);
            }
        });

        btnEnviarCorreo.setText("Enviar Código");
        btnEnviarCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarCorreoMouseClicked(evt);
            }
        });

        btnConfirmarCodigo.setText("Confirmar");
        btnConfirmarCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarCodigoMouseClicked(evt);
            }
        });
        btnConfirmarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarCodigoActionPerformed(evt);
            }
        });

        lblCodigo.setText("Código:");

        txtContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContrasenaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContrasenaFocusLost(evt);
            }
        });

        txtConfirmarContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtConfirmarContrasenaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConfirmarContrasenaFocusLost(evt);
            }
        });

        btnCambiarContrasena.setText("Cambiar contraseña");
        btnCambiarContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCambiarContrasenaMouseClicked(evt);
            }
        });

        btnRegresar.setText("Iniciar sesión");
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        pnlConfirmacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblConfirmacion.setForeground(new java.awt.Color(255, 0, 0));
        lblConfirmacion.setText("Sin Confirmar");

        javax.swing.GroupLayout pnlConfirmacionLayout = new javax.swing.GroupLayout(pnlConfirmacion);
        pnlConfirmacion.setLayout(pnlConfirmacionLayout);
        pnlConfirmacionLayout.setHorizontalGroup(
            pnlConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConfirmacionLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(lblConfirmacion)
                .addGap(14, 14, 14))
        );
        pnlConfirmacionLayout.setVerticalGroup(
            pnlConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfirmacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConfirmacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCorreo1.setText("Nueva Contraseña:");

        lblCorreo2.setText("Confirmar Contraseña:");

        javax.swing.GroupLayout pnlContenidoLayout = new javax.swing.GroupLayout(pnlContenido);
        pnlContenido.setLayout(pnlContenidoLayout);
        pnlContenidoLayout.setHorizontalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoLayout.createSequentialGroup()
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1))
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCorreo)
                            .addComponent(lblCodigo)
                            .addComponent(lblCorreo1)
                            .addComponent(lblCorreo2))
                        .addGap(18, 18, 18)
                        .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlContenidoLayout.createSequentialGroup()
                                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                    .addComponent(txtCorreo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEnviarCorreo)
                                    .addComponent(btnConfirmarCodigo)))
                            .addComponent(txtConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenidoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenidoLayout.createSequentialGroup()
                        .addComponent(btnCambiarContrasena)
                        .addGap(189, 189, 189))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenidoLayout.createSequentialGroup()
                        .addComponent(pnlConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenidoLayout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(207, 207, 207))))
        );
        pnlContenidoLayout.setVerticalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo)
                    .addComponent(btnEnviarCorreo))
                .addGap(18, 18, 18)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmarCodigo)
                    .addComponent(lblCodigo))
                .addGap(18, 18, 18)
                .addComponent(pnlConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo1))
                .addGap(27, 27, 27)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo2))
                .addGap(18, 18, 18)
                .addComponent(btnCambiarContrasena)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained

    }//GEN-LAST:event_txtCorreoFocusGained

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost

    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtCodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusGained

    }//GEN-LAST:event_txtCodigoFocusGained

    private void txtCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusLost

    }//GEN-LAST:event_txtCodigoFocusLost

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEnviarCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarCorreoMouseClicked
        email = txtCorreo.getText();
        if(check.existingEmail(email)){ 
            code = login.sendCode(email);
        }else{        
            JOptionPane.showMessageDialog(null,"Correo invalido");        
        }     
    }//GEN-LAST:event_btnEnviarCorreoMouseClicked

    private void btnConfirmarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCodigoActionPerformed

    }//GEN-LAST:event_btnConfirmarCodigoActionPerformed

    private void btnConfirmarCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarCodigoMouseClicked
        if(code == 0){ 
            JOptionPane.showMessageDialog(null,"Código no enviado");     
        }else{     
            if(txtCodigo.getText().equals(String.valueOf(code))){    
                verificado = true;
                lblConfirmacion.setText("Confirmado");
                lblConfirmacion.setForeground(new Color(0,153,0));
                txtContrasena.setEnabled(true);
                txtConfirmarContrasena.setEnabled(true);
                btnCambiarContrasena.setEnabled(true);
            }else{                
                JOptionPane.showMessageDialog(null, "Código Incorrecto");              
            }            
        }
    }//GEN-LAST:event_btnConfirmarCodigoMouseClicked

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        this.dispose(); 
        AbrirVentana.getInstance().vLogin(); 
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void txtContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaFocusGained

    }//GEN-LAST:event_txtContrasenaFocusGained

    private void txtConfirmarContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmarContrasenaFocusGained

    }//GEN-LAST:event_txtConfirmarContrasenaFocusGained

    private void txtContrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaFocusLost

    }//GEN-LAST:event_txtContrasenaFocusLost

    private void txtConfirmarContrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmarContrasenaFocusLost

    }//GEN-LAST:event_txtConfirmarContrasenaFocusLost

    private void btnCambiarContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarContrasenaMouseClicked
        if(lblConfirmacion.getText().equals("Confirmado")){
           String pass = new String(txtContrasena.getPassword()); 
            String cPass = new String(txtConfirmarContrasena.getPassword());
            if(check.validPass(pass,cPass)){ 
                if(login.changePass(pass, email)){
                    this.dispose();
                    AbrirVentana.getInstance().vLogin();
                }  
            }else{ 
                JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");  
            } 
        }else{
            JOptionPane.showMessageDialog(null,"No se ha verificado el codigo");
        }
        
    }//GEN-LAST:event_btnCambiarContrasenaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarContrasena;
    private javax.swing.JButton btnConfirmarCodigo;
    private javax.swing.JButton btnEnviarCorreo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblConfirmacion;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCorreo1;
    private javax.swing.JLabel lblCorreo2;
    private javax.swing.JPanel pnlConfirmacion;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JPasswordField txtConfirmarContrasena;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
