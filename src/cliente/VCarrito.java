package cliente;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import main.Main;

public class VCarrito extends javax.swing.JFrame {
    private PCarrito pCarrito = new PCarrito();
    private static VCarrito instancia = null;
    
    private VCarrito() {
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        pCarrito = new PCarrito();
        pnlPlatillos.setVisible(false);
        pnlPlatillos.getParent().add(pCarrito);
        pCarrito.setBounds(pnlPlatillos.getBounds());
        lblTotal.setText("Total: $"+pCarrito.getTotalGeneral().toString());
    }
    
    ClienteDB client = new ClienteDB();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnRealizar = new javax.swing.JButton();
        lblOrden = new javax.swing.JLabel();
        pnlPlatillos = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Carrito");

        btnRealizar.setText("Realizar pedido");
        btnRealizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRealizarMouseClicked(evt);
            }
        });
        btnRealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarActionPerformed(evt);
            }
        });

        lblOrden.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblOrden.setText("Orden:");

        pnlPlatillos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlPlatillosLayout = new javax.swing.GroupLayout(pnlPlatillos);
        pnlPlatillos.setLayout(pnlPlatillosLayout);
        pnlPlatillosLayout.setHorizontalGroup(
            pnlPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );
        pnlPlatillosLayout.setVerticalGroup(
            pnlPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );

        btnCerrar.setText("Cerrar Carrito");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        lblTotal.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(lblOrden))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(pnlPlatillos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCerrar)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotal)
                            .addComponent(btnRealizar))))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOrden)
                .addGap(18, 18, 18)
                .addComponent(pnlPlatillos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRealizar)
                    .addComponent(btnCerrar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarActionPerformed
        
    }//GEN-LAST:event_btnRealizarActionPerformed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnRealizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRealizarMouseClicked
        if(!client.EmptyCart(client.getClientId(Main.getInstance().getId()))){
            this.dispose();
            VPedido.getInstance(pCarrito.getTotalGeneral()).setLocationRelativeTo(null);
            VPedido.getInstance(pCarrito.getTotalGeneral()).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"El carrito esta vacio");
        }     
    }//GEN-LAST:event_btnRealizarMouseClicked

    public static VCarrito getInstance() {
        if (instancia == null || !instancia.isDisplayable()) {
            instancia = new VCarrito();
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
    private javax.swing.JButton btnRealizar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblOrden;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlPlatillos;
    // End of variables declaration//GEN-END:variables
}
