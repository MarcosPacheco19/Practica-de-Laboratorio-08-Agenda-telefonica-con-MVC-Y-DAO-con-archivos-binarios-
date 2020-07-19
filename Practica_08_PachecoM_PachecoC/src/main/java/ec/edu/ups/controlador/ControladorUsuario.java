/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
 *
 * @author xpacheco
 */
public class ControladorUsuario {
    
    private int contadorTelefono;
    
    private Usuario usuario;
    private Telefono telefono;
    
    private IUsuarioDAO usuarioDAO;
    private ITelefonoDAO telefonoDAO;

    
     public ControladorUsuario(UsuarioDAO clienteDAO, TelefonoDAO direccionDAO) {
        //   this.vista = vistaCliente;
        this.usuarioDAO = clienteDAO;

        // this.vistaT = vistaDireccion;
        this.telefonoDAO = direccionDAO;

        contadorTelefono = 0;

    }
     
     
     public void crearUsuario(String nombre, String apellido, String cedula, String correo,
            String password) {

        usuario = new Usuario();

        usuario.setCedula(cedula);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCorreo(correo);
        usuario.setContraseña(password);
        System.out.println(usuario.toString());
        usuarioDAO.create(usuario);
    }
     
    public Usuario iniciarSesion(String correo, String password) {

        //se obtienen los datos de contraseÃ±a y correo
        //se envian los datos y se recibe una persona
        usuario = usuarioDAO.iniciarSesion(correo, password);
        return usuario;
    }
    
    public void actualizarUsuario(String nombre, String apellido, String cedula, String correo,
            String password) {
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCorreo(correo);
        usuario.setContraseña(password);
        usuario.setCedula(cedula);

        usuarioDAO.update(usuario);

    }

    public void imprimirTelefonos() {
        List<Telefono> telefonos;
        telefonos = telefonoDAO.findAll();

        for (Telefono tele : telefonos) {
            System.out.println(tele.toString());
        }
    }

}
