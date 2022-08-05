/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.dao.ComprasDeLiderDao;
import model.dao.ProyectoBancoDao;
import model.dao.DeudasPorProyectoDao;
import java.sql.SQLException;

/**
 *
 * @author Bryan
 */
public class ReportesController {
    
    public String generarProyectosBanco(String banco) throws SQLException {
        ProyectoBancoDao proyectos = new ProyectoBancoDao(banco);
        
        return proyectos.resultado;
    }
    
    public String generarDeudasPorProyecto(Double limiteInferior) throws SQLException {
        DeudasPorProyectoDao deudas = new DeudasPorProyectoDao(limiteInferior);
        
        return deudas.resultado;
    }
    
    public String generarComprasLider() throws SQLException {
        ComprasDeLiderDao compras = new ComprasDeLiderDao();

        return compras.resultado;
    }
    
}
