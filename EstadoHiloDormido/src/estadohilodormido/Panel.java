/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estadohilodormido;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 *
 * @author guillermo
 */
public class Panel extends JPanel {
    public int valor;

    public Panel() {
        valor=0;
        this.setSize(250,50);
        this.setFont(new Font ("Tahoma",0,48));
        
    }
@Override
public void paintComponent(Graphics g){
   super.paintComponent(g);
   int anchuraPanel=this.getWidth();
   String strValor=String.valueOf(valor);
   FontMetrics fontMetrics= g.getFontMetrics();
   int anchuraValor=fontMetrics.stringWidth(strValor);
   g.setColor(Color.black);
   g.fillRect(0, 0, anchuraPanel, this.getHeight());
   if(valor>0){
       g.setColor(Color.yellow);
       g.drawString(strValor,anchuraPanel-anchuraValor,fontMetrics.getAscent()-5);
       
   }
    
 }
}
