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

public class GestionCoordinador {
    Statement stmt;
    ResultSet resultadoLista = null;
    Coordinador coordinadorLeido =null;
    
    public Coordinador getCoordinador(int cod_Coordinador){
     try {
            stmt = Conexion.conexion.createStatement();
        } catch (SQLException ex) {
            System.out.print("Error en el statement");
            
        }
        
       
       String sql = "SELECT *"
                        + "FROM Coordinador "
                            + "where Cod_Coordinador = "+cod_Coordinador;
        
        try {
                
           
            
            
                resultadoLista = stmt.executeQuery(sql);
                resultadoLista.next() ;
                   
                int cod_Coordinador1 = resultadoLista.getInt("Cod_Coordinador");
                String nombre = resultadoLista.getString("Nombre");
                String apellidos = resultadoLista.getString("Apellidos");
                String telefono1 = resultadoLista.getString("Telefono1");
                String telefono2= resultadoLista.getString("Telefono2");
                Time horario= resultadoLista.getTime("Horario");
                String observaciones = resultadoLista.getString("Observaciones");

                coordinadorLeido = new Coordinador (cod_Coordinador1,nombre,apellidos,
                        telefono1,telefono2,horario,observaciones);
                

   

        }catch (Exception e) {
            System.out.print("Error");
            System.out.print(sql);
            e.printStackTrace();
        }
       return coordinadorLeido;
   }
    
    
    
}
