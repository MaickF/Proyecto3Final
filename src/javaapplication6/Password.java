/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/**
*Clase Password
*
*Contiene una contraseña y una longitud
*
*@author Fabián Villalobos Rodríguez
*@version 1.1
*/
import java.util.concurrent.ThreadLocalRandom;

public class Password{

  //Atributos
  
  /**
  *Longitud mínima de la contarseña
  */
  private int minimo=0;
  
  /**
  *Longitud máxima de la contarseña
  */
  private int maximo=0;
  
  /**
  * caracteres de la contraseña
  */
  private String contraseña;

  //Metodos publicos

  /**
  * Devuelve la longitud máxima
  * @return longitud máxima de la contraseña
  */
  public int getMaximo() {
  return maximo;
  }

  /**
  * Modifica la longitud máxima de la contraseña
  * @param longitud máxima a cambiar
  */
  public void setMaximo(int maximo) {
  this.maximo = maximo;
  }
  
  /**
  * Devuelve la longitud mínima
  * @return mínima de la contraseña
  */
  public int getMinimo() {
  return minimo;
  }

  /**
  * Modifica la longitud mínima de la contraseña
  * @param longitud mínima a cambiar
  */
  public void setMinimo(int minimo) {
  this.minimo = minimo;
  }

  /**
  * Devuelve la contraseña
  * @return contraseña
  */
  public String getContraseña() {
  return contraseña;
  }
  
  
  /**
  * Genera una contraseña al azar con la longitud que este definida
  * @return contraseña
  */
  public String generaPassword (){
    String password="";
    int actualMaximo=ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    int actualMinimo=ThreadLocalRandom.current().nextInt(minimo, actualMaximo);
    for (int i=actualMinimo;i<actualMaximo;i++){
      int eleccion=((int)Math.floor(Math.random()*3+1));

      if (eleccion==1){
        char minusculas=(char)((int)Math.floor(Math.random()*(123-97)+97));
        password+=minusculas;
      }else{
        if(eleccion==2){
          char mayusculas=(char)((int)Math.floor(Math.random()*(91-65)+65));
          password+=mayusculas;
        }else{
          char numeros=(char)((int)Math.floor(Math.random()*(58-48)+48));
          password+=numeros;
        }
      }
    }
    return password;
  }
  /**
  * Comprueba la fortaleza de la contraseña
  * @return es fuerte
  */
  public boolean esFuerte(){
    int cuentanumeros=0;
    int cuentaminusculas=0;
    int cuentamayusculas=0;
    for (int i=0;i<contraseña.length();i++){
      if (contraseña.charAt(i)>=97 && contraseña.charAt(i)<=122){
        cuentaminusculas+=1;
      }else{
        if (contraseña.charAt(i)>=65 && contraseña.charAt(i)<=90){
          cuentamayusculas+=1;
      }else{
        cuentanumeros+=1;
        }
      }  
    }
    //Si la constraseña tiene mas de 5 numeros, mas de 1 minuscula
    //y mas de 2 mayusculas
    if (cuentanumeros>=5 && cuentaminusculas>=1 && cuentamayusculas>=2){
    return true;
    }else{
      return false;
    }
  }
  

  /**
  * La contraseña sera la pasada por parametro
  * @param longitud
  */
  public Password (int tMinimo, int tMaximo){
 	setMinimo(tMinimo);
 	setMaximo(tMaximo);
    contraseña=generaPassword();
  }
} 
