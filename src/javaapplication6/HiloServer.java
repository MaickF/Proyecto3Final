/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Fabian
 */
public class HiloServer extends Thread{
    Socket cliente = null;
    ServerSocket serv;
    Socket socket;
    int condicional = 0;
    int puerto = 9000;
    ObjectOutputStream salida;
    ObjectInputStream entrada;
    Mensajeria mensajes = new Mensajeria();
    Resultados resultados = new Resultados();
    GridTest interfaz = null;
    Usuario jugador = null;
    
    
    public HiloServer(Socket cliente, GridTest mapa, Usuario jugador){
      this.cliente = cliente;
      interfaz=mapa;
      this.jugador = jugador;
    }
    
    public void defecto(){
        resultados.getLabelResultado().setText("Victoria por rendición");
        resultados.getLabelMovimientos().setText(Integer.toString(interfaz.getCantMovimientos())+" Movimientos realizados");
        resultados.getjButton1().addActionListener(new reiniciar());
        resultados.getjButton2().addActionListener(new terminar());
        resultados.setVisible(true);
        int modif = jugador.getVictorias();
        jugador.setVictorias(modif+1);
}
    
    public void desertar() throws IOException{
        resultados.getLabelResultado().setText("Derrota por rendición");
        resultados.getLabelMovimientos().setText(Integer.toString(interfaz.getCantMovimientos())+" Movimientos realizados");
        resultados.getjButton1().addActionListener(new reiniciar());
        resultados.getjButton2().addActionListener(new terminar());
        resultados.setVisible(true);
        int modif = jugador.getDerrotas();
        jugador.setDerrotas(modif+1);
}   
    
    public void rendicion() throws IOException{
        String rendirse ="WhiteFlag";
        salida = new ObjectOutputStream(cliente.getOutputStream());
        salida.writeObject(rendirse);
        salida.flush();
        desertar();
        //terminarConexion();
}

    
    private class reiniciar implements ActionListener
    {           
        @Override
        public void actionPerformed(ActionEvent e)
        { 
            try {
                terminarConexion();
            } catch (IOException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            condicional=0;
            run();
            
        }
 };
    
    public void condicion() throws IOException, InterruptedException{
      while(condicional==0){
          if(interfaz.getEstado()==1){
            System.out.println("WHATHAPENNIG");
            enviar();
          }else if(interfaz.getEstado()==2){
            victoria();
          }else if(interfaz.getEstado()==3){
            System.out.println("WHATHAPENNIG");
            derrota();
          }else if(interfaz.getEstado()==2){
            System.out.println("WHATHAPENNIG");
            empate();
          }
          
         sleep(3000);
      }
       
   }
    
    public void iniciarPartida() throws IOException{
      System.out.println("INICIANDO");
      String primerElemento = Integer.toString(interfaz.getBoardSize());
      String segundoElemento = Integer.toString(interfaz.getBoardSizeCol());
      String tercerElemento = Integer.toString(interfaz.getNumberOfPlayer());
      String cuartoElemento = interfaz.getColor1();
      String quintoElemento = interfaz.getColor2();
        ArrayList<String> creacionPartida= new ArrayList<String>();
        creacionPartida.add(primerElemento);
        creacionPartida.add(segundoElemento);
        creacionPartida.add(tercerElemento);
        creacionPartida.add(cuartoElemento);
        creacionPartida.add(quintoElemento);
        int posBoton = interfaz.getBoardSize();
        JButton[][] botones = interfaz.getButtons();
        botones[posBoton][0].addActionListener(new desertarAccion());
        salida = new ObjectOutputStream(cliente.getOutputStream());
        salida.writeObject(creacionPartida);
        salida.flush();
        mensajes.setVisible(true);
    }
    
    public void enviar() throws IOException{
        System.out.println("ENVIANDO");
        interfaz.setEstado(0);
        interfaz.setTurno(0);
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        posiciones=interfaz.getPos();
        salida = new ObjectOutputStream(cliente.getOutputStream());
        salida.writeObject(posiciones);
        salida.flush();
}
    
