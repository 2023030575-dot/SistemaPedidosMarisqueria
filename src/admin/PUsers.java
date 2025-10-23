package admin;

import cliente.ClienteDB;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import main.AbrirVentana;
import main.Main;
import repartidor.repartidorDB;

public class PUsers extends JPanel {
    private JButton btnCrearUsuario;
    private JButton btnAjustes;
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JButton btnRegresar;
    private JPanel usersListPanel;
    private final UsuarioDB usuariosDB;
    
    ClienteDB client = new ClienteDB();
    repartidorDB deliver = new repartidorDB();
    AdminDB admin = new AdminDB();
    
    public PUsers() {
        usuariosDB = new UsuarioDB();
        
        setBorder(BorderFactory.createEtchedBorder());
        setPreferredSize(new Dimension(650, 400));
        
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new BorderLayout());
        txtBuscar = new JTextField();
        txtBuscar.setPreferredSize(new Dimension(440,30));
        txtBuscar.addActionListener(e -> searchUsers());
        btnBuscar = new JButton("Buscar");  
        btnBuscar.addActionListener(e -> searchUsers());
        btnRegresar = new JButton("Regresar");
        btnRegresar.setPreferredSize(new Dimension(90,30));
        btnRegresar.addActionListener(e -> loadUsers());
        
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(txtBuscar, BorderLayout.WEST);
        searchPanel.add(btnBuscar, BorderLayout.CENTER);  
        searchPanel.add(btnRegresar, BorderLayout.EAST); 
        topPanel.add(searchPanel, BorderLayout.CENTER);
        usersListPanel = new JPanel();
        usersListPanel.setLayout(new BoxLayout(usersListPanel, BoxLayout.Y_AXIS));
        
