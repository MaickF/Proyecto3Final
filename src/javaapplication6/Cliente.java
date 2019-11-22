/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
* @author Jorge V
*/
public class Cliente {
Socket client;
int victoria = 0;
int derrota = 0;
int condicional=0;
int puerto = 9000;
String ip = "192.168.1.2";
ObjectInputStream entrada;
ObjectOutputStream salida;
int estado = 0;
Usuario jugador = null;
Eleccion ventanaEleccion = new Eleccion();
GridTest interfaz = null;
Mensajeria mensajes = new Mensajeria();
ArrayList<String>datosPartida = null;
Resultados resultados = new Resultados(); 

public void condicion() throws IOException, InterruptedException{
  System.out.println("Verificando...");
  while(condicional==0){
    
    if(estado==1){
      //System.out.println(Integer.toString(interfaz.getEstado()));
      if(interfaz.getEstado()==1){
          System.out.println("LOGRADO");
          enviar();
      }else if(interfaz.getEstado()==2){
          derrota();
      }else if(interfaz.getEstado()==3){
        victoria();
      }else if(interfaz.getEstado()==3){
        empate();
      }
        
      }
    sleep(3000);
  }
}

public void derrota(){
  resultados.getLabelResultado().setText("Derrota");
  resultados.getLabelMovimientos().setText(Integer.toString(interfaz.getCantMovimientos2())+" Movimientos realizados");
  resultados.getjButton1().addActionListener(new reiniciar());
  resultados.getjButton2().addActionListener(new terminar());
  resultados.setVisible(true);
  int modif = jugador.getDerrotas();
  jugador.setDerrotas(modif+1);
}

public void victoria(){
  resultados.getLabelResultado().setText("Victoria");
  resultados.getLabelMovimientos().setText(Integer.toString(interfaz.getCantMovimientos2())+" Movimientos realizados");
  resultados.getjButton1().addActionListener(new reiniciar());
  resultados.getjButton2().addActionListener(new terminar());
  resultados.setVisible(true);
  int modif = jugador.getVictorias();
  jugador.setVictorias(modif+1);
}

public void empate(){
  resultados.getLabelResultado().setText("Empate");
  resultados.getLabelMovimientos().setText(Integer.toString(interfaz.getCantMovimientos2())+" Movimientos realizados");
  resultados.getjButton1().addActionListener(new reiniciar());
  resultados.getjButton2().addActionListener(new terminar());
  resultados.setVisible(true);
  int modif = jugador.getEmpates();
  jugador.setEmpates(modif+1);
}

public void enviar() throws IOException{
  System.out.println("Enviando...");
  interfaz.setEstado(0);
  interfaz.setTurno(0);
  ArrayList<Integer> posiciones = new ArrayList<Integer>();
  posiciones=interfaz.getPos();
  salida = new ObjectOutputStream(client.getOutputStream());
  salida.writeObject(posiciones);
  salida.flush();
}


private class inicializar implements ActionListener
    {           
        @Override
        public void actionPerformed(ActionEvent e)
        { 
          iniciarPartida(datosPartida);
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
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 };

public void reinicio() throws IOException{
  int segundos = 0;
  while(segundos!=10){
    inicioCliente();
  }
}

private class reiniciar implements ActionListener
    {           
        @Override
        public void actionPerformed(ActionEvent e)
        { 
            try {
                inicioCliente();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 };

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

public void recibirDatos() throws IOException, ClassNotFoundException, InterruptedException{
     while(condicional==0){ 
        entrada = new ObjectInputStream(client.getInputStream());
        Object objetoIndefinido = entrada.readObject();
        String clase = objetoIndefinido.getClass().getSimpleName();
         System.out.println(clase);
        if(clase.equals("ArrayList")){
          ArrayList indicacion = new ArrayList();
          indicacion = (ArrayList) objetoIndefinido;
          if(indicacion.get(0).getClass().getSimpleName().equals("Integer")){
            ArrayList<Integer> posiciones = new ArrayList<Integer>();
            posiciones = ( ArrayList<Integer>)indicacion;
            JButton[][] botones = interfaz.getButtons();
            JButton boton = botones[posiciones.get(0)][posiciones.get(1)];
            interfaz.movimiento(boton);
            interfaz.setEstado(0);
            interfaz.setTurno(1);
          }else if(indicacion.get(0).getClass().getSimpleName().equals("String")){
               ArrayList<String> partida = new ArrayList<String>();
               partida = ( ArrayList<String>)indicacion;
               datosPartida = partida;
               inicializarEleccion();
               inicializarMensajeria();
          }
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

public void rendicion() throws IOException{
  String rendirse ="WhiteFlag";
  salida = new ObjectOutputStream(client.getOutputStream());
  salida.writeObject(rendirse);
  salida.flush();
  desertar();
}

public void defecto(){
  resultados.getLabelResultado().setText("Victoria por rendición");
  resultados.getLabelMovimientos().setText(Integer.toString(interfaz.getCantMovimientos2())+" Movimientos realizados");
  resultados.getjButton1().addActionListener(new reiniciar());
  resultados.getjButton2().addActionListener(new terminar());
  resultados.setVisible(true);
  int modif = jugador.getVictorias();
  jugador.setVictorias(modif+1);
}

public void desertar() throws IOException{
  resultados.getLabelResultado().setText("Derrota por rendición");
  resultados.getLabelMovimientos().setText(Integer.toString(interfaz.getCantMovimientos2())+" Movimientos realizados");
  resultados.getjButton1().addActionListener(new reiniciar());
  resultados.getjButton2().addActionListener(new terminar());
  resultados.setVisible(true);
  int modif = jugador.getDerrotas();
  jugador.setDerrotas(modif+1);
}

public void inicializarMensajeria(){
  JButton boton = mensajes.getBotonEnviar();
  boton.addActionListener(new enviarMensajeAccion());
}

public void enviarMensaje() throws IOException{
  String mensajeTexto = jugador.getNombre() + ": " + mensajes.getMensajeTexto().getText();
  salida = new ObjectOutputStream(client.getOutputStream());
  salida.writeObject(mensajeTexto);
  salida.flush();
}

public void inicializarEleccion(){
  JButton boton = ventanaEleccion.getBotonIngresar();
  boton.addActionListener(new inicializar());
  JButton botonIgnorar = ventanaEleccion.getBotonIgnorar();
  botonIgnorar.addActionListener(new terminar());
  JLabel filas = ventanaEleccion.getLabelFila();
  JLabel columnnas = ventanaEleccion.getLabelColumna();
  JLabel color1 = ventanaEleccion.getLabelColor1();
  JLabel color2 = ventanaEleccion.getLabelColor2();
  filas.setText(datosPartida.get(0));
  columnnas.setText(datosPartida.get(1));
  color1.setText(datosPartida.get(3));
  color2.setText(datosPartida.get(4));
  ventanaEleccion.setVisible(true);
}

public void terminarConexion() throws IOException{
  condicional=1;
  resultados.dispose();
  interfaz.dispose();
  mensajes.dispose();
  client.close();
}

public void iniciarPartida(ArrayList<String> partida){
  int primerElemento = Integer.parseInt(partida.get(0));
  int segundoElemento = Integer.parseInt(partida.get(1));
  int tercerElemento = Integer.parseInt(partida.get(2));
  String cuartoElemento = partida.get(3);
  String quintoElemento = partida.get(4);
  ventanaEleccion.dispose();
  interfaz = new GridTest(1);
  interfaz.setBoardSize(primerElemento);
  interfaz.setBoardSizeCol(segundoElemento);
  interfaz.setNumberOfPlayer(tercerElemento);
  interfaz.setColor1(cuartoElemento);
  interfaz.setColor2(quintoElemento);
  interfaz.Inicializar();
  interfaz.colorJugador();
  int posBoton = interfaz.getBoardSize();
  JButton[][] botones = interfaz.getButtons();
  botones[posBoton][0].addActionListener(new desertarAccion());
  estado=1;
  condicional = 0;
  mensajes.setVisible(true);
}


    

  public void inicioCliente() throws IOException{
    
    Thread hilo = new Thread(new Runnable() {
        
    @Override
    
    public void run() {
    
    
    try{
        client = new Socket(ip, puerto);
        recibirDatos();
        
    }catch(Exception e){};
    }
   });
    hilo.start();
  }

public static void main (String [ ] args) throws IOException, InterruptedException {
    Cliente cli = new Cliente();
    Usuario fabian = new Usuario("Fabian", "Villalobos", "superfabian58@gmail.com", "asdfghjkl");
    cli.jugador=fabian;
    cli.inicioCliente();
    cli.condicion();
}


}
