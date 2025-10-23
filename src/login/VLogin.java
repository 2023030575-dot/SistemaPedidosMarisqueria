package login;

import admin.VInicioAdmin;
import cliente.ClienteDB;
import main.Main;
import main.AbrirVentana;
import admin.AdminDB;

public class VLogin extends javax.swing.JFrame { 
    AdminDB admin = new AdminDB();
    public VLogin() {
        
        setUndecorated(true);
        
        admin.deactivateUsers();
        
        initComponents();
        
        getContentPane().removeAll();
        getContentPane().setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = java.awt.GridBagConstraints.CENTER;
        getContentPane().add(pnlContenido, gbc);
        txtCorreo.addActionListener(e -> {
            if(!txtContrasena.getText().isBlank()){
                iniciarSesion();
            }else{
                txtContrasena.requestFocusInWindow();
            }
        });
        txtContrasena.addActionListener(e -> {
            if(!txtCorreo.getText().isBlank()){
                iniciarSesion();
            }else{
                txtCorreo.requestFocusInWindow();
            }
        });
    }
    
    Login login = new Login();
    Verificacion check = new Verificacion();
    ClienteDB client = new ClienteDB();
    VCambioContra cambio = new VCambioContra();
 
    public int id = 0;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlContenido = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        lblRegistro = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        lblRecuperarContra = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        lblCorreo1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        LblTituloLogin = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlContenido.setPreferredSize(new java.awt.Dimension(2000, 2000));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblRegistro.setText("¿Aún no tienes cuenta? Regístrate aquí");
        lblRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistroMouseClicked(evt);
            }
        });

        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseClicked(evt);
            }
        });

        lblRecuperarContra.setText("¿No recuerdas tu contraseña? Recuperala aquí");
        lblRecuperarContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRecuperarContraMouseClicked(evt);
            }
        });

        txtContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContrasenaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContrasenaFocusLost(evt);
            }
        });
        txtContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaActionPerformed(evt);
            }
        });

        lblCorreo1.setText("Contraseña:");

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        lblCorreo.setText("Correo:");

        LblTituloLogin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LblTituloLogin.setText("INICIO DE SESIÓN");
        LblTituloLogin.setMaximumSize(new java.awt.Dimension(94, 20));
        LblTituloLogin.setMinimumSize(new java.awt.Dimension(94, 20));

        javax.swing.GroupLayout pnlContenidoLayout = new javax.swing.GroupLayout(pnlContenido);
        pnlContenido.setLayout(pnlContenidoLayout);
        pnlContenidoLayout.setHorizontalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoLayout.createSequentialGroup()
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(LblTituloLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblRecuperarContra)
                        .addGroup(pnlContenidoLayout.createSequentialGroup()
                            .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCorreo1)
                                .addComponent(lblCorreo))
                            .addGap(18, 18, 18)
                            .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCorreo)
                                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnIniciarSesion))
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(lblRegistro))
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnSalir)))
                .addGap(0, 51, Short.MAX_VALUE))
        );
        pnlContenidoLayout.setVerticalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(LblTituloLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo1)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblRecuperarContra)
                .addGap(18, 18, 18)
                .addComponent(btnIniciarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRegistro)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void lblRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistroMouseClicked
        this.dispose();
        AbrirVentana.getInstance().vRegister();
    }//GEN-LAST:event_lblRegistroMouseClicked

    private void btnIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseClicked
        iniciarSesion(); 
    }//GEN-LAST:event_btnIniciarSesionMouseClicked

    private void lblRecuperarContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRecuperarContraMouseClicked
        this.dispose(); 
        AbrirVentana.getInstance().vChangePass(); 
    }//GEN-LAST:event_lblRecuperarContraMouseClicked

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed

    }//GEN-LAST:event_txtContrasenaActionPerformed

    private void txtContrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaFocusLost

    }//GEN-LAST:event_txtContrasenaFocusLost

    private void txtContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaFocusGained

    }//GEN-LAST:event_txtContrasenaFocusGained

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed

    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost

    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained

    }//GEN-LAST:event_txtCorreoFocusGained

    private void iniciarSesion(){ 
        
        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();
        
        if(check.confirmLogin(correo,contrasena)){ 
            
            int id = login.getUserId(correo);
            Main.getInstance().setId(id);
            
            String tipo = login.getUserType(Main.getInstance().getId()); 
            
            this.dispose(); 
            
            switch(tipo){ 
                
                case "cliente" -> { 
                    AbrirVentana.getInstance().vClientMain(client.getClientName(Main.getInstance().getId()));
                }
                case "repartidor" -> { 
                    AbrirVentana.getInstance().vDeliverMain(Main.getInstance().getId()); 
                }
                case "administrador" -> { 
                    VInicioAdmin.getInstance().getPUsers().cargarUsuarios(); 
                    AbrirVentana.getInstance().vAdminMain(); 
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblTituloLogin;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCorreo1;
    private javax.swing.JLabel lblRecuperarContra;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
