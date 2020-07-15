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
        archivo = new RandomAccessFile("usuario.dat", "rw");
        
        }catch(IOException ex){ 
            System.out.println("Error de Lectura y Escritura");
            ex.printStackTrace();
            
        }     
    }
    
    
    @Override
    public void create(Usuario usuario) {
       
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
    
}