        JScrollPane scrollPane = new JScrollPane(usersListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void loadUsers() {
        usersListPanel.removeAll();
        
        ArrayList<User> users = usuariosDB.getAllUsers();
        if (users.isEmpty()) {
            usersListPanel.add(new JLabel("No hay usuarios registrados."));
        } else {
            for (User user : users) {
                usersListPanel.add(createUserRow(user));
            }
        }
        
        usersListPanel.revalidate();
        usersListPanel.repaint();
    }
    
    private JPanel createUserRow(User user) {
        JPanel rowPanel = new JPanel(new BorderLayout());
        if(user.getActive().equals("si")){
            rowPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            infoPanel.setPreferredSize(new Dimension(200, 40));
            JLabel userInfo = new JLabel(user.getId() + ": "+ user.getEmail()+" : "+user.getType());
            userInfo.setPreferredSize(new Dimension(300, 30));
            infoPanel.add(userInfo);
            JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            buttonsPanel.setPreferredSize(new Dimension(240, 40));
            JButton viewButton = new JButton("Ver");
            viewButton.setPreferredSize(new Dimension(55, 25));
            viewButton.addActionListener(e -> showUserDetails(user));
            JButton editButton = new JButton("Editar");
            editButton.setPreferredSize(new Dimension(70, 25));
            editButton.addActionListener(e -> editUser(user));   
            buttonsPanel.add(viewButton);
            buttonsPanel.add(editButton);
            if (user.getId() != Main.getInstance().getId() && !user.getType().equals("cliente")) {
                JButton deactivateButton = new JButton("Desactivar");
                deactivateButton.setPreferredSize(new Dimension(95, 25));
                deactivateButton.addActionListener(e -> deactivateUser(user));
                buttonsPanel.add(deactivateButton);
           }
            rowPanel.add(infoPanel, BorderLayout.CENTER);
            rowPanel.add(buttonsPanel, BorderLayout.EAST);
           
        }else if(user.getActive().equals("no")){
            rowPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            infoPanel.setPreferredSize(new Dimension(200, 40));
            JLabel userInfo = new JLabel(user.getId() + ": "+ user.getEmail()+" : "+user.getType()+" : inactivo");
            userInfo.setPreferredSize(new Dimension(330, 30));
            infoPanel.add(userInfo);
            JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            buttonsPanel.setPreferredSize(new Dimension(210, 40));
            JButton viewButton = new JButton("Ver");
            viewButton.setPreferredSize(new Dimension(55, 25));
            viewButton.addActionListener(e -> showUserDetails(user));   
            JButton activateButton = new JButton("Activar");
            activateButton.setPreferredSize(new Dimension(80, 25));
            activateButton.addActionListener(e -> reactivateUser(user));
            buttonsPanel.add(viewButton);
            buttonsPanel.add(activateButton);
            rowPanel.add(infoPanel, BorderLayout.CENTER);
            rowPanel.add(buttonsPanel, BorderLayout.EAST);
        }
        
        return rowPanel;
    }
    
    private void searchUsers() {
        String searchTerm = txtBuscar.getText().trim();
        if (searchTerm.isEmpty()) {
            loadUsers();
            return;
        } 
        usersListPanel.removeAll();
        
        ArrayList<User> filteredUsers = usuariosDB.searchUsers(searchTerm);
        if (filteredUsers.isEmpty()) {
            usersListPanel.add(new JLabel("No se encontraron usuarios"));
        } else {
            for (User user : filteredUsers) {
                usersListPanel.add(createUserRow(user));
            }
        }
        
        usersListPanel.revalidate();
        usersListPanel.repaint();
    }
    
    private void deactivateUser(User user){
        usuariosDB.deactivateUser(user.getId());
        loadUsers();
    }
    
    private void reactivateUser(User user){
        usuariosDB.reactiveUser(user.getId());
        loadUsers();
    }
    
    private void showUserDetails(User user) {
        switch(user.getType()){
            
            case "cliente" ->{
                JOptionPane.showMessageDialog(null, 
                "ID: " + user.getId() + "\n" +
                "Nombre(s): " + client.getClientName(user.getId())+ "\n"+
                "Apellidos: " + client.getClientLastname(user.getId())+ "\n"+
                "Correo: " + user.getEmail() + "\n" +
                "Contraseña: " + user.getPass()+ "\n" + 
                "Fecha de Nacimiento: " + client.getClientBirthdate(user.getId())+ "\n"+
                "Genero: " + client.getClientGender(user.getId()),
                "Detalles del Usuario",
                JOptionPane.INFORMATION_MESSAGE);
            }
            
            case "repartidor" ->{
                JOptionPane.showMessageDialog(null, 
                "ID: " + user.getId() + "\n" +
                "Nombre(s): " + deliver.getDeliverName(user.getId())+ "\n"+
                "Apellidos: " + deliver.getDeliverLastname(user.getId())+ "\n"+
                "Correo: " + user.getEmail() + "\n" +
                "Contraseña: " + user.getPass()+ "\n" +
                "Genero: " + deliver.getDeliverGender(user.getId())+ "\n" +
                "RFC: " + deliver.getDeliverRFC(user.getId()) + "\n" +
                "CURP: " + deliver.getDeliverCURP(user.getId()) + "\n" +
                "Placa: " + deliver.getDeliverPlate(user.getId()) + "\n" +
                "Estado: " + deliver.getDeliverState(user.getId()),        
                "Detalles del Usuario",
                JOptionPane.INFORMATION_MESSAGE);
            }
            
            case "administrador" ->{
                JOptionPane.showMessageDialog(null, 
                "ID: " + user.getId() + "\n" +
                "Nombre(s): " + admin.getAdminName(user.getId())+ "\n"+
                "Apellidos: " + admin.getAdminLastname(user.getId())+ "\n"+
                "Correo: " + user.getEmail() + "\n" +
                "Contraseña: " + user.getPass()+ "\n" +
                "Genero: " + admin.getAdminGender(user.getId())+ "\n" +
                "RFC: " + admin.getAdminRFC(user.getId()) + "\n" +
                "CURP: " + admin.getAdminCURP(user.getId()),        
                "Detalles del Usuario",
                JOptionPane.INFORMATION_MESSAGE);
            }
        }  
    }
    
    private void editUser(User user) {
        switch(user.getType()){
            
            case "cliente" -> {
                AbrirVentana.getInstance().vEditClient(user.getId());
            }
            
            case "repartidor" -> {
                AbrirVentana.getInstance().vEditDeliver(user.getId());
            }
            
            case "administrador" -> {
                AbrirVentana.getInstance().vEditAdmin(user.getId());
            }
        }
    }
    
    public JButton getBtnCrearUsuario() {
        return btnCrearUsuario;
    }
    
    public JButton getBtnAjustes() {
        return btnAjustes;
    }
    
    public JButton getBtnBuscar() {
        return btnBuscar;
    }
    
    public JTextField getTxtBuscar() {
        return txtBuscar;
    }
    
    public void cargarUsuarios(){
        this.loadUsers();
    }
}

class User {
    private final int id;
    private final String password;
    private final String email;
    private final String type;
    private final String active;

    public User(int id, String password, String email, String type, String active) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.type = type;
        this.active = active;
    }

    public int getId() {
        return id; 
    }
    public String getPass() {
        return password; 
    }
    public String getEmail() {
        return email; 
    }
    public String getType(){
        return type;
    }
    public String getActive(){
        return active;
    }
}
