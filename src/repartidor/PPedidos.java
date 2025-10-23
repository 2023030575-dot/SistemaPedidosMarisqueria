package repartidor;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import main.Main;

public class PPedidos extends JPanel {
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JButton btnRegresar;
    private JPanel ordersListPanel;
    private final repartidorDB deliver;

    public PPedidos() {
        deliver = new repartidorDB();
        
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEtchedBorder());

        initComponents();
        
        loadOrders();
    }

    private void initComponents() {
        JPanel topPanel = new JPanel(new BorderLayout());
        txtBuscar = new JTextField();
        txtBuscar.setPreferredSize(new Dimension(440, 30));
        txtBuscar.addActionListener(e -> searchOrders());

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> searchOrders());

        btnRegresar = new JButton("Regresar");
        btnRegresar.setPreferredSize(new Dimension(90, 30));
        btnRegresar.addActionListener(e -> loadOrders());

        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(txtBuscar, BorderLayout.WEST);
        searchPanel.add(btnBuscar, BorderLayout.CENTER);
        searchPanel.add(btnRegresar, BorderLayout.EAST);

        topPanel.add(searchPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        ordersListPanel = new JPanel();
        ordersListPanel.setLayout(new BoxLayout(ordersListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(ordersListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadOrders() {
        ordersListPanel.removeAll();
        ArrayList<Pedido> orders = deliver.getActiveOrders(deliver.getDeliverId(Main.getInstance().getId()));

        if (orders.isEmpty()) {
            ordersListPanel.add(new JLabel("No hay pedidos pendientes de entrega."));
        } else {
            for (Pedido order : orders) {
                ordersListPanel.add(createOrderRow(order));
            }
            
        }

        ordersListPanel.revalidate();
        ordersListPanel.repaint();
    }

    private void searchOrders() {
        String searchTerm = txtBuscar.getText().trim();
        ordersListPanel.removeAll();

        if (searchTerm.isEmpty()) {
            loadOrders();
            return;
        }

        ArrayList<Pedido> filteredOrders = deliver.searchOrders(searchTerm);
        if (filteredOrders.isEmpty()) {
            ordersListPanel.add(new JLabel("No se encontraron pedidos que coincidan."));
        } else {
            for (Pedido order : filteredOrders) {
                ordersListPanel.add(createOrderRow(order));
            }
        }

        ordersListPanel.revalidate();
        ordersListPanel.repaint();
    }

    private JPanel createOrderRow(Pedido order) {
        JPanel rowPanel = new JPanel(new BorderLayout(10, 10));
        rowPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        JTextArea txaPlatillos = new JTextArea();
        txaPlatillos.setEditable(false);
        txaPlatillos.setCaretColor(new Color(0, 0, 0, 0));
        txaPlatillos.setRows(4);
        txaPlatillos.setColumns(20);
        txaPlatillos.setLineWrap(true);
        txaPlatillos.setWrapStyleWord(true);
        
        ArrayList<Platillo> platillos = deliver.loadOrderDishes(order.getId());
        for (Platillo p : platillos) {
            txaPlatillos.append(p.getCantidad() + " x " + p.getNombre() + "\n");
        }
        txaPlatillos.setEditable(false);
        txaPlatillos.setHighlighter(null); 
        txaPlatillos.setCaretColor(new java.awt.Color(0,0,0,0));

        JScrollPane scrollPlatillos = new JScrollPane(txaPlatillos);
        scrollPlatillos.setPreferredSize(new Dimension(200, 80));
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        JLabel infoLabel = new JLabel("<html><b>ID:</b> " + order.getId() +
                "<br><b>Dirección:</b> " + order.getAdress() +
                "<br><b>Total:</b> $" + order.getTotal() + "</html>");
        centerPanel.add(infoLabel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        JButton btnVer = new JButton("Ver");
        btnVer.addActionListener(e -> viewOrder(order));
        JButton btnEntregado = new JButton("Entregado");
        btnEntregado.addActionListener(e -> completeOrder(order.getId()));

        buttonsPanel.add(btnVer);
        buttonsPanel.add(Box.createVerticalStrut(10));
        buttonsPanel.add(btnEntregado);

        rowPanel.add(scrollPlatillos, BorderLayout.WEST);
        rowPanel.add(centerPanel, BorderLayout.CENTER);
        rowPanel.add(buttonsPanel, BorderLayout.EAST);

        return rowPanel;
    }

    private void viewOrder(Pedido order) {
        JOptionPane.showMessageDialog(null, 
        "ID: " + order.getId() + "\n" +
        "Cliente: " + order.getCliente()+ "\n"+
        "Fecha: " + order.getDate()+ "\n"+
        "Hora de realización: " + order.getTimeR()+ "\n" +
        "Total: $" + order.getTotal()+ "\n" + 
        "Metodo de pago: " + order.getPay()+ "\n" +
        "Comentario: " + order.getComment(),
        "Detalles del Pedido",
        JOptionPane.INFORMATION_MESSAGE);
    }

    private void completeOrder(int idP) {
        deliver.completeOrder(idP);
        loadOrders();
    }
}

class Pedido{
    private final int id;
    private final String cliente;
    private final String adress;
    private final String date;
    private final String timeR;
    private final BigDecimal total;
    private final String pay;
    private final String comment;

    public Pedido(int id, String cliente, String adress, String date, String timeR, BigDecimal total, String pay, String comment) {
        this.id = id;
        this.cliente = cliente;
        this.adress = adress;
        this.date = date;
        this.timeR = timeR;
        this.total = total;
        this.pay = pay;
        this.comment = comment;
    }

    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public String getAdress() { return adress; }
    public String getDate() { return date; }
    public String getTimeR() { return timeR; }
    public BigDecimal getTotal() { return total; }
    public String getPay() { return pay; }  
    public String getComment() { return comment; }
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