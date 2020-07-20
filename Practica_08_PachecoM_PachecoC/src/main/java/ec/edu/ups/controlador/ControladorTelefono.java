/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author xpacheco
 */
public class ControladorTelefono {
    
    
    private Telefono telefono;
    private TelefonoDAO telefonoDAO ;

    
    public ControladorTelefono() {
        
    }

    public ControladorTelefono(TelefonoDAO telefonoDAO) {
        this.telefonoDAO = telefonoDAO;
    }

    public void crearTelefono(Telefono telefono){
        telefonoDAO.create(telefono);
    }
    
    public Telefono encontrarTelefono(int codigo){
        
        telefono = telefonoDAO.read(codigo);
        
        return telefono;
    }
    
}
