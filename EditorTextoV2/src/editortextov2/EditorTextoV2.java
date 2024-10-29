/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package editortextov2;
import java.awt.EventQueue;
/**
 *
 * @author guillermo
 */
public class EditorTextoV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
        public void run(){
        new Editor().setVisible(true);
        }              
        });               
    }
    
}
