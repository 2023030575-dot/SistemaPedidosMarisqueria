package cliente;

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
import main.Main;

public class PCarrito extends JPanel{
    private JPanel dishesListPanel;
    ClienteDB client = new ClienteDB();
    private BigDecimal totalGeneral = BigDecimal.ZERO;
    
    public PCarrito() {
        setBorder(BorderFactory.createEtchedBorder());
        setPreferredSize(new Dimension(500, 200));
        
        initComponents();
        
        loadDishes();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());  
        dishesListPanel = new JPanel();
        dishesListPanel.setLayout(new BoxLayout(dishesListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(dishesListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void loadDishes() {
        dishesListPanel.removeAll();
        totalGeneral = BigDecimal.ZERO;
        ArrayList<Cart> carts = client.getCarrito(client.getClientId(Main.getInstance().getId()));

        if (carts.isEmpty()) {
            dishesListPanel.add(new JLabel("Su carrito está vacío."));
        } else {
            for (Cart cart : carts) {
                BigDecimal totalPlatillo = cart.getCost().multiply(BigDecimal.valueOf(cart.getAmount()));
                totalGeneral = totalGeneral.add(totalPlatillo);
                dishesListPanel.add(createDishRow(cart, totalPlatillo));
            }
        }

        dishesListPanel.revalidate();
        dishesListPanel.repaint();
    }
    
    private JPanel createDishRow(Cart cart, BigDecimal totalPlatillo) {
        JPanel rowPanel = new JPanel(new BorderLayout());
        rowPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        JPanel dishPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dishPanel.setPreferredSize(new Dimension(200, 40));
        JLabel dishInfo = new JLabel(cart.getAmount() + " " + cart.getName() + " $" + totalPlatillo);
        dishInfo.setPreferredSize(new Dimension(200, 30));
        dishPanel.add(dishInfo);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.setPreferredSize(new Dimension(150, 40));
        JButton deleteButton = new JButton("Eliminar");
        deleteButton.setPreferredSize(new Dimension(80, 25));
        deleteButton.addActionListener(e -> deleteDish(cart));
        buttonsPanel.add(deleteButton);

        rowPanel.add(dishPanel, BorderLayout.CENTER);
        rowPanel.add(buttonsPanel, BorderLayout.EAST);
        return rowPanel;
    }
    
    public void deleteDish(Cart cart){
        client.deleteDish(cart.getId());
        loadDishes();
    }
    
    public BigDecimal getTotalGeneral() {
        return totalGeneral;
    }  
}

class Cart {
    private final int id;
    private final int idC;
    private final int idP;
    private final int amount;
    private final String name;
    private final BigDecimal cost;
    
    public Cart(int id, int idC, int idP, int amount, String name, BigDecimal cost) {
        this.id = id;
        this.idC = idC;
        this.idP = idP;
        this.amount = amount;
        this.name = name;
        this.cost = cost;
    }

    public int getId() { return id; }
    public int getIdC() { return idC; }
    public int getIdP() { return idP; }
    public int getAmount(){ return amount; }
    public String getName() { return name; }
    public BigDecimal getCost() { return cost; }
}

