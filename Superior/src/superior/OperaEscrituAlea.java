package superior;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OperaEscrituSec.java
 *
 * Created on 03-sep-2010, 23:52:15
 */



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 *
 * @author JJBH
 */
public class OperaEscrituAlea extends javax.swing.JFrame {

    /** Creates new form OperaEscrituSec */
    public OperaEscrituAlea() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grabación de cadena en fichero aleatorio");

        jLabel2.setText("Cadena");

        jButton1.setText("Guardar cadena en fichero");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Obtener cadena de la posición:");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setText("0");

        jLabel1.setText("Cadena:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        // Abir, capturar y grabar datos
        try {
            RandomAccessFile miRAFile;
            String s =  jTextField2.getText();
            //dejando string en 25 caracteres
            if (s.length() < 25)
                for(int i=s.length(); i <25; i++)
                    s = s +" ";
            else
                s = s.substring(0,25);

            // Abrimos el fichero de acceso aleatorio
            miRAFile = new RandomAccessFile( "C:\\Users\\guill\\OneDrive\\Escritorio\\blog\\aleatorio.bin","rw" );
            // Nos vamos al final del fichero
            miRAFile.seek( miRAFile.length() );
            // Incorporamos la cadena al fichero
            miRAFile.writeBytes( s );
            // Cerramos el fichero
            miRAFile.close();


        } catch(FileNotFoundException fnfe) { /* Archivo no encontrado */ }
        catch (IOException ioe) { /* Error al escribir */ }
        catch (Exception e) { /* Error de otro tipo*/
          System.out.println(e.getMessage());}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // Inicializar la etiqueta de la cadena encontrada
        jLabel1.setText("No se ha encontrado cadena" );

        // Abir, capturar y grabar datos
        try {
            RandomAccessFile miRAFile;
            String cad = "" ;
            int tam_registro = 25 ;
            long num_registros = 0 ;

            // Abrimos el fichero de acceso aleatorio en modo lectura
            miRAFile = new RandomAccessFile( "C:\\aleatorio.bin","r" );

            num_registros = miRAFile.length()/tam_registro;
            System.out.println("Nº de registros:" + num_registros );

            // Nos vamos al registro que desea el usuario
            int numRegistro = Integer.parseInt(jTextField1.getText()) ;
            int posicion = numRegistro * tam_registro ;
            miRAFile.seek(posicion) ;

            // Leer los bytes de la posición
            for(int i = 0; i < 25; ++i) {
                byte b = miRAFile.readByte();
                cad += (char) b ;
            }
              
            // Introducir en la etiqueta la cadena encontrada
            jLabel1.setText("Cadena encontrada: " + cad);

            // Cerramos el fichero
            miRAFile.close();

        } catch(FileNotFoundException fnfe) { /* Archivo no encontrado */ }
        catch (IOException ioe) { /* Error al escribir */ }
        catch (Exception e) { /* Error de otro tipo*/
          System.out.println(e.getMessage());}
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OperaEscrituAlea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
