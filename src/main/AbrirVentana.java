package main;

import admin.VCrearUsuario;
import admin.VEditarAdmin;
import admin.VEditarCliente;
import admin.VEditarRepartidor;
import javax.swing.JFrame;
import login.VLogin;
import cliente.VInicioCliente;
import repartidor.VInicioRepartidor;
import admin.VInicioAdmin;
import cliente.VCarrito;
import cliente.VHistorialCliente;
import cliente.VUsuarioCliente;
import login.VCambioContra;
import login.VRegistro;
import repartidor.VHistorialRep;
import repartidor.VPerfilRepartidor;

public class AbrirVentana {

    private static AbrirVentana instancia;

    private AbrirVentana() {}

    public static AbrirVentana getInstance() {
        if (instancia == null) {
            instancia = new AbrirVentana();
        }
        return instancia;
    }

    VInicioCliente cliente = new VInicioCliente();
    VLogin sesion = new VLogin();
    VCambioContra changePass = new VCambioContra();
    VCrearUsuario createUser = new VCrearUsuario();

    public void vLogin() {
        sesion.setExtendedState(JFrame.MAXIMIZED_BOTH);
        sesion.setVisible(true);
    }

    public void vRegister() {
        VRegistro register = new VRegistro();
        register.setExtendedState(JFrame.MAXIMIZED_BOTH);
        register.setVisible(true);
    }

    public void vChangePass() {
        changePass.setExtendedState(JFrame.MAXIMIZED_BOTH);
        changePass.setVisible(true);
    }

    public void vClientMain(String name) {
        cliente.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cliente.lblBienvenido.setText("Bienvenido " + name);
        cliente.setVisible(true);
    }

    public void vDeliverMain(int id) {
        VInicioRepartidor rep = new VInicioRepartidor(id);
        rep.setExtendedState(JFrame.MAXIMIZED_BOTH);
        rep.setVisible(true);
    }

    public void vAdminMain() {
        VInicioAdmin.getInstance().setExtendedState(JFrame.MAXIMIZED_BOTH);
        VInicioAdmin.getInstance().setVisible(true);
    }

    public void vCreateUser() {
        createUser.setExtendedState(JFrame.MAXIMIZED_BOTH);
        createUser.setVisible(true);
    }

    public void vEditClient(int id) {
        VEditarCliente.getInstance(id).setVisible(true);
        VEditarCliente.getInstance(id).setLocationRelativeTo(null);
    }

    public void vEditDeliver(int id) {
        VEditarRepartidor editD = new VEditarRepartidor(id);
        editD.setVisible(true);
        editD.setLocationRelativeTo(null);
    }

    public void vEditAdmin(int id) {
        VEditarAdmin.getInstance(id).setVisible(true);
        VEditarAdmin.getInstance(id).setLocationRelativeTo(null);
    }

    public void vClientUser(int id) {
        VUsuarioCliente.getInstance(id).setLocationRelativeTo(null);
        VUsuarioCliente.getInstance(id).setVisible(true);
    }

    public void vCart() {
        VCarrito.getInstance().setLocationRelativeTo(null);
        VCarrito.getInstance().setVisible(true);
    }

    public void vHistorialRep() {
        VHistorialRep.getInstance().setLocationRelativeTo(null);
        VHistorialRep.getInstance().setVisible(true);
    }

    public void vHistorialCliente() {
        VHistorialCliente.getInstance().setLocationRelativeTo(null);
        VHistorialCliente.getInstance().setVisible(true);
    }

    public void DeliverProfile(int id) {
        VPerfilRepartidor.getInstance(id).setVisible(true);
        VPerfilRepartidor.getInstance(id).setLocationRelativeTo(null);
    }
}
