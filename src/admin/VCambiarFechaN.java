package admin;

import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import login.Verificacion;
import main.AbrirVentana;

public class VCambiarFechaN extends javax.swing.JFrame {
    int id;
    String origen;
    public static VCambiarFechaN instancia = null;
    
    private VCambiarFechaN(int id, String origen) {
        this.origen = origen;
        this.id = id;
        
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
    }
    
    Verificacion check = new Verificacion();
    ConexionDB db = new ConexionDB();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFechaNacimiento = new javax.swing.JLabel();
        spnDia = new javax.swing.JSpinner();
        spnMes = new javax.swing.JSpinner();
        spnAnio = new javax.swing.JSpinner();
        btnCambiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFechaNacimiento.setText("Fecha de Nacimiento:");

        spnDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        spnDia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                spnDiaFocusGained(evt);
            }
        });

        spnMes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spnAnio.setModel(new javax.swing.SpinnerNumberModel(2000, 1960, 2050, 1));

        btnCambiar.setText("Cambiar");
        btnCambiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCambiarMouseClicked(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCambiar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFechaNacimiento)
                        .addGap(12, 12, 12)
                        .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaNacimiento))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCambiar)
                    .addComponent(btnCancelar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spnDiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spnDiaFocusGained
            
    }//GEN-LAST:event_spnDiaFocusGained

    private void btnCambiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarMouseClicked
            String dia = spnDia.getValue().toString();
            String mes = spnMes.getValue().toString();
            String anio = spnAnio.getValue().toString();
            
            if(check.validDate(dia, mes, anio)){
                String fecha = spnAnio.getValue().toString()+"/"+spnMes.getValue().toString()+"/"+spnDia.getValue().toString();
                cambiarFechaNacimiento(fecha);
                
            }else{
                JOptionPane.showMessageDialog(null,"Fecha invalida");
            }
            
            this.dispose();
            this.regresar();
            
    }//GEN-LAST:event_btnCambiarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
        this.regresar();
    }//GEN-LAST:event_btnCancelarMouseClicked
    
    public void cambiarFechaNacimiento(String birthdate){
        Connection con = db.adminConnection();
        if(con != null){
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres actualizar el correo?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try{                
                    String sql = "UPDATE clientes SET fecha_nacimiento = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1,birthdate);
                    int filasActualizadas = ps.executeUpdate();
                    if(filasActualizadas > 0){
                        JOptionPane.showMessageDialog(null, "Se actualizo correctamente la fecha de nacimiento");
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Error al realizar la consulta:"+e);
                }

            }else{
                JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion");
            }
        }
    }
    
    private void regresar(){
        if(origen.equals("admin")){
            AbrirVentana.getInstance().vEditClient(id);
        }else if(origen.equals("cliente")){
            AbrirVentana.getInstance().vClientUser(id);
        }
    }
    
    public static VCambiarFechaN getInstance(int id, String origin) {
        if (instancia == null || !instancia.isDisplayable()) {
            instancia = new VCambiarFechaN(id, origin);
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
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JSpinner spnAnio;
    private javax.swing.JSpinner spnDia;
    private javax.swing.JSpinner spnMes;
    // End of variables declaration//GEN-END:variables
}
