package admin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PDelivers extends JPanel {
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JButton btnRegresar;
    private JPanel deliversListPanel;
    private final UsuarioDB usuariosDB;
    private final int idP;
    private final POrders pnlPedidos;
    public PDelivers(int idP, POrders pnlPedidos) {
        this.idP = idP;
        this.pnlPedidos = pnlPedidos;
        usuariosDB = new UsuarioDB();
        setBorder(BorderFactory.createEtchedBorder());
        setPreferredSize(new Dimension(250, 200));
        initComponents();
        loadDelivers();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());  
        
        JPanel topPanel = new JPanel(new BorderLayout());
        txtBuscar = new JTextField();
        txtBuscar.setPreferredSize(new Dimension(270,30));
        txtBuscar.addActionListener(e -> searchDelivers());
        btnBuscar = new JButton("Buscar");  
        btnBuscar.addActionListener(e -> searchDelivers());
        btnRegresar = new JButton("Regresar");
        btnRegresar.setPreferredSize(new Dimension(90,30));
        btnRegresar.addActionListener(e -> loadDelivers());
        
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(txtBuscar, BorderLayout.WEST);
        searchPanel.add(btnBuscar, BorderLayout.CENTER);  
        searchPanel.add(btnRegresar, BorderLayout.EAST); 
        topPanel.add(searchPanel, BorderLayout.CENTER);
        deliversListPanel = new JPanel();
        deliversListPanel.setLayout(new BoxLayout(deliversListPanel, BoxLayout.Y_AXIS));
        deliversListPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        deliversListPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        
        JScrollPane scrollPane = new JScrollPane(deliversListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void loadDelivers() {
        deliversListPanel.removeAll();
        
        ArrayList<Deliver> delivers = usuariosDB.getActiveDelivers();
        if (delivers.isEmpty()) {
            deliversListPanel.add(new JLabel("No hay repartidores libres."));
        } else {
            for (Deliver deliver : delivers) {
                deliversListPanel.add(createDeliverRow(deliver));
            }
        }
        
        deliversListPanel.revalidate();
        deliversListPanel.repaint();
    }
    
    private JPanel createDeliverRow(Deliver deliver) {
        JPanel rowPanel = new JPanel(new BorderLayout());
        rowPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setPreferredSize(new Dimension(200, 40));
        JLabel deliverInfo = new JLabel(deliver.getId() + ": "+ deliver.getName()+" "+deliver.getLastname());
        deliverInfo.setPreferredSize(new Dimension(200, 30));
        infoPanel.add(deliverInfo);
        
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.setPreferredSize(new Dimension(200, 40));
        JButton viewButton = new JButton("Ver");
        viewButton.setPreferredSize(new Dimension(55, 25));
        viewButton.addActionListener(e -> showDeliverDetails(deliver));
        JButton assignButton = new JButton("Asignar");
        assignButton.setPreferredSize(new Dimension(100, 25));
        assignButton.addActionListener(e -> assignOrder(deliver, idP));   
        buttonsPanel.add(viewButton);
        buttonsPanel.add(assignButton);
        
        rowPanel.add(infoPanel, BorderLayout.CENTER);
        rowPanel.add(buttonsPanel, BorderLayout.EAST);
        return rowPanel;
    }
    
    private void searchDelivers() {
        String searchTerm = txtBuscar.getText().trim();
        if (searchTerm.isEmpty()) {
            loadDelivers();
            return;
        } 
        deliversListPanel.removeAll();
        
        ArrayList<Deliver> filteredDelivers = usuariosDB.searchDelivers(searchTerm);
        if (filteredDelivers.isEmpty()) {
            deliversListPanel.add(new JLabel("No se encontraron repartidores"));
        } else {
            for (Deliver deliver : filteredDelivers) {
                deliversListPanel.add(createDeliverRow(deliver));
            }
        }
        
        deliversListPanel.revalidate();
        deliversListPanel.repaint();
    }
    
    private void showDeliverDetails(Deliver deliver) {
        JOptionPane.showMessageDialog(null, 
        "ID: " + deliver.getId() + "\n" +
        "Nombre(s): " + deliver.getName()+ "\n"+
        "Apellidos: " + deliver.getLastname()+ "\n"+
        "Genero: " + deliver.getGender()+ "\n" +
        "RFC: " + deliver.getRfc()+ "\n" + 
        "CURP: " + deliver.getCurp()+ "\n"+
        "Placa: " + deliver.getPlate(),
        "Detalles del Usuario",
        JOptionPane.INFORMATION_MESSAGE); 
    }
    
    public void assignOrder(Deliver deliver, int idP){
        if(usuariosDB.assignOrder(idP, deliver.getId())){
            pnlPedidos.updateOrders();
            SwingUtilities.getWindowAncestor(this).dispose();
        }
    }
    
    public JButton getBtnBuscar() {
        return btnBuscar;
    }
    
    public JTextField getTxtBuscar() {
        return txtBuscar;
    }
}

class Deliver {
    private final int id;
    private final String name;
    private final String lastname;
    private final String gender;
    private final String rfc;
    private final String curp;
    private final String plate;

    public Deliver(int id, String name, String lastname, String gender, String rfc, String curp, String plate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.rfc = rfc;
        this.curp = curp;
        this.plate = plate;
    }

    public int getId() {
        return id; 
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public String getRfc() {
        return rfc;
    }

    public String getCurp() {
        return curp;
    }

    public String getPlate() {
        return plate;
    }
    
}
