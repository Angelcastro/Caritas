/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caritas;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Castro
 */
public class Coordinador {
    
    int cod_Coordinador;
    String nombre;
    String apellidos;
    String telefono1;
    String telefono2;
    Time horario;
    String observaciones;
    String cadena;
    
    public Coordinador(int cod_Coordinador, String nombre, String apellidos, String telefono1, String telefono2, Time horario, String observaciones) {
        this.cod_Coordinador = cod_Coordinador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.horario = horario;
        this.observaciones = observaciones;
    }
    
    public Coordinador( String nombre, String apellidos, String telefono1, String telefono2, Time horario, String observaciones) {
       
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.horario = horario;
        this.observaciones = observaciones;
    }
    
    public Coordinador() {
       
    }
    
    public Coordinador(int cod_Coordinador) {
       this.cod_Coordinador = cod_Coordinador;
    }

    public int getCod_Coordinador() {
        return cod_Coordinador;
    }
    
    public String toString() {
        cadena = apellidos+", "+nombre;
        
        return cadena;
    }

    public void setCod_Coordinador(int cod_Coordinador) {
        this.cod_Coordinador = cod_Coordinador;
    }

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

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
    
}
