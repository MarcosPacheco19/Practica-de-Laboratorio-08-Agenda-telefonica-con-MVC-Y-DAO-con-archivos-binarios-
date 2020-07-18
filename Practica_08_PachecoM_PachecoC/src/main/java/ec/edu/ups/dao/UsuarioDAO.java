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

    public UsuarioDAO() {
        
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
       
        return null;
    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public void delete(Usuario usuario) {

    }
    
    @Override
    public boolean Login(String correo, String contraseña){
        try{
            int salto = 60;
            int registro=128;
            
            byte [] correoArreglo = new byte[50];
            byte [] contraseñaArreglo = new byte [8];
            
            while(salto < archivo.length()){
                archivo.seek(salto);
                
                
                String correoArchivo = archivo.readUTF();
                
                
                String contraseñaArchivo = archivo.readUTF();
                
                System.out.println(correoArchivo);
                System.out.println(contraseñaArchivo);
                
                if(correo.equals(correoArchivo.trim())&& contraseña.equals(contraseñaArchivo.trim())){
                    return true;
                }
                salto += registro;
            }
        }catch(IOException ex){
            System.out.println("Error de Lectura y Escritura(Login:UsuarioDAO):");
            ex.printStackTrace();
        }
        return false;
    }
    
}
