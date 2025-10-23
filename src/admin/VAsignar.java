package admin;

import javax.swing.JFrame;

public class VAsignar extends javax.swing.JFrame {
    PDelivers pDelivers;
    private final POrders pnlPedidos;
    public static VAsignar instancia = null;
    
    private VAsignar(int idP, POrders pnlPedidos) {
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        
        this.pnlPedidos = pnlPedidos;
        pDelivers = new PDelivers(idP, pnlPedidos);
        pnlRepartidores.setVisible(false);
        pnlRepartidores.getParent().add(pDelivers);
        pDelivers.setBounds(pnlRepartidores.getBounds());
        lblPedido.setText("Asignar Pedido #"+idP);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenido = new javax.swing.JPanel();
        pnlTop = new javax.swing.JPanel();
        lblPedido = new javax.swing.JLabel();
        pnlBottom = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        pnlRepartidores = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlContenido.setLayout(new java.awt.BorderLayout());
        pnlContenido.add(pnlTop, java.awt.BorderLayout.NORTH);

        lblPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPedido.setText("Asignar Pedido #---");
        lblPedido.setToolTipText("");
        lblPedido.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblPedido.setPreferredSize(new java.awt.Dimension(133, 30));
        pnlContenido.add(lblPedido, java.awt.BorderLayout.NORTH);
        lblPedido.getAccessibleContext().setAccessibleParent(pnlTop);

        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(88, 25));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlBottom.add(btnCancelar);

        pnlContenido.add(pnlBottom, java.awt.BorderLayout.SOUTH);

        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlRepartidores.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlRepartidoresLayout = new javax.swing.GroupLayout(pnlRepartidores);
        pnlRepartidores.setLayout(pnlRepartidoresLayout);
        pnlRepartidoresLayout.setHorizontalGroup(
            pnlRepartidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );
        pnlRepartidoresLayout.setVerticalGroup(
            pnlRepartidoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        pnlCenter.add(pnlRepartidores, java.awt.BorderLayout.CENTER);

        pnlContenido.add(pnlCenter, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    public static VAsignar getInstance(int idP, POrders pnlPedidos) {
        if (instancia == null || !instancia.isDisplayable()) {
            instancia = new VAsignar(idP, pnlPedidos);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblPedido;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JPanel pnlRepartidores;
    private javax.swing.JPanel pnlTop;
    // End of variables declaration//GEN-END:variables
}
