package login;

import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Verificacion {
    ConexionDB db = new ConexionDB();
    Login login = new Login();

    public boolean confirmLogin(String email, String pass){
        Connection con = db.adminConnection();
        if(con != null){
            String sql = "SELECT contrasena, activo FROM usuarios WHERE correo = ?";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if(rs != null && rs.next()){
                    String status = rs.getString("activo");
                    if(status.equals("no")){
                        VReactivar reactivar = new VReactivar(login.getUserId(email));
                        reactivar.setVisible(true);
                        reactivar.setLocationRelativeTo(null);
                        return false;
                    }else{
                        String password = rs.getString("contrasena");
                        if(password.equals(pass)){
                            return true;
                        }else{
                            JOptionPane.showMessageDialog(null,"Inicio de sesión fallido");
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"No se encontro el usuario con correo: "+ email);
                }
                rs.close();
                ps.close();
                con.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Error al realizar la consulta");
            }
        }else{
            JOptionPane.showMessageDialog(null,"No se pudo establecer la conexion adecuadamente");
        }
        return false;
    }

    public boolean validData(String name, String lastname, String mail, String day, String month, String year, String pass, String confirmPass, String gender){
        return (validEmail(mail) && validDate(day,month,year) && validPass(pass,confirmPass) && validName(name) && validLastname(lastname) && validGender(gender));
    }

    public boolean validName(String name){
        if(name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
            return true;
        }else{
            JOptionPane.showMessageDialog(null,"Nombre(s) invalido");
            return false;
        }
    }

    public boolean validLastname(String lastname){
        if(lastname.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") ){
            return true;
        }else{
            JOptionPane.showMessageDialog(null,"Apellidos invalidos");
            return false;
        }
    }

    public boolean validEmail(String mail){
        if (!mail.contains("@") || !mail.contains(".")){
            JOptionPane.showMessageDialog(null,"Correo invalido");
            return false;
        }else{
            Connection con = db.adminConnection();
            boolean valido=true;
            if(con != null){
                String sql = "SELECT correo FROM usuarios";
                try{
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        if (mail.equals(rs.getString("correo"))) {
                            JOptionPane.showMessageDialog(null,"Correo invalido");
                            valido = false;
                            break;
                        }
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+ e);
                    valido = false;
                }
            }
            return valido;
        }
    }

    public boolean validDate(String d, String m, String y){
        int day = Integer.parseInt(d);
        int month = Integer.parseInt(m);
        int year = Integer.parseInt(y);
        boolean bisiesto = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if(month==2 && day>29 && !bisiesto){
            JOptionPane.showMessageDialog(null,"Fecha invalida");
            return false;
        }else if((month == 4 || month == 6 || month == 9 || month == 11) && day==31){
            JOptionPane.showMessageDialog(null,"Fecha invalida");
            return false;
        }else if(year > LocalDate.now().getYear()){
            JOptionPane.showMessageDialog(null,"Fecha invalida");
            return false;
        }else{
            int edad = LocalDate.now().getYear() - year;
            if(edad >= 18){
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Fecha invalida");
                return false;
            }
        }
    }

    public boolean validPass(String p, String p2){
        boolean largoValido = p.length() >= 8;
        boolean tieneLetra = p.matches(".*[a-zA-Z].*");
        boolean tieneNumero = p.matches(".*\\d.*");
        boolean tieneEspecial = p.matches(".*[^a-zA-Z0-9].*");

        if(largoValido && tieneNumero && tieneLetra && tieneEspecial){
            if(p.equals(p2)){
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Contraseña invalida");
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null,"Contraseña invalida");
            return false;
        }
    }

    public boolean validGender(String gender){
        if(gender != null && (gender.equals("H") || gender.equals("M"))){
            return true;
        }else{
            JOptionPane.showMessageDialog(null,"Genero invalido");
            return false;
        }
    }

    public boolean validRFC(String rfc){
        String regex = "^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{3}$";
        if (rfc.isEmpty() || !rfc.matches(regex)){
            JOptionPane.showMessageDialog(null,"RFC invalido");
            return false;
        }else{
            Connection con = db.adminConnection();
            boolean valido=true;
            if(con != null){
                String sql = "SELECT rfc FROM administrador UNION ALL SELECT rfc FROM repartidores";
                try{
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        if (rfc.equals(rs.getString("rfc"))) {
                            JOptionPane.showMessageDialog(null,"RFC invalido");
                            valido = false;
                            break;
                        }
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+ e);
                    valido = false;
                }
            }
            return valido;
        }
    }

    public boolean validCURP(String curp){
        String regex = "^[A-Z][AEIOU][A-Z]{2}\\d{2}(0[1-9]|1[0-2])"
                     + "(0[1-9]|[12]\\d|3[01])[HM]"
                     + "(AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS)"
                     + "[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d]\\d$";
        if (curp.isEmpty() || !curp.matches(regex)){
            JOptionPane.showMessageDialog(null,"CURP invalido");
            return false;
        }else{
            Connection con = db.adminConnection();
            boolean valido=true;
            if(con != null){
                String sql = "SELECT curp FROM administrador UNION ALL SELECT curp FROM repartidores";
                try{
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        if (curp.equals(rs.getString("curp"))) {
                            JOptionPane.showMessageDialog(null,"RFC invalido");
                            valido = false;
                            break;
                        }
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+ e);
                    valido = false;
                }
            }
            return valido;
        }
    }

    public boolean validPlate(String plate){
        String regex = "^[A-Z]{3}\\d{3}[A-Z]$";
        if (plate.isEmpty() || !plate.matches(regex)){
            JOptionPane.showMessageDialog(null,"Placa invalido");
            return false;
        }else{
            Connection con = db.deliverConnection();
            boolean valido=true;
            if(con != null){
                String sql = "SELECT placa FROM repartidores";
                try{
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        if (plate.equals(rs.getString("placa"))) {
                            JOptionPane.showMessageDialog(null,"Placa invalido");
                            valido = false;
                            break;
                        }
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+ e);
                    valido = false;
                }
            }
            return valido;
        }
    }
    
    public boolean existingEmail(String mail){
        Connection con = db.adminConnection();
        boolean existe=false;
        if(con != null){
            String sql = "SELECT correo FROM usuarios";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    if (mail.equals(rs.getString("correo"))) {
                        existe = true;
                        break;
                    }
                }                    
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Error al realizar la consulta: "+e);
            }
        }
        return existe;
    }
}