    public void recibirDatos() throws IOException, ClassNotFoundException{
        System.out.println("RECIBIENDO");
        inicializarMensajeria();
     while(condicional==0){
        entrada = new ObjectInputStream(cliente.getInputStream());
        Object objetoIndefinido = entrada.readObject();
        String clase = objetoIndefinido.getClass().getSimpleName();
        if(clase.equals("ArrayList")){
            ArrayList<Integer> posiciones = new ArrayList<Integer>();
            posiciones = ( ArrayList<Integer>)objetoIndefinido;
            JButton[][] botones = interfaz.getButtons();
            JButton boton = botones[posiciones.get(0)][posiciones.get(1)];
            interfaz.movimiento(boton);
            interfaz.setEstado(0);
            interfaz.setTurno(1);
               
               
        }else if(clase.equals("String")){
         String mensajeRecibido = "";
         mensajeRecibido = (String)objetoIndefinido;
         if(mensajeRecibido.equals("WhiteFlag")){
             defecto();
         }else{
             mensajes.getVistaMensaje().setText(mensajeRecibido);
         }
       }
    
    }
  }
    
    
    
    private class enviarMensajeAccion implements ActionListener
    {           
        @Override
        public void actionPerformed(ActionEvent e)
        { 
            try {
                enviarMensaje();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 };
    
    private class terminar implements ActionListener
    {           
        @Override
        public void actionPerformed(ActionEvent e)
        { 
            try {
                terminarConexion();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 };
    
    private class desertarAccion implements ActionListener
    {           
        @Override
        public void actionPerformed(ActionEvent e)
        { 
            try {
                rendicion();
            } catch (IOException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 };
    
    public void enviarMensaje() throws IOException{
        String mensajeTexto = jugador.getNombre() + ": " + mensajes.getMensajeTexto().getText();
        salida = new ObjectOutputStream(cliente.getOutputStream());
        salida.writeObject(mensajeTexto);
         salida.flush();
    }
    
    public void inicializarMensajeria(){
      JButton boton = mensajes.getBotonEnviar();
      boton.addActionListener(new enviarMensajeAccion());
    }
    
    public void derrota(){
        resultados.getLabelResultado().setText("Derrota");
         resultados.getLabelMovimientos().setText(Integer.toString(interfaz.getCantMovimientos())+" Movimientos realizados");
         resultados.getjButton1().addActionListener(new reiniciar());
         resultados.getjButton2().addActionListener(new terminar());
         resultados.setVisible(true);
         int modif = jugador.getDerrotas();
         jugador.setDerrotas(modif+1);
}

public void victoria(){
  resultados.getLabelResultado().setText("Victoria");
  resultados.getLabelMovimientos().setText(Integer.toString(interfaz.getCantMovimientos())+" Movimientos realizados");
  resultados.getjButton1().addActionListener(new reiniciar());
  resultados.getjButton2().addActionListener(new terminar());
  resultados.setVisible(true);
  int modif = jugador.getVictorias();
  jugador.setVictorias(modif+1);
}

public void empate(){
  resultados.getLabelResultado().setText("Empate");
  resultados.getLabelMovimientos().setText(Integer.toString(interfaz.getCantMovimientos())+" Movimientos realizados");
  resultados.getjButton1().addActionListener(new reiniciar());
  resultados.getjButton2().addActionListener(new terminar());
  resultados.setVisible(true);
  int modif = jugador.getEmpates();
  jugador.setEmpates(modif+1);
}
    
    
    
    public void terminarConexion() throws IOException{
        condicional=1;
        resultados.dispose();
        interfaz.dispose();
        mensajes.dispose();
        cliente.close();
    }
     
    
   
    
    @Override
    public void run(){
        
      Thread hilo = new Thread(new Runnable() {
      @Override
      public void run() {
      
      try{
        recibirDatos();
      }catch(Exception e){};
      }
      });
      hilo.start();
      try {
            iniciarPartida();
            condicion();
        } catch (IOException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
              
}
   

