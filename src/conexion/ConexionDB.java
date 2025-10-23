package conexion;

import java.sql.*;

public class ConexionDB {
    
    static String URL = "jdbc:mysql://localhost:3306/proyecto";
    
    public Connection clientConnection(){        
        Connection con = null;
        try{            
            con=DriverManager.getConnection(URL,"Cliente","CLIENT");          
        }catch(SQLException e){
            
            System.out.println("Error en la conexion: "+e);            
        }        
        return con;        
    }
    
    public Connection deliverConnection(){       
        Connection con = null;
        try{           
            con=DriverManager.getConnection(URL,"Repartidor","REP");        
        }catch(SQLException e){           
            System.out.println("Error en la conexion: "+e);        
        }     
        return con;    
    }
    
    public Connection adminConnection(){  
        Connection con = null;
        try{      
            con=DriverManager.getConnection(URL,"Administrador","ADMIN");    
        }catch(SQLException e){
            
            System.out.println("Error en la conexion: "+e);     
        } 
        return con;    
    } 
}
