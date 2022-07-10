/**
 *
 * @author Bryan Biojó
 */
public class Main {

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
