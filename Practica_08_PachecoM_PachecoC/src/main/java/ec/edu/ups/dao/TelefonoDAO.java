/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author xpacheco
 */
public class TelefonoDAO implements ITelefonoDAO{

    private RandomAccessFile archivo;
    
     public TelefonoDAO() {
        
        try{  
        archivo = new RandomAccessFile("datos/telefono.dat", "rw");
        
        }catch(IOException ex){ 
            System.out.println("Error de Lectura y Escritura");
            ex.printStackTrace();
            
        }     
    }
    @Override
    public void create(Telefono telefono) {
        try{
       archivo.seek(archivo.length());
       
       archivo.writeUTF(telefono.getNumero());
       archivo.writeUTF(telefono.getTipo());
       archivo.writeUTF(telefono.getOperadora());
      
       }catch(IOException ex){
           System.out.println("Error de Lectura y Escritura(create:TelefonoDAO):");
           ex.printStackTrace();
       }

    }

    @Override
    public Telefono read(String codigo) {
        return null;

    }

    @Override
    public void update(Telefono telefono) {

    }

    @Override
    public void delete(Telefono telefono) {

    }
    
}
