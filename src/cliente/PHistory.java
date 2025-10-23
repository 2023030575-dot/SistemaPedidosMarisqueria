package cliente;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import main.Main;

public class PHistory extends JPanel {
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JButton btnRegresar;
    private JPanel ordersListPanel;
    private final ClienteDB client;

    public PHistory() {
        client = new ClienteDB();
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(580, 310));
        setBorder(BorderFactory.createEtchedBorder());

        initComponents();
        
        loadOrders();
    }

    private void initComponents() {
        JPanel topPanel = new JPanel(new BorderLayout());
        txtBuscar = new JTextField();
        txtBuscar.setPreferredSize(new Dimension(360, 30));
        txtBuscar.addActionListener(e -> searchDoneOrders());

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> searchDoneOrders());

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
        ordersListPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        ordersListPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        JScrollPane scrollPane = new JScrollPane(ordersListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadOrders() {
        ordersListPanel.removeAll();
        ArrayList<PedidoR> orders = client.getClientOrders(client.getClientId(Main.getInstance().getId()));

        if (orders.isEmpty()) {
            ordersListPanel.add(new JLabel("No hay pedidos."));
        } else {
            for (PedidoR order : orders) {
                ordersListPanel.add(createOrderRow(order));
            }
            
        }

        ordersListPanel.revalidate();
        ordersListPanel.repaint();
    }

    private void searchDoneOrders() {
        String searchTerm = txtBuscar.getText().trim();
        ordersListPanel.removeAll();

        if (searchTerm.isEmpty()) {
            loadOrders();
            return;
        }

        ArrayList<PedidoR> filteredOrders = client.searchClientOrders(searchTerm, client.getClientId(Main.getInstance().getId()));
        if (filteredOrders.isEmpty()) {
            ordersListPanel.add(new JLabel("No se encontraron pedidos que coincidan."));
        } else {
            for (PedidoR order : filteredOrders) {
                ordersListPanel.add(createOrderRow(order));
            }
        }

        ordersListPanel.revalidate();
        ordersListPanel.repaint();
    }

    private JPanel createOrderRow(PedidoR order) {
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
        
        ArrayList<PlatilloC> platillos = client.loadOrderDishes(order.getId());
        for (PlatilloC p : platillos) {
            txaPlatillos.append(p.getCantidad() + " x " + p.getNombre() + "\n");
        }
        txaPlatillos.setEditable(false);
        txaPlatillos.setHighlighter(null);
        txaPlatillos.setCaretColor(new java.awt.Color(0,0,0,0));
        txaPlatillos.setCaretPosition(0);

        JScrollPane scrollPlatillos = new JScrollPane(txaPlatillos);
        scrollPlatillos.setPreferredSize(new Dimension(200, 80));
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        JLabel infoLabel = new JLabel("<html><b>Dirección:</b> " + order.getAdress() +
                "<br><b>Total:</b> $" + order.getTotal() + "</html>");
        centerPanel.add(infoLabel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        JButton btnVer = new JButton("Ver");
        btnVer.addActionListener(e -> viewOrder(order));

        buttonsPanel.add(Box.createVerticalGlue());
        buttonsPanel.add(btnVer);
        buttonsPanel.add(Box.createVerticalGlue());

        rowPanel.add(scrollPlatillos, BorderLayout.WEST);
        rowPanel.add(centerPanel, BorderLayout.CENTER);
        rowPanel.add(buttonsPanel, BorderLayout.EAST);

        return rowPanel;
    }

    private void viewOrder(PedidoR order) {
        JOptionPane.showMessageDialog(null, 
        "Repartidor: " + order.getRepartidor()+ "\n"+
        "Fecha: " + order.getDate()+ "\n"+
        "Hora de realización: " + order.getTimeR()+ "\n" +
        "Hora de entrega: "+order.getTimeE()+ "\n" +
        "Total: $" + order.getTotal()+ "\n" + 
        "Metodo de pago: " + order.getPay()+ "\n" +
        "Comentario: " +order.getComment(),
        "Detalles del Pedido",
        JOptionPane.INFORMATION_MESSAGE);
    }
}

class PedidoR{
    private final int id;
    private final String repartidor;
    private final String adress;
    private final String date;
    private final String timeR;
    private final String timeE;
    private final BigDecimal total;
    private final String pay;
    private final String comment;

    public PedidoR(int id, String cliente, String adress, String date, String timeR, String timeE, BigDecimal total, String pay, String comment) {
        this.id = id;
        this.repartidor = cliente;
        this.adress = adress;
        this.date = date;
        this.timeR = timeR;
        this.timeE = timeE;
        this.total = total;
        this.pay = pay;
        this.comment = comment;
    }

    public int getId() { return id; }
    public String getRepartidor() { return repartidor; }
    public String getAdress() { return adress; }
    public String getDate() { return date; }
    public String getTimeR() { return timeR; }
    public String getTimeE() { return timeE; }
    public BigDecimal getTotal() { return total; }
    public String getPay() { return pay; }
    public String getComment() { return comment; }
}

class PlatilloC {
    private final String nombre;
    private final int cantidad;

    public PlatilloC(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
}