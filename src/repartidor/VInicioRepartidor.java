package repartidor;

import main.AbrirVentana;

public class VInicioRepartidor extends javax.swing.JFrame {
    int idUsuario;
    private PPedidos pPedidos;
    
    public VInicioRepartidor(int idUsuario) {
        this.idUsuario = idUsuario;

        setUndecorated(true);
        initComponents();

        pPedidos = new PPedidos();
        pnlPedidos.setVisible(false);
        pnlPedidos.getParent().add(pPedidos);
        pPedidos.setBounds(pnlPedidos.getBounds());

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

        pnlContenido = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        pnlPedidos = new javax.swing.JPanel();
        pnlBottom = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JButton();
        pnlTop = new javax.swing.JPanel();
        pnlSubtitulo = new javax.swing.JPanel();
        lblSubtitulo = new javax.swing.JLabel();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlContenido.setPreferredSize(new java.awt.Dimension(680, 480));
        pnlContenido.setLayout(new java.awt.BorderLayout());

        pnlCenter.setPreferredSize(new java.awt.Dimension(650, 400));
        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlPedidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlPedidos.setPreferredSize(new java.awt.Dimension(650, 400));

        javax.swing.GroupLayout pnlPedidosLayout = new javax.swing.GroupLayout(pnlPedidos);
        pnlPedidos.setLayout(pnlPedidosLayout);
        pnlPedidosLayout.setHorizontalGroup(
            pnlPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );
        pnlPedidosLayout.setVerticalGroup(
            pnlPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );

        pnlCenter.add(pnlPedidos, java.awt.BorderLayout.CENTER);

        pnlContenido.add(pnlCenter, java.awt.BorderLayout.CENTER);

        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseClicked(evt);
            }
        });
        pnlBottom.add(btnCerrarSesion);

        pnlContenido.add(pnlBottom, java.awt.BorderLayout.SOUTH);

        pnlTop.setLayout(new java.awt.BorderLayout());

        pnlSubtitulo.setPreferredSize(new java.awt.Dimension(680, 35));
        pnlSubtitulo.setLayout(new java.awt.BorderLayout());

        lblSubtitulo.setText("Pedidos Activos:");
        lblSubtitulo.setVerifyInputWhenFocusTarget(false);
        pnlSubtitulo.add(lblSubtitulo, java.awt.BorderLayout.WEST);

        pnlTop.add(pnlSubtitulo, java.awt.BorderLayout.SOUTH);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulo.setText("Bienvenido, Repartidor");
        pnlTitulo.add(lblTitulo);

        pnlTop.add(pnlTitulo, java.awt.BorderLayout.NORTH);

        btnHistorial.setText("Historial");
        btnHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistorialMouseClicked(evt);
            }
        });
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        pnlTop.add(btnHistorial, java.awt.BorderLayout.WEST);

        btnPerfil.setText("Perfil");
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilMouseClicked(evt);
            }
        });
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });
        pnlTop.add(btnPerfil, java.awt.BorderLayout.EAST);

        pnlContenido.add(pnlTop, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed

    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed

    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseClicked
        this.dispose();
        AbrirVentana.getInstance().vLogin();
    }//GEN-LAST:event_btnCerrarSesionMouseClicked

    private void btnHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseClicked
        AbrirVentana.getInstance().vHistorialRep();
    }//GEN-LAST:event_btnHistorialMouseClicked

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        AbrirVentana.getInstance().DeliverProfile(idUsuario);
    }//GEN-LAST:event_btnPerfilMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JPanel pnlPedidos;
    private javax.swing.JPanel pnlSubtitulo;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JPanel pnlTop;
    // End of variables declaration//GEN-END:variables
}
