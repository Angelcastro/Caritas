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
public class GestionSalidas {
    
    Statement stmt;
    ResultSet resultadoLista = null;
    ArrayList<Salidas> resultadoSalidas = new ArrayList();
    
    
    public ArrayList<Salidas> getSalidas(){
       
    
        try {
            stmt = Conexion.conexion.createStatement();
        } catch (SQLException ex) {
            System.out.print("Error en el statement");
            
        }
        
       
       String sql = "SELECT *"
                        + "FROM salidas ";
        
        try {
                
                resultadoLista = stmt.executeQuery(sql);
                  while (resultadoLista.next()) 
                   {
                        int cod_salida = resultadoLista.getInt("Cod_salida");
                        Date fecha = resultadoLista.getDate("Fecha");
                        Time hora = resultadoLista.getTime("Hora");
                        int cod_Coordinador = resultadoLista.getInt("Cod_Coordinador");
                        int cod_voluntario = resultadoLista.getInt("Cod_voluntario");
                        String observaciones = resultadoLista.getString("Observaciones");
                        Blob foto_observaciones = resultadoLista.getBlob("Foto_observaciones");
                        
                        
       
                        
                        
                        Salidas salida = new Salidas (cod_salida,fecha,hora,cod_Coordinador,cod_voluntario,observaciones,foto_observaciones);
                        resultadoSalidas.add(salida);
                    }
   

        }catch (Exception e) {
            System.out.print("Error");
            System.out.print(sql);
            e.printStackTrace();
        }
       return resultadoSalidas;
   }
    
    
    
    
    
    
    
}
