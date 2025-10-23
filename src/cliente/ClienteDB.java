package cliente;

import conexion.ConexionDB;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Types;
import javax.swing.JOptionPane;

public class ClienteDB {
    ConexionDB db = new ConexionDB();
    
    public void registerClient(String email, String pass, String name, String lastname, String birthdate, String gender){       
        Connection con = db.clientConnection();        
        if(con != null){        
            try{                
                CallableStatement stmt = con.prepareCall("{CALL ADD_USER(?, ?, ?)}");
                stmt.setString(1, email);
                stmt.setString(2, pass);
                stmt.setString(3, "cliente");
                stmt.execute();
                CallableStatement stmt2 = con.prepareCall("{CALL ADD_CLIENT(?, ?, ?, ?, ?)}");
                stmt2.setString(1, name);
                stmt2.setString(2, lastname);
                stmt2.setString(4, birthdate);
                stmt2.setString(3, gender);
                String sql = "SELECT id_usuario FROM usuarios WHERE correo = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,email);
                ResultSet rs = ps.executeQuery();
                int id;
                if (rs.next()) {
                    id = rs.getInt("id_usuario");
                    stmt2.setInt(5, id);
                    stmt2.execute();
                    JOptionPane.showMessageDialog(null,"Usuario registrado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el ID del usuario.");
                }                
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+e);                
            }
        }
    }
    
    public int getClientId(int idU){        
        Connection con = db.clientConnection();
        int id = 0;        
        if(con != null){            
            try{                
                String sql = "SELECT id_cliente FROM clientes WHERE id_usuario = ?";                
                PreparedStatement ps = con.prepareStatement(sql);                
                ps.setInt(1, idU);                
                ResultSet rs = ps.executeQuery();                
                if(rs != null && rs.next()){
                    
                   id = rs.getInt("id_cliente");                   
                }               
                return id;            
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);                
            }            
        }        
        return id;    
    }
    
    public String getClientName(int id){        
        Connection con = db.clientConnection();
        String name = null;        
        if(con != null){            
            try{                
                String sql = "SELECT nombre FROM clientes WHERE id_usuario = ?";                
                PreparedStatement ps = con.prepareStatement(sql);                
                ps.setInt(1, id);                
                ResultSet rs = ps.executeQuery();                
                if(rs != null && rs.next()){
                    
                   name = rs.getString("nombre");                   
                }               
                return name;            
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);                
            }            
        }        
        return name;    
    }
    
    public String getClientLastname(int id){        
        Connection con = db.clientConnection();
        String lastname = null;        
        if(con != null){            
            try{                
                String sql = "SELECT apellidos FROM clientes WHERE id_usuario = ?";                
                PreparedStatement ps = con.prepareStatement(sql);                
                ps.setInt(1, id);                
                ResultSet rs = ps.executeQuery();                
                if(rs != null && rs.next()){
                    
                   lastname = rs.getString("apellidos");                   
                }               
                return lastname;            
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);                
            }            
        }        
        return lastname;    
    }
        
    public String getClientPass(int id){  
        Connection con = db.clientConnection();
        String pass = null;        
        if(con != null){            
            try{                
                String sql = "SELECT contrasena FROM usuarios WHERE id_usuario = ?";                
                PreparedStatement ps = con.prepareStatement(sql);                
                ps.setInt(1, id);                
                ResultSet rs = ps.executeQuery();                
                if(rs != null && rs.next()){
                    
                   pass = rs.getString("contrasena");                   
                }               
                return pass;            
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);                
            }            
        }        
        return pass;   
    }
    
    public String getClientBirthdate(int id){   
        Connection con = db.clientConnection();
        String birthdate = null;        
        if(con != null){            
            try{                
                String sql = "SELECT fecha_nacimiento FROM clientes WHERE id_usuario = ?";                
                PreparedStatement ps = con.prepareStatement(sql);                
                ps.setInt(1, id);                
                ResultSet rs = ps.executeQuery();                
                if(rs != null && rs.next()){
                    
                   birthdate = rs.getString("fecha_nacimiento");                   
                }               
                return birthdate;            
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);                
            }            
        }        
        return birthdate;   
    }
    
    public String getClientGender(int id){   
        Connection con = db.clientConnection();
        String gender = null;        
        if(con != null){            
            try{                
                String sql = "SELECT genero FROM clientes WHERE id_usuario = ?";                
                PreparedStatement ps = con.prepareStatement(sql);                
                ps.setInt(1, id);                
                ResultSet rs = ps.executeQuery();                
                if(rs != null && rs.next()){
                    
                   gender = rs.getString("genero");                   
                }               
                return gender;            
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);                
            }            
        }        
        return gender;   
    }
    
    public ArrayList<cliente.Dish> getAllDishes() {
        Connection con = db.clientConnection();
        ArrayList<cliente.Dish> dishes = new ArrayList<>();
        String query = "SELECT id_platillo, nombre, descripcion, costo FROM platillos";
        try{    
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                cliente.Dish dish = new cliente.Dish(rs.getInt("id_platillo"), rs.getString("nombre"),rs.getString("descripcion"), rs.getBigDecimal("costo"));
                dishes.add(dish);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+e);
        }
        return dishes;
    }
    
    public ArrayList<cliente.Cart> getCarrito(int idC) {
        Connection con = db.clientConnection();
        ArrayList<cliente.Cart> carts = new ArrayList<>();
        String query = "SELECT c.id_carrito, c.id_cliente, c.id_platillo, c.cantidad, p.nombre,p.costo FROM carrito c JOIN platillos p ON c.id_platillo = p.id_platillo WHERE c.id_cliente = ?";
        try{    
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,idC);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente.Cart cart = new cliente.Cart(rs.getInt("id_carrito"), rs.getInt("id_cliente"), rs.getInt("id_platillo"), rs.getInt("cantidad"), rs.getString("nombre"), rs.getBigDecimal("costo"));
                carts.add(cart);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+e);
        }
        return carts;
    }
    
    public ArrayList<Dish> searchDishes(String searchTerm) {
        Connection con = db.clientConnection();
        ArrayList<Dish> dishes = new ArrayList<>();
        
        String sql = "SELECT id_platillo, nombre, descripcion, costo FROM platillos WHERE nombre LIKE ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, "%" + searchTerm + "%");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dish dish = new Dish(rs.getInt("id_platillo"), rs.getString("nombre"),rs.getString("descripcion"), rs.getBigDecimal("costo"));
                dishes.add(dish);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuarios: " + e);
        }
        return dishes;
    }
    
    public void addDish(int idC, int idP, int amount){
        Connection con = db.clientConnection();        
        if(con != null){        
            try{                
                CallableStatement stmt = con.prepareCall("{CALL ADD_CART(?, ?, ?)}");
                stmt.setInt(1, idC);
                stmt.setInt(2, idP);
                stmt.setInt(3, amount);
                stmt.execute();
                JOptionPane.showMessageDialog(null,"Platillo añadido al carrito");
            }catch(SQLException e){     
                JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+e);                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error al realizar la conexion");
        }
    }
    
    public void deleteDish(int id){
        Connection con = db.clientConnection();
        if(con != null){
            try{
                String sql = "DELETE FROM carrito WHERE id_carrito = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                int filasEliminadas = ps.executeUpdate();
                if(filasEliminadas > 0){
                    JOptionPane.showMessageDialog(null, "Se elimino el platillo del carrito");
                }else{
                    JOptionPane.showMessageDialog(null, "Error a eliminar el platillo");
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);
            }
        }
    }
    
    public void createOrder(String adress, String pay, int idC, BigDecimal total, String comment) {
        Connection con = db.clientConnection();
        if (con != null) {
            try {
                CallableStatement stmt = con.prepareCall("{CALL CREATE_ORDER(?, ?, ?, ?, ?, ?, ?, ?)}");
                stmt.setInt(1, idC);
                stmt.setString(2, adress);
                stmt.setString(3, LocalDate.now().toString());
                stmt.setString(4, LocalTime.now().toString());
                stmt.setBigDecimal(5, total);
                stmt.setString(6, pay);
                stmt.setString(7, comment);
                stmt.registerOutParameter(8, Types.INTEGER);
                stmt.executeUpdate();

                int idPedido = stmt.getInt(8);
                stmt.close();

                ArrayList<Cart> carrito = getCarrito(idC);

                String insertRegistro = "INSERT INTO platillos_pedidos (id_pedido, id_platillo, cantidad) VALUES (?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(insertRegistro);

                for (Cart cart : carrito) {
                    ps.setInt(1, idPedido);
                    ps.setInt(2, cart.getIdP());
                    ps.setInt(3, cart.getAmount());
                    ps.addBatch();
                }

                ps.executeBatch();
                ps.close();

                String deleteCarrito = "DELETE FROM carrito WHERE id_cliente = ?";
                PreparedStatement psDelete = con.prepareStatement(deleteCarrito);
                psDelete.setInt(1, idC);
                psDelete.executeUpdate();
                psDelete.close();

                con.close();
                JOptionPane.showMessageDialog(null, "Orden realizada correctamente.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: " + e);
            }
        }
    }   
    
    public boolean EmptyCart(int idC){
        ArrayList<cliente.Cart> carts = getCarrito(idC);
        return carts.isEmpty();
    }
    
    public ArrayList<PedidoR> getClientOrders(int idC) {
        Connection con = db.deliverConnection();
        ArrayList<PedidoR> orders = new ArrayList<>();

        String query = """
            SELECT p.id_pedido, p.direccion, p.fecha, p.hora_realizacion, p.hora_entrega, p.total, p.metodo_pago, p.comentario,
                   r.nombre, r.apellidos
            FROM pedidos p
            JOIN repartidores r ON p.id_repartidor = r.id_repartidor
            WHERE p.id_cliente = ?
        """;

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idC);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellidos");
                PedidoR order = new PedidoR(
                    rs.getInt("id_pedido"),
                    nombreCompleto,
                    rs.getString("direccion"),
                    rs.getString("fecha"),
                    rs.getString("hora_realizacion"),
                    rs.getString("hora_entrega"),
                    rs.getBigDecimal("total"),
                    rs.getString("metodo_pago"),
                    rs.getString("comentario")
                );
                orders.add(order);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar la consulta: " + e);
        }

        return orders;
    }
    
    public ArrayList<PedidoR> searchClientOrders(String searchTerm, int idC) {
        Connection con = db.adminConnection();
        ArrayList<PedidoR> orders = new ArrayList<>();
        String query = """
            SELECT p.id_pedido, p.direccion, p.fecha, p.hora_realizacion, p.hora_entrega, p.total, p.metodo_pago, p.comentario,
                   r.nombre, r.apellidos
            FROM pedidos p
            JOIN repartidores r ON p.id_repartidor = r.id_repartidor
            WHERE id_cliente = ? AND direccion LIKE ?
        """;
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idC);
            ps.setString(2, "%" + searchTerm + "%");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellidos");
                PedidoR order = new PedidoR(
                    rs.getInt("id_pedido"),
                    nombreCompleto,
                    rs.getString("direccion"),
                    rs.getString("fecha"),
                    rs.getString("hora_realizacion"),
                    rs.getString("hora_entrega"),
                    rs.getBigDecimal("total"),
                    rs.getString("metodo_pago"),
                    rs.getString("comentario")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar la consulta: " + e);
        }
        return orders;
    }
    
    public ArrayList<PlatilloC> loadOrderDishes(int idP) {
        ArrayList<PlatilloC> platillos = new ArrayList<>();

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
                platillos.add(new PlatilloC(nombre, cantidad));
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los platillos del pedido.");
        }
        return platillos;
    }
}
