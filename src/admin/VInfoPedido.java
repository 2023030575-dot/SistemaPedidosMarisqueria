package admin;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

public class VInfoPedido extends javax.swing.JFrame {
    Order order;
    UsuarioDB user = new UsuarioDB();
    public static VInfoPedido instancia = null; 
    
    private VInfoPedido(Order order) {
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        
        txaComentario.setEditable(false);
        txaComentario.setCaretColor(new Color(0,0,0,0));
        txaComentario.setHighlighter(null);
        
        this.order = order;
        
        lblPedido.setText("Pedido #"+order.getId());
        lblIdC.setText("ID de cliente: "+order.getIdC());
        lblFecha.setText("Fecha: "+order.getDate());
        lblHora.setText("Hora: "+order.getTimeR());
        lblDireccion.setText("Direccion: "+order.getAdress());
        lblMetodo.setText("Metodo de pago: "+order.getPay());
        lblTotal.setText("Total: $"+order.getTotal());
        txaComentario.append(order.getComment());
        ArrayList<Platillo> platillos = user.loadOrderDishes(order.getId());
        for (Platillo p : platillos) {
            txaPlatillos.append(p.getCantidad() + " x " + p.getNombre() + "\n");
        }
        txaPlatillos.setEditable(false);
        txaPlatillos.setHighlighter(null); 
        txaPlatillos.setCaretColor(new java.awt.Color(0,0,0,0));
        txaPlatillos.setCaretPosition(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPedido = new javax.swing.JLabel();
        lblIdC = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblMetodo = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblPlatillos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaPlatillos = new javax.swing.JTextArea();
        lblComentario = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaComentario = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPedido.setText("Pedido #---");

        lblIdC.setText("ID de cliente:");

        lblHora.setText("Hora de realización:");

        lblDireccion.setText("Dirección:");

        lblMetodo.setText("Metodo de pago:");

        lblTotal.setText("Total:");

        lblPlatillos.setText("Platillos:");

        jButton1.setText("Cerrar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        lblFecha.setText("Fecha:");

        txaPlatillos.setColumns(20);
        txaPlatillos.setRows(5);
        jScrollPane1.setViewportView(txaPlatillos);

        lblComentario.setText("Comentario:");

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txaComentario.setColumns(20);
        txaComentario.setRows(5);
        jScrollPane2.setViewportView(txaComentario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMetodo)
                            .addComponent(lblDireccion)
                            .addComponent(lblHora)
                            .addComponent(lblFecha)
                            .addComponent(lblIdC))
                        .addGap(242, 242, 242))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTotal)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblPlatillos)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblComentario)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(lblPedido)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblPedido)
                .addGap(18, 18, 18)
                .addComponent(lblIdC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFecha)
                .addGap(14, 14, 14)
                .addComponent(lblHora)
                .addGap(18, 18, 18)
                .addComponent(lblDireccion)
                .addGap(18, 18, 18)
                .addComponent(lblMetodo)
                .addGap(18, 18, 18)
                .addComponent(lblTotal)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblComentario)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlatillos)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked
    
    public static VInfoPedido getInstance(Order order) {
        if (instancia == null || !instancia.isDisplayable()) {
            instancia = new VInfoPedido(order);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblComentario;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblIdC;
    private javax.swing.JLabel lblMetodo;
    private javax.swing.JLabel lblPedido;
    private javax.swing.JLabel lblPlatillos;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextArea txaComentario;
    private javax.swing.JTextArea txaPlatillos;
    // End of variables declaration//GEN-END:variables
}

class Platillo {
    private final String nombre;
    private final int cantidad;

    public Platillo(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }

    public int getCantidad() { return cantidad; }
}
