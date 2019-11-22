/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import javax.mail.MessagingException;

/**
 *
 * @author Fabian
 */
public class main {
    public static void main (String [ ] args) throws MessagingException {
        new ventanaMenu().setVisible(true);
        Correo c = new Correo();
        c.enviarCorreo("superfabian58@gmail.com", "Prueba", "Contrasenia");
      
      
}
}
