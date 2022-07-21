package computadores;

/**
 *
 * @author Bryan
 */
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
