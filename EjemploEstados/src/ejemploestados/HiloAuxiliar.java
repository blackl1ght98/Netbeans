/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploestados;

/**
 *
 * @author guillermo
 */
public class HiloAuxiliar extends Thread{

    @Override
    public void run() {
       for(int i=10;i>1;i--){
        System.out.print(i + ",");
        System.out.println (1);
      }
    }
    
}
