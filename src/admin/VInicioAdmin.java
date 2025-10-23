package admin;

import main.AbrirVentana;

public class VInicioAdmin extends javax.swing.JFrame {
    private PUsers pUsers;
    private POrders pOrders;
    public static VInicioAdmin instancia = null;
    
    private VInicioAdmin() {
        setUndecorated(true);
        initComponents();
        pUsers = new PUsers();
        pnlAdmin.setVisible(false);
        pnlAdmin.getParent().add(pUsers);
        pUsers.setBounds(pnlAdmin.getBounds());
        rdbUsuarios.setSelected(true);
        rdbUsuarios.addActionListener( e -> {
            pOrders.setVisible(false);
            btnCrearUsuario.setVisible(true);
            pUsers = new PUsers();
            pUsers.cargarUsuarios();
            pOrders.getParent().add(pUsers);
            pUsers.setBounds(pnlAdmin.getBounds());
        });
        rdbPedidos.addActionListener( e -> {
            pUsers.setVisible(false);
            btnCrearUsuario.setVisible(false);
            pOrders = new POrders();
            pUsers.getParent().add(pOrders);
            pOrders.setBounds(pnlAdmin.getBounds());
        });
              
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgAdmin = new javax.swing.ButtonGroup();
        pnlContenido = new javax.swing.JPanel();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlCenter = new javax.swing.JPanel();
        pnlTop = new javax.swing.JPanel();
        btnCrearUsuario = new javax.swing.JButton();
        pnlTopWest = new javax.swing.JPanel();
        rdbPedidos = new javax.swing.JRadioButton();
        lblUsuarios = new javax.swing.JLabel();
        rdbUsuarios = new javax.swing.JRadioButton();
        pnlAdmin = new javax.swing.JPanel();
        pnlBottom = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlContenido.setLayout(new java.awt.BorderLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("Bienvenido, Administrador");
        pnlTitulo.add(lblTitulo);

        pnlContenido.add(pnlTitulo, java.awt.BorderLayout.NORTH);

        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlTop.setMinimumSize(new java.awt.Dimension(101, 70));
        pnlTop.setLayout(new java.awt.BorderLayout());

        btnCrearUsuario.setText("Crear Usuario");
        btnCrearUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCrearUsuario.setPreferredSize(new java.awt.Dimension(120, 20));
        btnCrearUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearUsuarioMouseClicked(evt);
            }
        });
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });
        pnlTop.add(btnCrearUsuario, java.awt.BorderLayout.EAST);

        pnlTopWest.setLayout(new java.awt.BorderLayout());

        btgAdmin.add(rdbPedidos);
        rdbPedidos.setText("Pedidos");
        pnlTopWest.add(rdbPedidos, java.awt.BorderLayout.EAST);

        lblUsuarios.setText("Administrar:");
        lblUsuarios.setFocusable(false);
        lblUsuarios.setMaximumSize(new java.awt.Dimension(20, 16));
        lblUsuarios.setMinimumSize(new java.awt.Dimension(20, 16));
        pnlTopWest.add(lblUsuarios, java.awt.BorderLayout.WEST);

        btgAdmin.add(rdbUsuarios);
        rdbUsuarios.setText("Usuarios");
        rdbUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbUsuariosActionPerformed(evt);
            }
        });
        pnlTopWest.add(rdbUsuarios, java.awt.BorderLayout.CENTER);

        pnlTop.add(pnlTopWest, java.awt.BorderLayout.WEST);

        pnlCenter.add(pnlTop, java.awt.BorderLayout.NORTH);

        pnlAdmin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlAdmin.setPreferredSize(new java.awt.Dimension(700, 400));

        javax.swing.GroupLayout pnlAdminLayout = new javax.swing.GroupLayout(pnlAdmin);
        pnlAdmin.setLayout(pnlAdminLayout);
        pnlAdminLayout.setHorizontalGroup(
            pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        pnlAdminLayout.setVerticalGroup(
            pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pnlCenter.add(pnlAdmin, java.awt.BorderLayout.CENTER);

        pnlBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseClicked(evt);
            }
        });
        pnlBottom.add(btnCerrarSesion);

        pnlCenter.add(pnlBottom, java.awt.BorderLayout.PAGE_END);

        pnlContenido.add(pnlCenter, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseClicked
        this.dispose();
        AbrirVentana.getInstance().vLogin();
    }//GEN-LAST:event_btnCerrarSesionMouseClicked

    private void btnCrearUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearUsuarioMouseClicked
        this.dispose();
        AbrirVentana.getInstance().vCreateUser();
    }//GEN-LAST:event_btnCrearUsuarioMouseClicked

    private void rdbUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbUsuariosActionPerformed

    }//GEN-LAST:event_rdbUsuariosActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed

    }//GEN-LAST:event_btnCrearUsuarioActionPerformed
    
    public static VInicioAdmin getInstance() {
        if (instancia == null || !instancia.isDisplayable()) {
            instancia = new VInicioAdmin();
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
    
    public PUsers getPUsers(){
        return pUsers;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgAdmin;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JPanel pnlAdmin;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JPanel pnlTopWest;
    private javax.swing.JRadioButton rdbPedidos;
    private javax.swing.JRadioButton rdbUsuarios;
    // End of variables declaration//GEN-END:variables
}
