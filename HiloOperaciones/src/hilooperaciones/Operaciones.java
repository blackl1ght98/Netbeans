/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilooperaciones;

/**
 *
 * @author guillermo
 */
public class Operaciones implements Runnable{
    int[] vEnteros = {2,4,5,3,5,8,1,4,2,7};
    int tipo;

    public Operaciones(int tipo) {
        this.tipo = tipo;
    }
    @Override
    public void run(){
        int resultado=0;
    switch(tipo){
        case 1:
            for (int i = 0; i < vEnteros.length; i++) {
                resultado += vEnteros[i];
            }
            System.out.println("Soy: "+ Thread.currentThread()+ "Tengo que sumar y el resultado es "+ resultado);
            break;
        case 2:
            for (int i = 0; i < vEnteros.length; i++) {
                resultado -= vEnteros[i];
            }
            System.out.println("Soy: "+ Thread.currentThread()+ "Tengo que restar y el resultado es "+ resultado);
            break;
        case 3:
            resultado=1;
            for (int i = 0; i < vEnteros.length; i++) {
                resultado *= vEnteros[i];
            }
            System.out.println("Soy: "+ Thread.currentThread()+ "Tengo que multiplicar y el resultado es "+ resultado);
            break;
    }
    }
}
