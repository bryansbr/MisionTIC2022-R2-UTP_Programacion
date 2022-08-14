package retos.reto1;

/**
 *
 * @author Bryan Biojó
 */
public class BecaUniversitaria {

    private int pTiempo;
    private double pMonto;
    private double pInteres;
    
    // CONSTRUCTORES
    public BecaUniversitaria() {
        this.pTiempo = 0;
        this.pMonto = 0;
        this.pInteres = 0;
    }
    
    public BecaUniversitaria(int pTiempo, double pMonto, double pInteres) {
        this.pTiempo = pTiempo;
        this.pMonto = pMonto;
        this.pInteres = pInteres;
    }
    
    // MÉTODOS
    public double calcularInteresSimple() {
        double interesSimple = 0;
        
        if (this.pMonto >= 0 && this.pInteres >= 0 && this.pTiempo >= 0) {
            interesSimple = Math.round(this.pMonto * this.pInteres/100 * this.pTiempo);
        } else {
            System.out.println("No se pueden pasar valores negativos.");
        }
        
        return interesSimple;
    }
    
    public double calcularInteresCompuesto() {         
        double interesCompuesto = 0;
        
        if (this.pMonto >= 0 && this.pInteres >= 0 && this.pTiempo >= 0) {
            interesCompuesto = Math.round(this.pMonto * (Math.pow(1 + this.pInteres/100, this.pTiempo) - 1)); 
        } else {
            System.out.println("No se pueden pasar valores negativos.");
        }
      
        return interesCompuesto;
    }
    
    public String compararInversion() {
        double diferencia = this.calcularInteresCompuesto() - this.calcularInteresSimple();
        
        if (diferencia > 0) {
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
        } else {
            return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        }
    }
        
    public String compararInversion(int pTiempo, double pMonto, double pInteres) {
        this.pTiempo = pTiempo;
        this.pMonto = pMonto;
        this.pInteres = pInteres;
        
        return this.compararInversion();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        // PRUEBAS
        BecaUniversitaria becaUniversitaria = new BecaUniversitaria();
        System.out.println(becaUniversitaria.calcularInteresSimple());
        System.out.println(becaUniversitaria.calcularInteresCompuesto());
        System.out.println(becaUniversitaria.compararInversion(60, 13000, 1.4) + "\n");

        BecaUniversitaria becaUniversitaria1 = new BecaUniversitaria(48, 10000, 2.0);
        System.out.println(becaUniversitaria1.calcularInteresSimple());
        System.out.println(becaUniversitaria1.calcularInteresCompuesto());
        System.out.println(becaUniversitaria1.compararInversion() + "\n");
        
        BecaUniversitaria becaUniversitaria2 = new BecaUniversitaria();
        System.out.println(becaUniversitaria2.calcularInteresSimple());
        System.out.println(becaUniversitaria2.calcularInteresCompuesto());
        System.out.println(becaUniversitaria2.compararInversion() + "\n");
    }
    
}
