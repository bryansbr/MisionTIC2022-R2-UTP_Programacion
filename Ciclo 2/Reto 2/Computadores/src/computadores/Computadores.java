package computadores;

/**
 *
 * @author Bryan
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
