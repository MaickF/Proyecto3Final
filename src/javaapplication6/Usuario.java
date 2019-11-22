package javaapplication6;

import java.util.ArrayList;

/**
 *
 * @author Enzo Morales
 * @author Fabian Villalobos
 * @author Niklas Hermann
 * @author Justin Smith
 */
public class Usuario {
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String contrasenna;
    private int cantidadVictorias;
    private int cantidadEmpates;
    private int cantidadDerrotas;
    private static ArrayList<Usuario> listaUsuarios = new ArrayList();
    
    public Usuario(String pNombre, String pApellidos, String pCorreoElectronico, String pContrasenna) {
        nombre = pNombre;
        apellidos = pApellidos;
        correoElectronico = pCorreoElectronico;
        contrasenna = pContrasenna;
        listaUsuarios.add(this);
    }
    
    public Usuario() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public int getVictorias() {
        return cantidadVictorias;
    }

    public void setVictorias(int cantidadVictorias) {
        this.cantidadVictorias = cantidadVictorias;
    }

    public int getEmpates() {
        return cantidadEmpates;
    }

    public void setEmpates(int cantidadEmpates) {
        this.cantidadEmpates = cantidadEmpates;
    }

    public int getDerrotas() {
        return cantidadDerrotas;
    }

    public void setDerrotas(int cantidadDerrotas) {
        this.cantidadDerrotas = cantidadDerrotas;
    }

    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    public String[] getArregloStrings () {
        String[] arreglo = {nombre, apellidos, correoElectronico};
        return arreglo;
    }
}
