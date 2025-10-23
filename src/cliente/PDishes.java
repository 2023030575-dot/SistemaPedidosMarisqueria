package cliente;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import main.Main;

public class PDishes extends JPanel {
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JButton btnRegresar;
    private JPanel dishesListPanel;
    ClienteDB client = new ClienteDB();
    
    public PDishes() {
        setBorder(BorderFactory.createEtchedBorder());
        setPreferredSize(new Dimension(500, 200));
        initComponents();
        loadDishes();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());  
        
        JPanel topPanel = new JPanel(new BorderLayout());
        txtBuscar = new JTextField();
        txtBuscar.setPreferredSize(new Dimension(370,30));
        txtBuscar.addActionListener(e -> searchDishes());
        btnBuscar = new JButton("Buscar");  
        btnBuscar.addActionListener(e -> searchDishes());
        btnRegresar = new JButton("Regresar");
        btnRegresar.setPreferredSize(new Dimension(90,30));
        btnRegresar.addActionListener(e -> loadDishes());
        
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(txtBuscar, BorderLayout.WEST);
        searchPanel.add(btnBuscar, BorderLayout.CENTER);  
        searchPanel.add(btnRegresar, BorderLayout.EAST); 
        topPanel.add(searchPanel, BorderLayout.CENTER);
        dishesListPanel = new JPanel();
        dishesListPanel.setLayout(new BoxLayout(dishesListPanel, BoxLayout.Y_AXIS));
        
        JScrollPane scrollPane = new JScrollPane(dishesListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void loadDishes() {
        dishesListPanel.removeAll();
        
        ArrayList<Dish> dishes = client.getAllDishes();
        if (dishes.isEmpty()) {
            dishesListPanel.add(new JLabel("No hay platillos registrados."));
        } else {
            for (Dish dish : dishes) {
                dishesListPanel.add(createDishRow(dish));
            }
        }
        
        dishesListPanel.revalidate();
        dishesListPanel.repaint();
    }
    
    private JPanel createDishRow(Dish dish) {
        JPanel rowPanel = new JPanel(new BorderLayout());
        rowPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        JPanel dishPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dishPanel.setPreferredSize(new Dimension(200, 40));
        
        JLabel dishInfo = new JLabel(dish.getName()+"  $"+dish.getCost());
        dishInfo.setPreferredSize(new Dimension(230, 30));
        dishPanel.add(dishInfo);
        
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.setPreferredSize(new Dimension(240, 40));
        JButton viewButton = new JButton("Ver");
        viewButton.setPreferredSize(new Dimension(55, 25));
        viewButton.addActionListener(e -> showDishDetails(dish));
        JButton addButton = new JButton("Añadir al carrito");
        addButton.setPreferredSize(new Dimension(140, 25));
        addButton.addActionListener(e -> addDish(dish));   
        buttonsPanel.add(viewButton);
        buttonsPanel.add(addButton);
        
        rowPanel.add(dishPanel, BorderLayout.CENTER);
        rowPanel.add(buttonsPanel, BorderLayout.EAST);
        return rowPanel;
    }
    
    private void searchDishes() {
        String searchTerm = txtBuscar.getText().trim();
        if (searchTerm.isEmpty()) {
            loadDishes();
            return;
        } 
        dishesListPanel.removeAll();
        
        ArrayList<Dish> filteredUsers = client.searchDishes(searchTerm);
        if (filteredUsers.isEmpty()) {
            dishesListPanel.add(new JLabel("No se encontraron platillos"));
        } else {
            for (Dish dish : filteredUsers) {
                dishesListPanel.add(createDishRow(dish));
            }
        }
        
        dishesListPanel.revalidate();
        dishesListPanel.repaint();
    }
    
    private void showDishDetails(Dish dish) {
        JOptionPane.showMessageDialog(null, 
        "Platillo: " + dish.getName()+ "\n" +
        "Descripcion: " + dish.getDescription()+ "\n"+
        "Costo: " + dish.getCost(),
        "Detalles del Platillo",
        JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void addDish(Dish dish){
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        VCantidad dialogo = new VCantidad(parentFrame);
        int amount = dialogo.mostrarYEsperar();
        
        if(amount != 0){
            int idC = client.getClientId(Main.getInstance().getId());
            int idP = dish.getId();
            client.addDish(idC, idP, amount);
        }
    }
    
    public JButton getBtnBuscar() {
        return btnBuscar;
    }
    
    public JTextField getTxtBuscar() {
        return txtBuscar;
    }
}

class Dish {
    private final int id;
    private final String name;
    private final String description;
    private final BigDecimal cost;

    public Dish(int id, String name, String description, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getCost(){ return cost; }
}
