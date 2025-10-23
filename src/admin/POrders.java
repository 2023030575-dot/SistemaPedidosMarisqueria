package admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class POrders extends JPanel{
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JButton btnRegresar;
    private JPanel ordersListPanel;
    private final UsuarioDB usuariosDB;
    
    public POrders() {
        usuariosDB = new UsuarioDB();
        
        setBorder(BorderFactory.createEtchedBorder());
        setPreferredSize(new Dimension(650, 400));
        
        initComponents();
        
        loadOrders();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new BorderLayout());
        txtBuscar = new JTextField();
        txtBuscar.setPreferredSize(new Dimension(440,30));
        txtBuscar.addActionListener(e -> searchOrders());
        btnBuscar = new JButton("Buscar");  
        btnBuscar.addActionListener(e -> searchOrders());
        btnRegresar = new JButton("Regresar");
        btnRegresar.setPreferredSize(new Dimension(90,30));
        btnRegresar.addActionListener(e -> loadOrders());
        
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(txtBuscar, BorderLayout.WEST);
        searchPanel.add(btnBuscar, BorderLayout.CENTER);  
        searchPanel.add(btnRegresar, BorderLayout.EAST); 
        topPanel.add(searchPanel, BorderLayout.CENTER);
        ordersListPanel = new JPanel();
        ordersListPanel.setLayout(new BoxLayout(ordersListPanel, BoxLayout.Y_AXIS));
        
        JScrollPane scrollPane = new JScrollPane(ordersListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void loadOrders() {
        ordersListPanel.removeAll();
        
        ArrayList<Order> orders = usuariosDB.getPendingOrders();
        if (orders.isEmpty()) {
            ordersListPanel.add(new JLabel("No hay pedidos nuevos."));
        } else {
            for (Order order : orders) {
                ordersListPanel.add(createOrderRow(order));
            }
        }
        
        ordersListPanel.revalidate();
        ordersListPanel.repaint();
    }
    
    private JPanel createOrderRow(Order order) {
        JPanel rowPanel = new JPanel(new BorderLayout());
        rowPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setPreferredSize(new Dimension(200, 40));
        JLabel orderInfo = new JLabel(order.getId() + ": Direccion: "+order.getAdress()+" : Total $"+order.getTotal());
        orderInfo.setPreferredSize(new Dimension(300, 30));
        infoPanel.add(orderInfo);
        
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.setPreferredSize(new Dimension(240, 40));
        JButton viewButton = new JButton("Ver");
        viewButton.setPreferredSize(new Dimension(55, 25));
        viewButton.addActionListener(e -> showOrderDetails(order));
        JButton assignButton = new JButton("Asignar Repartidor");
        assignButton.setPreferredSize(new Dimension(150, 25));
        assignButton.addActionListener(e -> assignDeliver(order.getId()));   
        buttonsPanel.add(viewButton);
        buttonsPanel.add(assignButton);
        
        rowPanel.add(infoPanel, BorderLayout.CENTER);
        rowPanel.add(buttonsPanel, BorderLayout.EAST);
        return rowPanel;
    }
    
    private void searchOrders() {
        String searchTerm = txtBuscar.getText().trim();
        if (searchTerm.isEmpty()) {
            loadOrders();
            return;
        } 
        ordersListPanel.removeAll();
        
        ArrayList<Order> filteredUsers = usuariosDB.searchOrders(searchTerm);
        if (filteredUsers.isEmpty()) {
            ordersListPanel.add(new JLabel("No se encontraron pedidos"));
        } else {
            for (Order order : filteredUsers) {
                ordersListPanel.add(createOrderRow(order));
            }
        }
        
        ordersListPanel.revalidate();
        ordersListPanel.repaint();
    }
    
    private void showOrderDetails(Order order) {
        VInfoPedido.getInstance(order).setLocationRelativeTo(null);
        VInfoPedido.getInstance(order).setVisible(true);
    }
    
    private void assignDeliver(int idP){
        VAsignar.getInstance(idP, this).setLocationRelativeTo(null);
        VAsignar.getInstance(idP, this).setVisible(true);
    }
    
    public void updateOrders() {
        loadOrders();
        revalidate();
        repaint();
    }
    
    public JButton getBtnBuscar() {
        return btnBuscar;
    }
    
    public JTextField getTxtBuscar() {
        return txtBuscar;
    }
}

class Order {
    private final int id;
    private final int idC;
    private final String adress;
    private final String date;
    private final String timeR;
    private final BigDecimal total;
    private final String pay;
    private String comment;

    public Order(int id, int idC, String adress, String date, String timeR, BigDecimal total, String pay, String comment) {
        this.id = id;
        this.idC = idC;
        this.adress = adress;
        this.date = date;
        this.timeR = timeR;
        this.total = total;
        this.pay = pay;
        this.comment = comment;
    }

    public int getId() {
        return id; 
    }

    public int getIdC() {
        return idC;
    }

    public String getAdress() {
        return adress;
    }

    public String getDate() {
        return date;
    }

    public String getTimeR() {
        return timeR;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getPay() {
        return pay;
    }

    public String getComment() {
        return comment;
    }
    
}
