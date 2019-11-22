/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Fabian
 */
public class Controlador {
    private Servidor server = null;
    private Cliente cliente = null;
    private GridTest mapa = null;
    private Usuario jugador = null;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ventanaAgregarUsuario agregarUsuario = new ventanaAgregarUsuario();
    private MenuPrincipal menu = new MenuPrincipal();
    
    
    public boolean existeUsuario(String correoUsuario){
      for(int i = 0; i<usuarios.size(); i++){
        if(correoUsuario==usuarios.get(i).getCorreoElectronico()){
          return true;
        }
      }
      return false;
    }
    
    public int obtenerUsuario(String correoUsuario){
      for(int i = 0; i<usuarios.size(); i++){
        if(correoUsuario==usuarios.get(i).getCorreoElectronico()){
          return i;
        }
      }return 0;
    }
    
    
}
