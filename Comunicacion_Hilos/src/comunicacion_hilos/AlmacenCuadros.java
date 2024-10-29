package comunicacion_hilos;

public class AlmacenCuadros {
    // El recurso compartido es el almacén de cuadros.
    // Tanto el pintor como el vendedor tienen acceso al mismo almacén,
    // por lo que es necesario sincronizar su acceso para evitar que se generen condiciones de carrera o datos inconsistentes.

    private int cuadros = 0; // Inicialmente, no hay cuadros en el almacén.
    
    // Este método es utilizado por el pintor para guardar un cuadro en el almacén.
    public synchronized void guardar() {
        try {
            // Mientras haya un cuadro en el almacén, el pintor debe esperar antes de guardar otro.
            // Si cuadros > 0, significa que el almacén ya tiene un cuadro y no se puede guardar más hasta que el vendedor lo venda.
            while (cuadros > 0) {
                this.wait(); // El pintor entra en espera. Se "pausa" hasta que el vendedor venda el cuadro.
            }
        } catch (InterruptedException e) {
            // Capturamos la posible excepción en caso de que el hilo sea interrumpido mientras espera.
        }
        
        // Una vez que el almacén está vacío, el pintor puede guardar un cuadro.
        cuadros++;
        System.out.println("Pintado cuadro: " + cuadros);

        // Notifica al vendedor que ya hay un cuadro disponible para vender en el almacén.
        // Esto "despierta" al hilo vendedor que estaba esperando.
        this.notify();
    }

    // Este método es utilizado por el vendedor para sacar (vender) un cuadro del almacén.
    public synchronized void sacar() {
        try {
            // Mientras no haya cuadros en el almacén, el vendedor debe esperar.
            // Si cuadros == 0, significa que el almacén está vacío y el vendedor no puede vender nada.
            while (cuadros == 0) {
                this.wait(); // El vendedor entra en espera hasta que el pintor guarde un cuadro.
            }
        } catch (InterruptedException e) {
            // Capturamos la posible excepción en caso de que el hilo sea interrumpido mientras espera.
        }

        // Una vez que hay al menos un cuadro en el almacén, el vendedor puede sacarlo (venderlo).
        cuadros--;
        System.out.println("Vendido cuadro: " + cuadros);

        // Notifica al pintor que ahora el almacén está vacío y puede guardar otro cuadro.
        this.notify();
    }
}
