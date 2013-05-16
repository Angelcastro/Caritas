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
public class Salidas {
    
    int cod_salida;
    Date fecha;
    Time hora;
    int cod_Coordinador;
    int cod_voluntario;
    String observaciones;
    Blob foto_observaciones;

    public Salidas(int cod_salida, Date fecha, Time hora, int cod_Coordinador, int cod_voluntario, String observaciones, Blob foto_observaciones) {
        this.cod_salida = cod_salida;
        this.fecha = fecha;
        this.hora = hora;
        this.cod_Coordinador = cod_Coordinador;
        this.cod_voluntario = cod_voluntario;
        this.observaciones = observaciones;
        this.foto_observaciones = foto_observaciones;
    }
    
    public Salidas( Date fecha, Time hora, int cod_Coordinador, int cod_voluntario, String observaciones, Blob foto_observaciones) {
        
        this.fecha = fecha;
        this.hora = hora;
        this.cod_Coordinador = cod_Coordinador;
        this.cod_voluntario = cod_voluntario;
        this.observaciones = observaciones;
        this.foto_observaciones = foto_observaciones;
    }
    
    public Salidas() {
       
    }
    public Salidas(int cod_Coordinador, int cod_voluntario, String observaciones) {
       
    }

    public int getCod_salida() {
        return cod_salida;
    }

    public void setCod_salida(int cod_salida) {
        this.cod_salida = cod_salida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getCod_Coordinador() {
        return cod_Coordinador;
    }

    public void setCod_Coordinador(int cod_Coordinador) {
        this.cod_Coordinador = cod_Coordinador;
    }

    public int getCod_voluntario() {
        return cod_voluntario;
    }

    public void setCod_voluntario(int cod_voluntario) {
        this.cod_voluntario = cod_voluntario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Blob getFoto_observaciones() {
        return foto_observaciones;
    }

    public void setFoto_observaciones(Blob foto_observaciones) {
        this.foto_observaciones = foto_observaciones;
    }
    
    
    
    
    
    
}
