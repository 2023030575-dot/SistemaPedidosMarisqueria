package admin;

import java.sql.Statement;
import conexion.ConexionDB;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;


public class UsuarioDB {
    ConexionDB db = new ConexionDB();
    
    public ArrayList<User> getAllUsers() {
        Connection con = db.adminConnection();
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT id_usuario, contrasena, correo, tipo_cuenta, activo FROM usuarios";
        try{    
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User(rs.getInt("id_usuario"), rs.getString("contrasena"),rs.getString("correo"), rs.getString("tipo_cuenta"), rs.getString("activo"));
                users.add(user);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+e);
        }
        return users;
    }
    
    public ArrayList<User> searchUsers(String searchTerm) {
        Connection con = db.adminConnection();
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT id_usuario, contrasena, correo, tipo_cuenta, activo FROM usuarios WHERE correo LIKE ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, "%" + searchTerm + "%");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id_usuario"),rs.getString("contrasena"),rs.getString("correo"),rs.getString("tipo_cuenta"),rs.getString("activo"));
                users.add(user);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuarios: " + e);
        }
        return users;
    }
    
    public boolean deactivateUser(int id) {
    Connection con = null;
    PreparedStatement ps;
    boolean success = false;
    try {
        con = db.adminConnection();
        con.setAutoCommit(false);
        String sql = "UPDATE usuarios SET activo = 'no' WHERE id_usuario = ?";

        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        int filasActualizadas = ps.executeUpdate();
        if (filasActualizadas > 0) {
            con.commit();
            success = true;
            ps.close();
            JOptionPane.showMessageDialog(null,"Desactivacion realizada correctamente");
        }
    } catch (SQLException e) {
        try {
            if (con != null) con.rollback();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al realizar la consulta: " + ex);
        }
        String errorMsg = e.getMessage();
        if (errorMsg != null && errorMsg.contains("no ha estado inactivo por 3 meses o más")) {
            JOptionPane.showMessageDialog(null, "No se puede desactivar: el usuario ha estado activo recientemente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
        }
    }   
        return success;
    }
    
    public boolean reactiveUser(int id){
        Connection con = db.adminConnection();
        boolean success = false;
        if(con != null){
            String sql = "UPDATE usuarios SET activo = 'si' WHERE id_usuario = ?";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1,id);
                int filasActualizadas = ps.executeUpdate();
                if(filasActualizadas > 0){
                    success = true;
                    JOptionPane.showMessageDialog(null,"Usuario activado correctamente");
                }else{
                    success = false;
                    JOptionPane.showMessageDialog(null,"Error al activar al usuario");
                }
                ps.close();
                con.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+e);
            }
        }
        return success;
    }
    
    public void createUser(String email, String pass, String name, String lastname, String gender, String rfc, String curp, String plate, String type){
        Connection con = db.adminConnection();        
        if(con != null){        
            try{                
                CallableStatement stmt = con.prepareCall("{CALL ADD_USER(?, ?, ?)}");
                stmt.setString(1, email);
                stmt.setString(2, pass);
                stmt.setString(3, type);
                stmt.execute();
                switch(type){  
                    case "repartidor" -> {
                        CallableStatement stmt2 = con.prepareCall("{CALL ADD_DELIVER(?, ?, ?, ?, ?, ?, ?)}");
                        stmt2.setString(1, name);
                        stmt2.setString(2, lastname);
                        stmt2.setString(3, gender);
                        stmt2.setString(4, rfc);
                        stmt2.setString(5, curp);
                        stmt2.setString(6, plate);
                        String sql = "SELECT id_usuario FROM usuarios WHERE correo = ?";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1,email);
                        ResultSet rs = ps.executeQuery();
                        int id;
                        if (rs.next()) {
                            id = rs.getInt("id_usuario");
                            stmt2.setInt(7, id);
                            stmt2.execute();
                            JOptionPane.showMessageDialog(null,"Usuario registrado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró el ID del usuario.");
                        }
                    }
                    case "administrador" ->{
                        CallableStatement stmt2 = con.prepareCall("{CALL ADD_ADMIN(?, ?, ?, ?, ?, ?)}");
                        stmt2.setString(1, name);
                        stmt2.setString(2, lastname);
                        stmt2.setString(3, gender);
                        stmt2.setString(4, rfc);
                        stmt2.setString(5, curp);
                        String sql = "SELECT id_usuario FROM usuarios WHERE correo = ?";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1,email);
                        ResultSet rs = ps.executeQuery();
                        int id;
                        if (rs.next()) {
                            id = rs.getInt("id_usuario");
                            stmt2.setInt(6, id);
                            stmt2.execute();
                            JOptionPane.showMessageDialog(null,"Usuario registrado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró el ID del usuario.");
                        }
                    }
                }
                                
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+e);                
            }
        }
    }
    
    public ArrayList<Order> getPendingOrders() {
        Connection con = db.adminConnection();
        ArrayList<Order> orders = new ArrayList<>();
        String query = "SELECT id_pedido, id_cliente, direccion, fecha, hora_realizacion, total, metodo_pago, comentario FROM pedidos WHERE id_repartidor IS NULL";
        try{    
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Order order = new Order(rs.getInt("id_pedido"), rs.getInt("id_cliente"),rs.getString("direccion"), rs.getString("fecha"), rs.getString("hora_realizacion"), rs.getBigDecimal("total"),rs.getString("metodo_pago"), rs.getString("comentario"));
                orders.add(order);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+e);
        }
        return orders;
    }
    
    public ArrayList<Order> searchOrders(String searchTerm) {
        Connection con = db.adminConnection();
        ArrayList<Order> orders = new ArrayList<>();
        String sql = "SELECT id_pedido, id_cliente, direccion, fecha, hora_realizacion, total, metodo_pago, comentario FROM pedidos WHERE direccion LIKE ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, "%" + searchTerm + "%");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt("id_pedido"), rs.getInt("id_cliente"),rs.getString("direccion"), rs.getString("fecha"), rs.getString("hora_realizacion"), rs.getBigDecimal("total"),rs.getString("metodo_pago"), rs.getString("comentario"));
                orders.add(order);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuarios: " + e);
        }
        return orders;
    }
    
    public ArrayList<Platillo> loadOrderDishes(int idP) {
        ArrayList<Platillo> platillos = new ArrayList<>();

        try {
            Connection con = db.adminConnection();
            String query = """
                SELECT p.nombre, pp.cantidad
                FROM platillos_pedidos pp
                JOIN platillos p ON pp.id_platillo = p.id_platillo
                WHERE pp.id_pedido = ?
            """;

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, idP);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");
                platillos.add(new Platillo(nombre, cantidad));
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los platillos del pedido.");
        }
        return platillos;
    }
    
    public ArrayList<Deliver> getActiveDelivers() {
        Connection con = db.adminConnection();
        ArrayList<Deliver> delivers = new ArrayList<>();
        String query = "SELECT r.id_repartidor, r.nombre, r.apellidos, r.genero, r.rfc, r.curp, r.placa FROM repartidores r JOIN usuarios u USING (id_usuario) WHERE u.activo = 'si' ";
        try{    
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Deliver deliver = new Deliver(rs.getInt("id_repartidor"), rs.getString("nombre"),rs.getString("apellidos"), rs.getString("genero"), rs.getString("rfc"), rs.getString("curp"), rs.getString("placa"));
                delivers.add(deliver);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+e);
        }
        return delivers;
    }
    
    public ArrayList<Deliver> searchDelivers(String searchTerm) {
        Connection con = db.adminConnection();
        ArrayList<Deliver> delivers = new ArrayList<>();
        String sql = "SELECT r.id_repartidor, r.nombre, r.apellidos, r.genero, r.rfc, r.curp, r.placa FROM repartidores r JOIN usuarios u USING (id_usuario) WHERE r.nombre LIKE ? OR r.apellidos LIKE ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, "%" + searchTerm + "%");
            ps.setString(2, "%" + searchTerm + "%");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Deliver deliver = new Deliver(rs.getInt("id_repartidor"), rs.getString("nombre"),rs.getString("apellidos"), rs.getString("genero"), rs.getString("rfc"), rs.getString("curp"), rs.getString("placa"));
                delivers.add(deliver);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuarios: " + e);
        }
        return delivers;
    }
    
    public boolean assignOrder(int idP, int idR) {
        boolean asignado = false;
        try {
            Connection con = db.adminConnection();
            String query = "UPDATE pedidos SET id_repartidor = ? WHERE id_pedido = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, idR);
            stmt.setInt(2, idP);

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Repartidor asignado correctamente");
                asignado = true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el pedido con ID: " + idP);
            }
            stmt.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);
        }
        return asignado;
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

class Order {
    private final int id;
    private final int idC;
    private final String adress;
    private final String date;
    private final String timeR;
    private final BigDecimal total;
    private final String pay;
    private final String comment;

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
