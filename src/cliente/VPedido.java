package cliente;

import java.math.BigDecimal;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import main.AbrirVentana;
import main.Main;

public class VPedido extends javax.swing.JFrame {
    BigDecimal total = BigDecimal.ZERO;
    public static VPedido instancia = null;
    
    private VPedido(BigDecimal total) {
        
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        
        this.total = total;
        
        lblTotal.setText("Total:    $"+total);
    }
    
    ClienteDB client = new ClienteDB();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPedido = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblMetodoPago = new javax.swing.JLabel();
        cbxMetodoPago = new javax.swing.JComboBox<>();
        lblTotal = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRealizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaComentario = new javax.swing.JTextArea();
        lblSugerencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPedido.setText("Pedido");

        lblDireccion.setText("Dirección:");

        lblMetodoPago.setText("Metodo de pago:");

        cbxMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta", "Transferencia" }));

        lblTotal.setText("Total:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        btnRealizar.setText("Realizar Pedido");
        btnRealizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRealizarMouseClicked(evt);
            }
        });

        txaComentario.setColumns(20);
        txaComentario.setRows(5);
        jScrollPane1.setViewportView(txaComentario);

        lblSugerencia.setText("¿Alguna sugerencia sobre tu pedido? Escribela aqui");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnRealizar)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMetodoPago)
                            .addComponent(lblDireccion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotal)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSugerencia)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotal)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMetodoPago)
                    .addComponent(cbxMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(lblSugerencia, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRealizar)
                    .addComponent(btnCancelar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
        AbrirVentana.getInstance().vCart();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnRealizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRealizarMouseClicked
        String adress = txtDireccion.getText();
        String pay = cbxMetodoPago.getSelectedItem().toString().toLowerCase();
        int idC = client.getClientId(Main.getInstance().getId());
        String comment = txaComentario.getText();
        
        if(!adress.isBlank()){
            client.createOrder(adress, pay, idC, total, comment);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Por favor ingrese la direccion");
        }
    }//GEN-LAST:event_btnRealizarMouseClicked
    
    public static VPedido getInstance(BigDecimal total) {
        if (instancia == null || !instancia.isDisplayable()) {
            instancia = new VPedido(total);
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
    private javax.swing.JButton btnRealizar;
    private javax.swing.JComboBox<String> cbxMetodoPago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblMetodoPago;
    private javax.swing.JLabel lblPedido;
    private javax.swing.JLabel lblSugerencia;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextArea txaComentario;
    private javax.swing.JTextField txtDireccion;
    // End of variables declaration//GEN-END:variables
}
