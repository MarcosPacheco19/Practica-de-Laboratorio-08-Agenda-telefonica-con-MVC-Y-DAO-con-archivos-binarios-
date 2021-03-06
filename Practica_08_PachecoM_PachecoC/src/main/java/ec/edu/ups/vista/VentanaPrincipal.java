/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author linar
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    
    private UsuarioDAO usuarioDao;
    private TelefonoDAO telefonoDao;
    
    private ControladorUsuario controladorUsuario;

    private VentanaIniciarSesion ventanaInicioSesion;
    private VentanaRegistrarUsuarios ventanaRegistrarUsuario;
    private VentanaGestionTelefonos ventanaGestionTelefonos;
    private VentanaBuscarUsuarios ventanaListar;
    private VentanaGestionUsuario ventanaGestionUsuario;

    private Locale localizacion;
    private ResourceBundle mensajes;
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        
        setLocation(450, 200);
        menuAgenda.setVisible(false);
        menuItemCerrarSesion.setVisible(false);

        telefonoDao = new TelefonoDAO();
        usuarioDao = new UsuarioDAO();
        controladorUsuario = new ControladorUsuario(usuarioDao, telefonoDao);

        ventanaInicioSesion = new VentanaIniciarSesion(controladorUsuario, this);
        ventanaRegistrarUsuario = new VentanaRegistrarUsuarios(controladorUsuario);
        ventanaGestionTelefonos = new VentanaGestionTelefonos(controladorUsuario);
        ventanaListar = new VentanaBuscarUsuarios(controladorUsuario);
        ventanaGestionUsuario = new VentanaGestionUsuario(controladorUsuario);

        desktopPane.add(ventanaInicioSesion);
        desktopPane.add(ventanaRegistrarUsuario);
        desktopPane.add(ventanaGestionTelefonos);
        desktopPane.add(ventanaListar);
        desktopPane.add(ventanaGestionUsuario);

        localizacion = new Locale("es","EC");
        mensajes = ResourceBundle.getBundle("ec.ups.edu.idiomas.mensajes", localizacion);
        cambiarIdiomas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuItemIniciarSesion = new javax.swing.JMenuItem();
        menuItemRegistrar = new javax.swing.JMenuItem();
        menuItemListar = new javax.swing.JMenuItem();
        menuItemCerrarSesion = new javax.swing.JMenuItem();
        menuItemSalir = new javax.swing.JMenuItem();
        menuAgenda = new javax.swing.JMenu();
        menuItemTelefonos = new javax.swing.JMenuItem();
        menuItemUsuarios = new javax.swing.JMenuItem();
        menuIdioma = new javax.swing.JMenu();
        menuItemEspañol = new javax.swing.JMenuItem();
        menuItemIngles = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        menuInicio.setText("Inicio");

        menuItemIniciarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menuItemIniciarSesion.setText("Iniciar Sesion");
        menuItemIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIniciarSesionActionPerformed(evt);
            }
        });
        menuInicio.add(menuItemIniciarSesion);

        menuItemRegistrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        menuItemRegistrar.setText("Registar Usuario");
        menuInicio.add(menuItemRegistrar);

        menuItemListar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menuItemListar.setText("Listar Telefonos");
        menuItemListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListarActionPerformed(evt);
            }
        });
        menuInicio.add(menuItemListar);

        menuItemCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuItemCerrarSesion.setText("Cerrar Sesion");
        menuInicio.add(menuItemCerrarSesion);

        menuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSalir.setText("Salir");
        menuInicio.add(menuItemSalir);

        jMenuBar1.add(menuInicio);

        menuAgenda.setText("Agenda");

        menuItemTelefonos.setText("Telefonos");
        menuItemTelefonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTelefonosActionPerformed(evt);
            }
        });
        menuAgenda.add(menuItemTelefonos);

        menuItemUsuarios.setText("Usuarios");
        menuAgenda.add(menuItemUsuarios);

        jMenuBar1.add(menuAgenda);

        menuIdioma.setText("Idioma");

        menuItemEspañol.setText("Español");
        menuIdioma.add(menuItemEspañol);

        menuItemIngles.setText("Ingles");
        menuIdioma.add(menuItemIngles);

        jMenuBar1.add(menuIdioma);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemIniciarSesionActionPerformed
        cerrarVentanas();

        ventanaInicioSesion.setVisible(true);
    
    }//GEN-LAST:event_menuItemIniciarSesionActionPerformed

    
    private void menuItemTelefonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTelefonosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemTelefonosActionPerformed

    private void menuItemListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemListarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    
     public void cambiarIdiomas() {

        menuInicio.setText(mensajes.getString("menuInicio"));
        menuAgenda.setText(mensajes.getString("menuGestion"));
        menuIdioma.setText(mensajes.getString("menuIdioma"));

        menuItemIniciarSesion.setText(mensajes.getString("menuItemIniciarSesion"));
        menuItemRegistrar.setText(mensajes.getString("menuItemRegistrarUsuario"));
        menuItemListar.setText(mensajes.getString("menuItemBuscarUsuario"));
        menuItemCerrarSesion.setText(mensajes.getString("menuItemCerrarSesion"));
        menuItemSalir.setText(mensajes.getString("menuItemExit"));
        menuItemTelefonos.setText(mensajes.getString("menuItemGestionTelefonos"));
        menuItemUsuarios.setText(mensajes.getString("menuItemGestionUsuario"));
        menuItemEspañol.setText(mensajes.getString("menuItemEspanol"));
        menuItemIngles.setText(mensajes.getString("menuItemIngles"));
        
        ventanaInicioSesion.setTitle(mensajes.getString("menuItemIniciarSesion"));
        ventanaInicioSesion.getCorreo().setText(mensajes.getString("correo"));
        ventanaInicioSesion.getPassword().setText(mensajes.getString("password"));
        ventanaInicioSesion.getBtnInciarSesion().setText(mensajes.getString("menuItemIniciarSesion"));
        ventanaInicioSesion.getBtnAtras().setText(mensajes.getString("atras"));
        
    }
     
      public JMenuItem getMenuItemCerrarSesion() {
        return menuItemCerrarSesion;
    }

    public JMenu getMenuAgenda() {
        return menuAgenda;
    }

    public JMenuItem getMenuItemIniciarSesion() {
        return menuItemIniciarSesion;
    }

    public JMenuItem getMenuItemUsuarios() {
        return menuItemUsuarios;
    }
    
     public void cerrarVentanas() {
        ventanaGestionTelefonos.setVisible(false);
        ventanaInicioSesion.setVisible(false);
        ventanaListar.setVisible(false);
        ventanaRegistrarUsuario.setVisible(false);
        ventanaGestionUsuario.setVisible(false);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAgenda;
    private javax.swing.JMenu menuIdioma;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuItemCerrarSesion;
    private javax.swing.JMenuItem menuItemEspañol;
    private javax.swing.JMenuItem menuItemIngles;
    private javax.swing.JMenuItem menuItemIniciarSesion;
    private javax.swing.JMenuItem menuItemListar;
    private javax.swing.JMenuItem menuItemRegistrar;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenuItem menuItemTelefonos;
    private javax.swing.JMenuItem menuItemUsuarios;
    // End of variables declaration//GEN-END:variables
}


