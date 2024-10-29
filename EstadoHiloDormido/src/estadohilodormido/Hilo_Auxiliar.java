/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estadohilodormido;

/**
 *
 * @author guillermo
 */
public class Hilo_Auxiliar extends Thread{
    Panel mi_marcador;
    boolean duerme;

    public Hilo_Auxiliar(boolean duerme,Panel mi_marcador ) {
        this.duerme = duerme;
        this.mi_marcador = mi_marcador;
        
    }
    @Override
  public void run(){
    mi_marcador.valor=0;
    mi_marcador.repaint();
    if(duerme){
    for(int i=1;i<=20;i++){
        mi_marcador.valor=i;
        mi_marcador.repaint();
        try{
        this.sleep(100);
        }catch(InterruptedException e){}
    }
  }else{
    for(int i=1;i<=20;i++){
    mi_marcador.valor=i;
    mi_marcador.repaint();
    
    }
    
    }
    
 }
}
