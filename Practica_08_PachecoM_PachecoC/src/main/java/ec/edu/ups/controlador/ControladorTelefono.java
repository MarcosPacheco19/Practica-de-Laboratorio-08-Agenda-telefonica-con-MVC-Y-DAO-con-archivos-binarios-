/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;
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
    
    private ITelefonoDAO telefonosDAO ;

    
    public ControladorTelefono() {
        
    }

    public ControladorTelefono(ITelefonoDAO telefonosDAO) {
        this.telefonosDAO = telefonosDAO;
    }

    public Telefono crear(Telefono telefono) {
        telefonosDAO.create(telefono);
        return telefono;
    }
    
 
    public void verTelefono(int codigo) {
        telefono = telefonosDAO.read(codigo);
    }
    
    
    public void actualizar(Telefono telefono) {
        telefonosDAO.update(telefono);
    }
    
    public List<Telefono>  verTelefonos() {
        List<Telefono> telefonos;
        telefonos = telefonosDAO.findAll();
        if (!telefonos.isEmpty()) {
            return telefonos;
        } else {
            return null;
        }
    }
    
    public String obtenerSiguienteCodigo() {
        int codigo = telefonosDAO.codigoTelefono();
        return ++codigo + "";
    }
}
