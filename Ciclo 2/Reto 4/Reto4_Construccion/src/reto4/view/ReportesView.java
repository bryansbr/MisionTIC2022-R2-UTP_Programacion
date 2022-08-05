/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto4.view;

import java.sql.*;
import reto4.model.vo.*;
import reto4.controller.ReportesController;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class ReportesView {
    private static ReportesController controladorReportes;
    
    public ReportesView() {
        controladorReportes = new ReportesController();
    }
    
    private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }
    
    public void proyectosFinanciadosPorBanco(String banco) {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO "
                + repitaCaracter('=', 37));
        
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s", "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));
            
            // Imprimir en pantalla la información del proyecto
            try {
                List<ProyectoBancoVo> proyectos = controladorReportes.listarProyectosPorBanco(banco);

                for(ProyectoBancoVo proyecto : proyectos) {
                    System.out.println(proyecto.darFormato());
                }
            } catch(SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
    
    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {
        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
                + repitaCaracter('=', 1));
        
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %14s", "ID", "VALOR "));
            System.out.println(repitaCaracter('-', 29));

            // Imprimir en pantalla la información del total adeudado
            try {
                List<DeudasPorProyectoVo> deudas = controladorReportes.listarDeudasPorProyecto(limiteInferior);

                for(DeudasPorProyectoVo deuda : deudas) {
                    System.out.println(deuda.darFormato());
                }
            } catch(SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
    
    public void lideresQueMasGastan() {
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %14s", "LIDER", "VALOR "));
        System.out.println(repitaCaracter('-', 41));
        
        // Imprimir en pantalla la información de los líderes
        try {
            List<ComprasDeLiderVo> compras = controladorReportes.listarComprasDeLider();
            
            for(ComprasDeLiderVo compra : compras) {
                System.out.println(compra.darFormato());
            }
        } catch(SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}