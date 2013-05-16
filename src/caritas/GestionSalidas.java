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
    int autoincrementoID = -1;
    Salidas salida;

    public GestionSalidas() {
    }
    
    
    
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
   

        }catch  (Exception e) {
            System.out.print("Error");
            System.out.print(sql);
            e.printStackTrace();
        }
       return resultadoSalidas;
   }
    
   
   public int insert(Salidas salida) {

         try {
            stmt = Conexion.conexion.createStatement();
        } catch (SQLException ex) {
            System.out.print("Error en el statement"); 
        }
         
        Date fecha =salida.fecha;
        Time hora =salida.hora;
        int Cod_Coordinador = salida.cod_Coordinador;
        int Cod_voluntario = salida.cod_voluntario;
        String Observaciones = salida.observaciones;
        
        
        String sql = "INSERT INTO salidas (Fecha,Hora,Cod_Coordinador,Cod_voluntario,Observaciones,Foto_observaciones) VALUES "
                + "('"+fecha+"','"+hora+"',"+Cod_Coordinador+","+Cod_voluntario+",'"+Observaciones+"',"+Cod_voluntario+")";
        
        try {
                 stmt.executeUpdate(sql);

        }catch (Exception e) {
            System.out.print("Error");
            System.out.print(sql);
            e.printStackTrace();
        }

             sql = "SELECT DISTINCT LAST_INSERT_ID() FROM salidas ";
        
        try {
                 resultadoLista=stmt.executeQuery(sql);
                 if (resultadoLista.next()) 
                 {
               // al llamar el método getGeneratedKeys(); devuelve una tabla con una sola columna, solo vamos a usar la columna con índice 1 de tipo int
               autoincrementoID= resultadoLista.getInt(1);
               } else 
                 {
                   System.out.print("Error al Sacar el Id del Alumno");
                 } 
                      
        }catch (Exception e) {
            System.out.print("Error");
            System.out.print(sql);
            e.printStackTrace();
        }
        return autoincrementoID;
 
    }
    
   public boolean delete(Salidas salida) {

        try {

            stmt = Conexion.conexion.createStatement();
            String sql = "Delete from salidas where Cod_salida =" + salida.cod_salida;
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("Error al eliminar de la base de datos");
            ex.printStackTrace();
            return false;
        }
        return true;
    }
   
   public boolean update(Salidas salida) {
        try {

            stmt = Conexion.conexion.createStatement();
            String sql = "Update alumno set Fecha =" + salida.getFecha() + ", Hora =" + salida.getHora()+ ", Cod_Coordinador =" + salida.getCod_Coordinador()
                    + ", Cod_voluntario =" + salida.getCod_voluntario()+ ", Observaciones =" + salida.getObservaciones()+ "where Cod_salida =" + salida.getCod_salida();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("Error al actualizar la base de datos");
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
   public void setMandarParaEditar(Salidas salida) {
        this.salida = salida;
    }
    
    public Salidas getMandarParaEditar() {
        return salida;
    }
    
}
