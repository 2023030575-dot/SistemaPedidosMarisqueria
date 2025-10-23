package cliente;

import javax.swing.*;

public class VCantidad extends JDialog {

    private int cantidad = 0; 
    private JSpinner spnCantidad;
    private JButton btnAgregar, btnCancelar;
    private JLabel lblCantidad;

    public VCantidad(JFrame parent) {
        super(parent, "Seleccionar cantidad", true);
        initComponents();
    }

    private void initComponents() {
        spnCantidad = new JSpinner(new SpinnerNumberModel(1, 1, null, 1));
        lblCantidad = new JLabel("¿Qué cantidad desea agregar?");
        btnAgregar = new JButton("Agregar");
        btnCancelar = new JButton("Cancelar");

        btnAgregar.addActionListener(e -> {
            cantidad = Integer.parseInt(spnCantidad.getValue().toString());
            dispose();
        });

        btnCancelar.addActionListener(e -> {
            dispose();
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        lblCantidad.setAlignmentX(CENTER_ALIGNMENT);
        spnCantidad.setAlignmentX(CENTER_ALIGNMENT);
        btnAgregar.setAlignmentX(CENTER_ALIGNMENT);
        btnCancelar.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(10));
        add(lblCantidad);
        add(Box.createVerticalStrut(10));
        add(spnCantidad);
        add(Box.createVerticalStrut(10));
        add(btnAgregar);
        add(Box.createVerticalStrut(5));
        add(btnCancelar);
        add(Box.createVerticalStrut(10));

        pack();
        setLocationRelativeTo(getParent());
    }

    public int mostrarYEsperar() {
        this.setVisible(true);
        return cantidad;
    }
}