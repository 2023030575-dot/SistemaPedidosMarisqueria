package admin;

import conexion.ConexionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AdminDB {
    ConexionDB db = new ConexionDB();
    
    public String getAdminName(int id){        
        Connection con = db.adminConnection();
        String name = null;        
        if(con != null){            
            try{                
                String sql = "SELECT nombre FROM administrador WHERE id_usuario = ?";                
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
    
    public String getAdminLastname(int id){        
        Connection con = db.adminConnection();
        String lastname = null;        
        if(con != null){            
            try{                
                String sql = "SELECT apellidos FROM administrador WHERE id_usuario = ?";                
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
    
    public String getAdminGender(int id){   
        Connection con = db.adminConnection();
        String gender = null;        
        if(con != null){            
            try{                
                String sql = "SELECT genero FROM administrador WHERE id_usuario = ?";                
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
    
    public String getAdminRFC(int id){   
        Connection con = db.adminConnection();
        String rfc = null;        
        if(con != null){            
            try{                
                String sql = "SELECT rfc FROM administrador WHERE id_usuario = ?";                
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
    
    public String getAdminCURP(int id){   
        Connection con = db.adminConnection();
        String curp = null;        
        if(con != null){            
            try{                
                String sql = "SELECT curp FROM administrador WHERE id_usuario = ?";                
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
    
    public void deactivateUsers(){
        Connection con = db.adminConnection();
        if(con != null){
            try{
                CallableStatement stmt = con.prepareCall("{CALL DEACTIVATE_INACTIVE_USERS}");
                stmt.execute();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al llamar al procedimiento: "+e);
            }
            
        }
    }
}
