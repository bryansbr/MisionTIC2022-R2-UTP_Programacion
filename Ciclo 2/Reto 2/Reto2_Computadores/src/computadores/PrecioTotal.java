package computadores;

/**
 *
 * @author Bryan
 */
public class PrecioTotal {
    Double totalComputadores = 0.0;
    Double totalComputadoresPortatiles = 0.0; 
    Double totalComputadoresMesa = 0.0; 
    Computadores[] listaComputadores;

    public PrecioTotal(Computadores[] pComputadores) {
        this.listaComputadores = pComputadores;
    }
    
    public void mostrarTotales() {
        for (int i = 0; i < listaComputadores.length; i++) {
            if (listaComputadores[i] instanceof Computadores) {
                totalComputadores+= listaComputadores[i].calcularPrecio();
            }
            if (listaComputadores[i] instanceof ComputadoresMesa) {
                totalComputadoresMesa+= listaComputadores[i].calcularPrecio();
            }  
            if (listaComputadores[i] instanceof ComputadoresPortatiles) {
                totalComputadoresPortatiles+= listaComputadores[i].calcularPrecio();
            }            
        }
        System.out.println("La suma del precio de los computadores es de " + totalComputadores);
        System.out.println("La suma del precio de los computadores de mesa es de " + totalComputadoresMesa);
        System.out.print("La suma del precio de los computadores portátiles es de " + totalComputadoresPortatiles);
    }
}
