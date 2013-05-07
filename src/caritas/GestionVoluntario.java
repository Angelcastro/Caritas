/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caritas;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Castro
 */
public class GestionVoluntario {
    
    Statement stmt;
    ResultSet resultadoLista = null;
    Voluntario voluntarioLeido =null;
    
    
    
    public Voluntario getVoluntario(int cod_voluntario){
     try {
            stmt = Conexion.conexion.createStatement();
        } catch (SQLException ex) {
            System.out.print("Error en el statement");
            
        }
        
       
       String sql = "SELECT *"
                        + "FROM voluntario "
                            + "where Cod_voluntario = "+cod_voluntario;
        
        try {
                
           
            
            
                resultadoLista = stmt.executeQuery(sql);
                resultadoLista.next() ;
                   
                int cod_voluntario1 = resultadoLista.getInt("Cod_voluntario");
                String nombre = resultadoLista.getString("Nombre");
                String apellidos = resultadoLista.getString("Apellidos");
                String dni = resultadoLista.getString("Dni");
                String direccion = resultadoLista.getString("Direccion");
                String telefono1 = resultadoLista.getString("Telefono1");
                String telefono2= resultadoLista.getString("Telefono2");
                Date fecha_empadronamiento = resultadoLista.getDate("Fecha_empadronamiento");
                String zona = resultadoLista.getString("Zona");
                Time horario= resultadoLista.getTime("Horario");
                String observaciones = resultadoLista.getString("Observaciones");
                Blob cod_qr = resultadoLista.getBlob("cod_qr");

                voluntarioLeido = new Voluntario (cod_voluntario1,nombre,apellidos,dni,direccion,
                        telefono1,telefono2,fecha_empadronamiento,zona,horario,observaciones,cod_qr);
                

   

        }catch (Exception e) {
            System.out.print("Error");
            System.out.print(sql);
            e.printStackTrace();
        }
       return voluntarioLeido;
   }
    
    
}
