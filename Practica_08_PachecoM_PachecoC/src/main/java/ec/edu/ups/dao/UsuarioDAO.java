/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

/**
 *
 * @author xpacheco
 */
public class UsuarioDAO implements IUsuarioDAO{
    
    /**
    *   Estructura del archivo
    * 
    *    private String cedula | 1O caracteres (Validar Cedula)
    *    private String nombre | 25 caracteres(llenar con espacios, cortar si sobrepasa los caracteres)
    *    private String apellido | 25 caracteres(llenar con espacios, cortar si sobrepasa los caracteres)
    *    private String correo | 5O caracteres(llenar con espacios, cortar si sobrepasa los caracteres)
    *    private String contraseña | 8 caracteres(Validar contraseña)
    *   
    *   118 bytes por usuario mas 20 bytes extras (String)= 128 bytes
    */
    private RandomAccessFile archivo;
    private Usuario usuario;
    private int registro;

    public UsuarioDAO() {
        registro = 128;
        try{  
        archivo = new RandomAccessFile("datos/usuario.dat", "rw");
        
        }catch(IOException ex){ 
            System.out.println("Error de Lectura y Escritura");
            ex.printStackTrace();
            
        }     
    }
    
    
    @Override
    public void create(Usuario usuario) {
       try{
       archivo.seek(archivo.length());
       archivo.writeUTF(usuario.getCedula());
       archivo.writeUTF(usuario.getNombre());
       archivo.writeUTF(usuario.getApellido());
       archivo.writeUTF(usuario.getCorreo());
       archivo.writeUTF(usuario.getContraseña());
       }catch(IOException ex){
           System.out.println("Error de Lectura y Escritura(create:UsuarioDAO):");
           ex.printStackTrace();
       }
    }

    @Override
    public Usuario read(String cedula) {
       int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF().trim();
                if (cedula.trim().equals(cedulaArchivo)) {
                    Usuario usuario1 = new Usuario(cedula, archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim());
                    return usuario1;
                }
                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(readUsuario)");
        }
        return null;
    }

    @Override
    public void update(Usuario usuario) {
        int salto = 0;
        String cedula = usuario.getCedula();
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF().trim();
                if (cedula.trim().equals(cedulaArchivo)) {
                    //archivo.writeUTF(cliente.getCedula());
                    archivo.writeUTF(usuario.getNombre());
                    archivo.writeUTF(usuario.getApellido());
                    archivo.writeUTF(usuario.getCorreo());
                    archivo.writeUTF(usuario.getContraseña());
                    break;
                }
                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(upDateUsuario)");
        }
    }

    @Override
    public void delete(Usuario usuario) {

        try {
            String cedula = usuario.getCedula();
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF();
                if (cedula.trim().equals(cedulaArchivo.trim())) {
                    archivo.writeUTF(llenarEspacios(10));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(50));
                    archivo.writeUTF(llenarEspacios(8));
                    break;
                }
                salto += registro;
            }

        } catch (IOException ex) {
            System.out.println("Error delete usuario");
        }
    }
    
    @Override
    public Usuario iniciarSesion(String correo, String contraseña){
        try {
            int salto = 66;

            while (salto < archivo.length()) {
                archivo.seek(salto);

                String correoArchivo = archivo.readUTF();
                String contraseñaArchivo = archivo.readUTF();

                System.out.println(correoArchivo);
                System.out.println(contraseñaArchivo);

                System.out.println(correo + " " + contraseña);

                if (correo.equals(correoArchivo.trim()) && contraseña.equals(contraseñaArchivo.trim())) {

                    archivo.seek(salto - 66);
                    usuario = new Usuario(archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim(), correoArchivo, contraseñaArchivo);
                    return usuario;
                }
                salto += registro;
            }

        } catch (IOException ex) {
            System.out.println("Error escritu o lectura (iniciar sesion) ");
        }

        return null;
    }
    
    
     public String llenarEspacios(int espacios) {
        String aux = "";
        return String.format("%-" + espacios + "s", aux);
    }

    @Override
    public Usuario readCorreo(String correo) {
        int salto = 66;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);

                String correoArchivo = archivo.readUTF();
                String contraseñaArchivo = archivo.readUTF();

                System.out.println(correoArchivo);
                System.out.println(contraseñaArchivo);

                System.out.println(correo);

                if (correo.equals(correoArchivo.trim())) {

                    archivo.seek(salto - 66);
                    usuario = new Usuario(archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim(), correoArchivo, contraseñaArchivo);
                    return usuario;
                }
                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error read Correo");
        }
        return null;
    }

    @Override
    public Map<String, Usuario> findAll() {
        return null;
    }   
}
