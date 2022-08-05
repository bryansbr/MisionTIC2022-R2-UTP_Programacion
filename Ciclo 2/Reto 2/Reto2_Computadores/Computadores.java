/**
 *
 * @author Bryan Biojó
 */

public class Computadores {

    // Variables
    protected Double precioBase;
    protected Integer peso;
    protected char consumoW;
    
    // Constantes
    protected final static Double PRECIO_BASE = 100.0;
    protected final static Integer PESO_BASE = 5;
    protected final static char CONSUMO_W_BASE = 'F';
    
    // CONSTRUCTORES
    // Llama a las constantes de clase declaradas por defecto.
    public Computadores() {
        this(PRECIO_BASE, PESO_BASE, CONSUMO_W_BASE);
    }
    
    // Si solamente se le pasan 2 parámetros, los devuelve junto con el consumo por defecto.
    public Computadores(Double precioBase, Integer peso) {
        this(precioBase, peso, CONSUMO_W_BASE);    
    }
    
    // Si se le pasan los 3 parámetos, los devuelve.
    public Computadores(Double precioBase, Integer peso, char consumoW) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.consumoW = consumoW;      
    }    
    
    // MÉTODOS
    public Double calcularPrecio() {
        Double adicion = 0.0;
        
        switch(consumoW) {
            case 'A':
                adicion+= 100.0; 
                break;
            case 'B':
                adicion+= 80.0; 
                break;
            case 'C':
                adicion+= 60.0; 
                break;
            case 'D':
                adicion+= 50.0; 
                break;
            case 'E':
                adicion+= 30.0; 
                break;
            case 'F':
                adicion+= 10.0; 
                break;
            default:
                //System.out.println("Opción no encontrada.");
                break;
        }        
        
        if (peso >= 0 && peso <= 19) {
            adicion+= 10.0;
        } 
        else if (peso >= 20 && peso <= 49) {
            adicion+= 50.0;
        } 
        else if (peso >= 50 && peso <= 79) {
            adicion+= 80.0;
        } 
        else if (peso >= 80) {
            adicion+= 100;
        } 
        else {
            System.out.println("El valor del peso es incorrecto.");
        }        
        
        return precioBase + adicion;
    }

    // Getters para pasar los valores de las variables de tipo 'protected' a las clases hijas.
    public Double getPrecioBase() {
        return precioBase;
    }

    public Integer getPeso() {
        return peso;
    }

    public char getConsumoW() {
        return consumoW;
    }
}

public class ComputadoresMesa extends Computadores {

    private final static Integer ALMACENAMIENTO_BASE = 50;
    private Integer almacenamiento;

    public ComputadoresMesa() {
        this(PRECIO_BASE, PESO_BASE, CONSUMO_W_BASE, ALMACENAMIENTO_BASE);
    }
    
    public ComputadoresMesa(Double precioBase, Integer peso) {
        this(precioBase, peso, CONSUMO_W_BASE, ALMACENAMIENTO_BASE);
    } 
    
    public ComputadoresMesa(Double precioBase, Integer peso, char consumoW, Integer almacenamiento) {
        super(precioBase, peso, consumoW);
        this.almacenamiento = almacenamiento;
    }  
    
    @Override
    public Double calcularPrecio() {
        Double adicion = super.calcularPrecio();
        
        if (almacenamiento > 100) {
            adicion+= 50.0;
        }
        
        return adicion;
    }
    
    public Integer getCarga() { 
        return almacenamiento; 
    }

}

public class ComputadoresPortatiles extends Computadores {
    
    private final static Integer PULGADAS_BASE = 20;
    private Integer pulgadas;
    private boolean camaraITG;
    
    public ComputadoresPortatiles() {
        this(PRECIO_BASE, PESO_BASE, CONSUMO_W_BASE, PULGADAS_BASE, false);
    }
    
    public ComputadoresPortatiles(Double precioBase, Integer peso) {
        this(precioBase, peso, CONSUMO_W_BASE, PULGADAS_BASE, false);
    }

    public ComputadoresPortatiles(Double precioBase, Integer peso, char consumoW, Integer pulgadas, boolean camaraITG) {
        super(precioBase, peso, consumoW);
        this.pulgadas = pulgadas;
        this.camaraITG = camaraITG;
    }    
    
    @Override
    public Double calcularPrecio() {
        Double adicion = super.calcularPrecio();
        
        if (pulgadas > 40) {
            adicion+= precioBase * 0.3;
        }
        
        if (camaraITG) {
            adicion+= 50.0;
        }
        
        return adicion;
    }
    
}

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

public class Main {
    // Método main
    public static void main(String[] args) {
        
        // Pruebas Públicas 
        Computadores computadores[] = new Computadores[6]; 
        computadores[0] = new Computadores(150.0, 70, 'A'); 
        computadores[1] = new ComputadoresMesa(70.0, 40); 
        computadores[2] = new ComputadoresPortatiles(600.0, 70, 'D', 50, false); 
        computadores[3] = new Computadores(); 
        computadores[4] = new Computadores(500.0, 60, 'A'); 
        computadores[5] = new Computadores(700.0, 50, 'D'); 
        
        PrecioTotal solucion1 = new PrecioTotal(computadores); 
        solucion1.mostrarTotales(); 
        System.out.println( ); 
        
        Computadores computadores2[] = new Computadores[4]; 
        computadores2[0] = new Computadores(60.0, 10, 'D');
        computadores2[1] = new ComputadoresMesa(300.0, 40, 'Z', 40); 
        computadores2[2] = new ComputadoresPortatiles(50.0, 10, 'A', 70, false); 
        computadores2[3] = new Computadores(50.0, 10); 

        PrecioTotal solucion2 = new PrecioTotal(computadores2); 
        solucion2.mostrarTotales(); 
        System.out.println();       
    }    
}