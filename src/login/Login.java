package login;

import java.sql.CallableStatement;
import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import java.util.Random;

public class Login {
    
    ConexionDB db = new ConexionDB();
    
    public int sendCode(String correo){
        
        Random ran = new Random();
        
        int codigo = ran.nextInt(999-100+1)+100;
        String remitente = "alx275832@gmail.com";
        String contraseña = "yjcw qksw iikn bzxt";
        String destinatario = correo;
        String asunto = "Código para cambio de contraseña";
        String mensaje = "Hola, aqui esta tu codigo para reestablecer tu contraseña: " + codigo;
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session sesion = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, contraseña);
            }
        });
        try {
            Message mail = new MimeMessage(sesion);
            mail.setFrom(new InternetAddress(remitente));
            mail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            Transport.send(mail);
            JOptionPane.showMessageDialog(null,"Correo enviado exitosamente");
            return codigo;
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null,"Error al enviar el correo");
            return 0;
        }
    }
    
    public boolean changePass(String pass, String email){
        
        Connection con = db.clientConnection();
        boolean cambio = false;
        if(con != null){
            try{
                CallableStatement stmt = con.prepareCall("{CALL CHANGE_PASSWORD(?,?)}");
                stmt.setString(1, pass);
                stmt.setString(2, email);
                stmt.execute();
                JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente");
                cambio = true;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error al cambiar la contraseña");
        }
        return cambio;
    }
    
    public int getUserId(String email){
        
        Connection con = db.adminConnection();
        
        int id=0;
        
        if(con != null){
            try{
                String sql = "SELECT id_usuario FROM usuarios WHERE correo = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if(rs != null && rs.next()){
                    id = rs.getInt("id_usuario");
                }else{
                    JOptionPane.showMessageDialog(null,"No se logro obtener el id de usuario");
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);
            }
        }
        return id;
    }
    
    public String getUserType(int id){
        
        Connection con = db.adminConnection();
        
        String type = null;
        
        if(con != null){
            try{
                String sql = "SELECT tipo_cuenta FROM usuarios WHERE id_usuario = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs != null && rs.next()){
                   type = rs.getString("tipo_cuenta");
                }
                return type;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta: "+e);
            }
        }
        
        return type;
    }
}
