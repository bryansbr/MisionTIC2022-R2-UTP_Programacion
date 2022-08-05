/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ReportesController;
import java.sql.*;

/**
 *
 * @author Bryan
 */
public class ReportesView {
    
    ReportesController controladorReportes = new ReportesController();
    
    private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }
    
    public void proyectosFinanciadosPorBanco(String banco) throws SQLException {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO "
                + repitaCaracter('=', 37));
        
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s", "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));
            
            // Imprimir en pantalla la información del proyecto
            String reporte = controladorReportes.generarProyectosBanco(banco);
            System.out.println(reporte);
        }
    }
    
    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) throws SQLException {
        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
                + repitaCaracter('=', 1));
        
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %15s", "ID", "VALOR "));
            System.out.println(repitaCaracter('-', 29));
            
            // Imprimir en pantalla la información del total adeudado
            String reporte = controladorReportes.generarDeudasPorProyecto(limiteInferior);
            System.out.println(reporte);
        }
    }
    
    public void lideresQueMasGastan() throws SQLException {
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %15s", "LIDER", "VALOR "));
        System.out.println(repitaCaracter('-', 41));
        
        // Imprimir en pantalla la información de los líderes
            String reporte = controladorReportes.generarComprasLider();
            System.out.println(reporte);
    }
    
}