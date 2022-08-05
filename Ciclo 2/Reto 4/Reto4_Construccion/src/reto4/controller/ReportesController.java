/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto4.controller;

import reto4.model.dao.*;
import reto4.model.vo.*;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Bryan
 */
public class ReportesController {
    private final ProyectoBancoDao proyectoBancoDao;
    private final ComprasDeLiderDao comprasDeLiderDao;
    private final DeudasPorProyectoDao deudasPorProyectoDao;
    
    public ReportesController() {
        proyectoBancoDao = new ProyectoBancoDao();
        comprasDeLiderDao = new ComprasDeLiderDao();
        deudasPorProyectoDao = new DeudasPorProyectoDao();
    }

    public List<ProyectoBancoVo> listarProyectosPorBanco(String banco) throws SQLException {
        return proyectoBancoDao.listar(banco);
    }
    
    public List<DeudasPorProyectoVo> listarDeudasPorProyecto(Double limiteInferior) throws SQLException {
        return deudasPorProyectoDao.listar(limiteInferior);
    }
    
    public List<ComprasDeLiderVo> listarComprasDeLider() throws SQLException {
        return comprasDeLiderDao.listar();
    }
}
