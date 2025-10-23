package repartidor;

import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class repartidorDB {
    ConexionDB db = new ConexionDB();
    
    public int getDeliverId(int idU){        
        Connection con = db.clientConnection();
        int id = 0;        
        if(con != null){            
            try{                
                String sql = "SELECT id_repartidor FROM repartidores WHERE id_usuario = ?";                
                PreparedStatement ps = con.prepareStatement(sql);                
                ps.setInt(1, idU);                
                ResultSet rs = ps.executeQuery();                
                if(rs != null && rs.next()){
                    
                   id = rs.getInt("id_repartidor");                   
                }               
                return id;            
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);                
            }            
        }        
        return id;    
    }
    
    public String getDeliverName(int id){        
        Connection con = db.deliverConnection();
        String name = null;        
        if(con != null){            
            try{                
                String sql = "SELECT nombre FROM repartidores WHERE id_usuario = ?";                
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
    
    public String getDeliverLastname(int id){        
        Connection con = db.deliverConnection();
        String lastname = null;        
        if(con != null){            
            try{                
                String sql = "SELECT apellidos FROM repartidores WHERE id_usuario = ?";                
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
    
    public String getDeliverGender(int id){   
        Connection con = db.deliverConnection();
        String gender = null;        
        if(con != null){            
            try{                
                String sql = "SELECT genero FROM repartidores WHERE id_usuario = ?";                
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
    
    public String getDeliverRFC(int id){   
        Connection con = db.deliverConnection();
        String rfc = null;        
        if(con != null){            
            try{                
                String sql = "SELECT rfc FROM repartidores WHERE id_usuario = ?";                
                PreparedStatement ps = con.prepareStatement(sql);                
                ps.setInt(1, id);                
                ResultSet rs = ps.executeQuery();                
                if(rs != null && rs.next()){
                    
                   rfc = rs.getString("rfc");                   
                }               
                return rfc;            
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);                
            }            
        }        
        return rfc;   
    }
    
    public String getDeliverCURP(int id){   
        Connection con = db.deliverConnection();
        String curp = null;        
        if(con != null){            
            try{                
                String sql = "SELECT curp FROM repartidores WHERE id_usuario = ?";                
                PreparedStatement ps = con.prepareStatement(sql);                
                ps.setInt(1, id);                
                ResultSet rs = ps.executeQuery();                
                if(rs != null && rs.next()){
                    
                   curp = rs.getString("curp");                   
                }               
                return curp;            
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);                
            }            
        }        
        return curp;   
    }
    
    public String getDeliverPlate(int id){   
        Connection con = db.deliverConnection();
        String plate = null;        
        if(con != null){            
            try{                
                String sql = "SELECT placa FROM repartidores WHERE id_usuario = ?";                
                PreparedStatement ps = con.prepareStatement(sql);                
                ps.setInt(1, id);                
                ResultSet rs = ps.executeQuery();                
                if(rs != null && rs.next()){
                    
                   plate = rs.getString("placa");                   
                }               
                return plate;            
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);                
            }            
        }        
        return plate;   
    }
    
    public String getDeliverState(int id){   
        Connection con = db.deliverConnection();
        String state = null;        
        if(con != null){            
            try{                
                String sql = "SELECT estado FROM repartidores WHERE id_usuario = ?";                
                PreparedStatement ps = con.prepareStatement(sql);                
                ps.setInt(1, id);                
                ResultSet rs = ps.executeQuery();                
                if(rs != null && rs.next()){
                    
                   state = rs.getString("estado");                   
                }               
                return state;            
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);                
            }            
        }        
        return state;   
    }
    
    public ArrayList<Pedido> getActiveOrders(int idR) {
        Connection con = db.deliverConnection();
        ArrayList<Pedido> orders = new ArrayList<>();

        String query = """
            SELECT p.id_pedido, p.direccion, p.fecha, p.hora_realizacion, p.total, p.metodo_pago, p.comentario,
                   c.nombre, c.apellidos
            FROM pedidos p
            JOIN clientes c ON p.id_cliente = c.id_cliente
            WHERE p.hora_entrega IS NULL AND p.id_repartidor = ?
        """;

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idR);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellidos");
                Pedido order = new Pedido(
                    rs.getInt("id_pedido"),
                    nombreCompleto,
                    rs.getString("direccion"),
                    rs.getString("fecha"),
                    rs.getString("hora_realizacion"),
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
    
    public ArrayList<Pedido> searchOrders(String searchTerm) {
        Connection con = db.adminConnection();
        ArrayList<Pedido> orders = new ArrayList<>();
        String query = """
            SELECT p.id_pedido, p.direccion, p.fecha, p.hora_realizacion, p.total, p.metodo_pago, p.comentario,
                   c.nombre, c.apellidos
            FROM pedidos p
            JOIN clientes c ON p.id_cliente = c.id_cliente
            WHERE hora_entrega IS NULL AND direccion LIKE ?
        """;
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, "%" + searchTerm + "%");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellidos");
                Pedido order = new Pedido(
                    rs.getInt("id_pedido"),
                    nombreCompleto,
                    rs.getString("direccion"),
                    rs.getString("fecha"),
                    rs.getString("hora_realizacion"),
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
    
    public void completeOrder(int idP) {
        Connection con = db.deliverConnection();

        String query = "UPDATE pedidos SET hora_entrega = ? WHERE id_pedido = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            String horaEntrega = LocalTime.now().toString();

            ps.setString(1, horaEntrega);
            ps.setInt(2, idP);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Pedido marcado como entregado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el pedido con ID " + idP);
            }

            ps.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar la consulta: " + e.getMessage());
        }
    }
    
    public ArrayList<PedidoH> getDoneOrders(int idR) {
        Connection con = db.deliverConnection();
        ArrayList<PedidoH> orders = new ArrayList<>();

        String query = """
            SELECT p.id_pedido, p.direccion, p.fecha, p.hora_realizacion, p.hora_entrega, p.total, p.metodo_pago, p.comentario,
                   c.nombre, c.apellidos
            FROM pedidos p
            JOIN clientes c ON p.id_cliente = c.id_cliente
            WHERE p.hora_entrega IS NOT NULL AND p.id_repartidor = ?
        """;

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idR);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellidos");
                PedidoH order = new PedidoH(
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
    
    public ArrayList<PedidoH> searchDoneOrders(String searchTerm, int idR) {
        Connection con = db.adminConnection();
        ArrayList<PedidoH> orders = new ArrayList<>();
        String query = """
            SELECT p.id_pedido, p.direccion, p.fecha, p.hora_realizacion, p.hora_entrega, p.total, p.metodo_pago, p.comentario,
                   c.nombre, c.apellidos
            FROM pedidos p
            JOIN clientes c ON p.id_cliente = c.id_cliente
            WHERE hora_entrega IS NOT NULL AND direccion LIKE ? AND id_repartidor = ?
        """;
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, "%" + searchTerm + "%");
            ps.setInt(2, idR);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellidos");
                PedidoH order = new PedidoH(
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
}
