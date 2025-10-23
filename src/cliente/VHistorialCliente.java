package cliente;

import javax.swing.JFrame;

public class VHistorialCliente extends javax.swing.JFrame {
    public static VHistorialCliente instancia = null;
    PHistory pHistorial;
    
    private VHistorialCliente() {
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
                
        pHistorial = new PHistory();
        pnlHistorial.setVisible(false);
        pnlHistorial.getParent().add(pHistorial);
        pHistorial.setBounds(pnlHistorial.getBounds());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel10 = new javax.swing.JLabel();
        pnlContenido = new javax.swing.JPanel();
        pnlTop = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlBottom = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        scrollHistorial = new javax.swing.JScrollPane();
        pnlHistorial = new javax.swing.JPanel();

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(51, 255, 51));
        jLabel10.setText("COMPLETADO");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlContenido.setLayout(new java.awt.BorderLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulo.setText("Historial de Pedidos");
        pnlTop.add(lblTitulo);

        pnlContenido.add(pnlTop, java.awt.BorderLayout.NORTH);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlBottom.add(btnCerrar);

        pnlContenido.add(pnlBottom, java.awt.BorderLayout.SOUTH);

        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlHistorial.setPreferredSize(new java.awt.Dimension(580, 310));

        javax.swing.GroupLayout pnlHistorialLayout = new javax.swing.GroupLayout(pnlHistorial);
        pnlHistorial.setLayout(pnlHistorialLayout);
        pnlHistorialLayout.setHorizontalGroup(
            pnlHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        pnlHistorialLayout.setVerticalGroup(
            pnlHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        scrollHistorial.setViewportView(pnlHistorial);

        pnlCenter.add(scrollHistorial, java.awt.BorderLayout.PAGE_START);

        pnlContenido.add(pnlCenter, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose(); 
    }//GEN-LAST:event_btnCerrarActionPerformed
    
    public static VHistorialCliente getInstance() {
        if (instancia == null || !instancia.isDisplayable()) {
            instancia = new VHistorialCliente();
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
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JPanel pnlHistorial;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JScrollPane scrollHistorial;
    // End of variables declaration//GEN-END:variables
}

