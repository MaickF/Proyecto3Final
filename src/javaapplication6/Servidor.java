/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;
import java.net.*;
import java.io.*;
import javax.mail.MessagingException;
/**
* @author Jorge V
*/
public class Servidor {
    ServerSocket serv;
    Socket socket;
    int puerto = 9000;
    ObjectOutputStream salida;
    ObjectInputStream entrada;
    GridTest interfaz = null;
    Usuario jugador = null;
    public void inicio() throws IOException{
    serv = new ServerSocket(puerto);
    socket = new Socket();
    GridTest interfaz = new GridTest(0);
    this.interfaz=interfaz;
    this.interfaz.setTurno(1);
    Usuario jose = new Usuario("Jose", "Castillo", "JCASti11@gmail.com", "1234Queso");
    jugador = jose;
    try{
        while(true){
            
        socket = serv.accept();
        
        HiloServer hilo = new HiloServer(socket, interfaz, jugador);
        hilo.start();
      }
        
    }catch(Exception e){};
    }
    
    public static void main (String [ ] args) throws IOException, MessagingException {
      
      Servidor cli = new Servidor();
      cli.inicio();
      
}
}