/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caritas;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Castro
 */
public class Insertar extends javax.swing.JDialog {

    /**
     * Creates new form Insertar
     */
    GestionCoordinador gestionCoordinador = new GestionCoordinador();
    GestionVoluntario gestionVoluntario = new GestionVoluntario();
    GestionSalidas gestionSalidas = new GestionSalidas();
    //Crear un objeto DefaultListModel
    DefaultListModel listModel = new DefaultListModel();
    Calendar calendar = Calendar.getInstance();
    Salidas salidas = null;
    int ultimaIDSalidasIntroducida;
    Date fecha;
    Time hora;
    int cod_Coordinador;
    int cod_voluntario;
    String observaciones;
    Coordinador[] arrayParaJComboBox=null;
    Voluntario[] arrayParaJComboBox2=null;
    Salidas salidasEditar = null;
    boolean editar=false;
    int cod_salidas;
    
    
    public Insertar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         
    }public void volverAMostar() {
        Caritas_principal mostrarTabla = new Caritas_principal();
        mostrarTabla.mostrarTabla();
        //mostrarTabla.setVisible(true);
        
    }
    
    public void nuevo() {
        editar=false;
        //System.out.println(salidasEditar.getObservaciones());
       //if (salidasEditar== null)
       //{
        //Estos Dos codigos hacen que el desplegable coja todos los datos.
        int numElementos = gestionCoordinador.getCodigosDeCoordinadores().size();
        arrayParaJComboBox = new Coordinador[numElementos];
        gestionCoordinador.getCodigosDeCoordinadores().toArray(arrayParaJComboBox);
        ComboBoxModel c = new DefaultComboBoxModel(arrayParaJComboBox);
        jComboBox1.setModel(c);
       

        int numElementos2 = gestionVoluntario.getTodosVoluntarios().size();
        arrayParaJComboBox2 = new Voluntario[numElementos2];
        gestionVoluntario.getTodosVoluntarios().toArray(arrayParaJComboBox2);
        ComboBoxModel c2 = new DefaultComboBoxModel(arrayParaJComboBox2);
        jComboBox2.setModel(c2);

         //ahora ponemos la fecha y hora actual en las variables fecha y hora.
        String patron1 = "yyyy'-'MM'-'dd";
        String patron2 = "HH':'mm':'ss";
        SimpleDateFormat formatoFechaPersonalFecha = new SimpleDateFormat(patron1);
        SimpleDateFormat formatoFechaPersonalHora = new SimpleDateFormat(patron2);
        fecha= Date.valueOf(formatoFechaPersonalFecha.format(calendar.getTime())); 
        hora= Time.valueOf(formatoFechaPersonalHora.format(calendar.getTime()));
        
    }
    
    public void setSalida(Salidas salida) {
        editar=true;
        int numElementos = gestionCoordinador.getCodigosDeCoordinadores().size();
        int numElementos2 = gestionVoluntario.getTodosVoluntarios().size();
        this.salidasEditar = salida;
        if(salidasEditar.getCod_salida()!= -1) {
            jLabel6.setText(salidasEditar.getCod_salida()+"");
        } else {
            jLabel6.setText("Nuevo");
        }        
        jTextArea1.setText(salidasEditar.getObservaciones());
        
        
        for(int i=0; i<numElementos; i++) 
        {
            if(arrayParaJComboBox[i].getCod_Coordinador()== salidasEditar.getCod_Coordinador() )
            {
                jComboBox1.setSelectedIndex(i);
                i=numElementos;
            }
        }
        for(int i=0; i<numElementos2; i++) 
        {
            if(arrayParaJComboBox2[i].getCod_voluntario()== salidasEditar.getCod_voluntario() )
            {
                jComboBox2.setSelectedIndex(i);
                i=numElementos2;
            }
        }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insertar una Salida");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ID Salida: ");

        jLabel2.setText("Codigo Cordinador:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Codigo Voluntario:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextArea1.setColumns(15);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(4);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel4.setText("Observaciones:");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Foto de Observaciones:");

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, 0, 150, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean anadido=false;
        if(editar==true)
        {
            cod_salidas = salidasEditar.getCod_salida();
            cod_Coordinador=arrayParaJComboBox[jComboBox1.getSelectedIndex()].getCod_Coordinador();
            cod_voluntario =arrayParaJComboBox2[jComboBox2.getSelectedIndex()].getCod_voluntario();
            observaciones = jTextArea1.getText();
            salidas = new Salidas(cod_salidas,fecha,hora,cod_Coordinador,cod_voluntario,observaciones);
           anadido= gestionSalidas.update(salidas);
           if (anadido == true)
           {
               JOptionPane.showMessageDialog(this, "Se ha Modificado con Exito!", "Informacion",JOptionPane.WARNING_MESSAGE );
           
           }
           this.setVisible(false);

        }else
        {
            //se rellenan las demas variables.
            cod_Coordinador=arrayParaJComboBox[jComboBox1.getSelectedIndex()].getCod_Coordinador();
            cod_voluntario =arrayParaJComboBox2[jComboBox2.getSelectedIndex()].getCod_voluntario();
            observaciones = jTextArea1.getText();
            salidas = new Salidas(fecha,hora,cod_Coordinador,cod_voluntario,observaciones,null);
            ultimaIDSalidasIntroducida=gestionSalidas.insert(salidas);
            jTextArea1.setText("");
            jComboBox2.setSelectedIndex(0);
            JOptionPane.showMessageDialog(this, 
                    "Se ha Introducido Correctamente", 
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            
            this.volverAMostar();
        }
        this.volverAMostar();
        this.setVisible(false);
        this.volverAMostar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.volverAMostar();
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Insertar dialog = new Insertar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
