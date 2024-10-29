/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terceravideoconferencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author guillermo
 */
public class programa2 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int numero= Integer.parseInt(br.readLine());
       if (numero ==1){
       //ProcessBuilder es como si tuvieramos la terminal abierta
       ProcessBuilder pb = new ProcessBuilder("notepad");
       pb.start();
       }else if(numero ==2){
       ProcessBuilder pb = new ProcessBuilder("calc");
       pb.start();
       }else{
       System.out.println("Opcion no valida");
       }
    }
}
