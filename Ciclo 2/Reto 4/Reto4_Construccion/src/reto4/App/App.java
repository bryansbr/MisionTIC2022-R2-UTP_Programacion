/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto4.App;

import reto4.view.ReportesView;
import java.sql.SQLException;

/**
 *
 * @author Bryan
 */
public class App {
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // Reporte 1: Información de los proyectos financiados por un banco determinado.
        var reportesView = new ReportesView();
        var banco = "Conavi";
        reportesView.proyectosFinanciadosPorBanco(banco);
        
        // Reporte 2: Listado del total adeudado en cada proyecto, filtrado por un límite inferior dado.
        var limiteInferior = 50_000d;
        reportesView.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);
        
        // Reporte 3: Listado del top 10 de los líderes que más dinero gastan en sus proyectos para la compra de materiales.
        reportesView.lideresQueMasGastan();  
    }
}
