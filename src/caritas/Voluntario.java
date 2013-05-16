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
public class Voluntario {
    
    int cod_voluntario;
    String nombre;
    String apellidos;
    String dni;
    String direccion;
    String telefono1;
    String telefono2;
    Date fecha_empadronamiento;
    String zona;
    Time horario;
    String observaciones;
    Blob cod_qr;
    String cadena;

    public Voluntario(int cod_voluntario, String nombre, String apellidos, String dni, String direccion, String telefono1, String telefono2, Date fecha_empadronamiento, String zona, Time horario, String observaciones, Blob cod_qr) {
        this.cod_voluntario = cod_voluntario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.fecha_empadronamiento = fecha_empadronamiento;
        this.zona = zona;
        this.horario = horario;
        this.observaciones = observaciones;
        this.cod_qr = cod_qr;
    }
    
    public Voluntario( String nombre, String apellidos, String dni, String direccion, String telefono1, String telefono2, Date fecha_empadronamiento, String zona, Time horario, String observaciones, Blob cod_qr) {
   
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.fecha_empadronamiento = fecha_empadronamiento;
        this.zona = zona;
        this.horario = horario;
        this.observaciones = observaciones;
        this.cod_qr = cod_qr;
    }

  public Voluntario() {
        
    }
    public String toString() {
        cadena = apellidos+", "+nombre;
        
        return cadena;
    }
    public int getCod_voluntario() {
        return cod_voluntario;
    }

    public void setCod_voluntario(int cod_voluntario) {
        this.cod_voluntario = cod_voluntario;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Date getFecha_empadronamiento() {
        return fecha_empadronamiento;
    }

    public void setFecha_empadronamiento(Date fecha_empadronamiento) {
        this.fecha_empadronamiento = fecha_empadronamiento;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
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

    public Blob getCod_qr() {
        return cod_qr;
    }

    public void setCod_qr(Blob cod_qr) {
        this.cod_qr = cod_qr;
    }
    
    
    
    
}
