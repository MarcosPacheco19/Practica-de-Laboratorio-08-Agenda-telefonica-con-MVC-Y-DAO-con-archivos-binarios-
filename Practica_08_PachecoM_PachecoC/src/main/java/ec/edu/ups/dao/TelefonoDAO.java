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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xpacheco
 */
public class TelefonoDAO implements ITelefonoDAO{

    private int codigo;
    private int tamañoRegistro;
    private RandomAccessFile archivo;
    
     public TelefonoDAO() {
        codigo = 0;
        tamañoRegistro = 92;
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
       archivo.writeInt(telefono.getCodigo());
       archivo.writeUTF(telefono.getNumero());
       archivo.writeUTF(telefono.getTipo());
       archivo.writeUTF(telefono.getOperadora());
       archivo.writeUTF(telefono.getUsuario().getCedula());
      
       }catch(IOException ex){
           System.out.println("Error de Lectura y Escritura(create:TelefonoDAO):");
           ex.printStackTrace();
       }

    }

    @Override
    public Telefono read(int id) {
        try {
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();
                if (id == codigoArchivo) {
                    Telefono tele = new Telefono(codigoArchivo, archivo.readUTF(), archivo.readUTF(),
                            archivo.readUTF());
                    return tele;
                }
                salto += tamañoRegistro;
            }

        } catch (IOException ex) {
            System.out.println("Error read telefono");
        }
        return null;

    }

    @Override
    public void update(Telefono telefono) {

        int salto = 0;
        int codigo = telefono.getCodigo();
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();
                if (codigo == codigoArchivo) {
                    archivo.writeUTF(telefono.getNumero());
                    archivo.writeUTF(telefono.getOperadora());
                    archivo.writeUTF(telefono.getTipo());
                    break;
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(upDate Telefono)");
        }
    }


    @Override
    public void delete(int id) {
        
        int salto = 0;

        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();
                if (id == codigoArchivo) {
                    archivo.seek(salto);
                    archivo.writeInt(0);
                    archivo.writeUTF(llenarEspacios(20));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(10));
                    break;
                }
                salto += tamañoRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(upDate Telefono)");
        }

    }

    @Override
    public List<Telefono> findAll() {

         List<Telefono> listaTelefonos = new ArrayList<>();
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);

                int valor = archivo.readInt();
                if (valor > 0) {
                    Telefono tele = new Telefono(valor, archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim());
                    listaTelefonos.add(tele);
                }

                salto += tamañoRegistro;
            }
            return listaTelefonos;
        } catch (IOException ex) {
            System.out.println("error find all telefono");
        }
        return listaTelefonos;
    }

    @Override
    public List<Telefono> telefonosUsuario(String id) {

        List<Telefono> teles = new ArrayList<>();

        try {
            int salto = 80;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String aux = archivo.readUTF().trim();
                System.out.println(aux);
                if (aux.equals(id.trim())) {
                    //System.out.println("hola");

                    archivo.seek(salto - 80);
                    int valor = archivo.readInt();
                    if (valor > 0) {
                        Telefono tele = new Telefono(valor, archivo.readUTF().trim(),
                                archivo.readUTF().trim(), archivo.readUTF().trim());
                        teles.add(tele);
                    }

                }
                salto += tamañoRegistro;
            }
            return teles;
        } catch (IOException ex) {
            System.out.println("Error telefonos usuario");
        }

        return teles;
    }

    @Override
    public int codigoTelefono() {

        
         try {
            if (archivo.length() > 0) {
                
                int aux = (int) (archivo.length() / tamañoRegistro);
                System.out.println(aux);
                return aux;

            } else {
                
                return 0;
            }
        } catch (IOException ex) {
            System.out.println("Error codigo(codigoTelefono)");
        }
        
        return codigo;
    }
    
    

    @Override
    public String llenarEspacios(int espacios) {
        String formato = "";
        return String.format("%-" + espacios + "s", formato);
    }
    
}
