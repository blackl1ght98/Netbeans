package comunicacion_hilos;

public class Hilo_Pintor extends Thread {

    private AlmacenCuadros almacen;

    // Constructor: el pintor recibe una referencia al almacén compartido.
    public Hilo_Pintor(AlmacenCuadros a) {
        almacen = a;
    }

    // Método que se ejecuta cuando se inicia el hilo del pintor.
    public void run() {
        // El pintor pintará y guardará 30 cuadros en total, uno por uno.
        for (int i = 1; i < 30; i++) {
            // Llama al método guardar() del almacén para intentar guardar un cuadro.
            // Si el almacén está lleno (cuadros > 0), el pintor esperará, a que el Hilo_vendedor venda los cuadros.
            // Cuando el cuadro sea guardado, se notifica al vendedor.
            almacen.guardar();
        }
        // Una vez que se pinten los 30 cuadros, el ciclo termina y el pintor deja de producir cuadros.
    }
}
