/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto4.model.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import reto4.model.vo.DeudasPorProyectoVo;
import reto4.util.JDBCUtilities;

/**
 *
 * @author Bryan
 */
public class DeudasPorProyectoDao {
    public List<DeudasPorProyectoVo> listar(Double limiteInferior) throws SQLException {      
        List<DeudasPorProyectoVo> respuesta = new ArrayList<>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        String consulta = """
                        SELECT c.ID_Proyecto, SUM(mc.Precio_Unidad * c.Cantidad) AS VALOR
                        FROM Compra c
                        INNER JOIN MaterialConstruccion mc ON (c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion)
                        WHERE c.Pagado = 'No'
                        GROUP BY ID_Proyecto
                        HAVING VALOR > ?
                        ORDER BY VALOR DESC;
                        """;
        
        try {
            stm = conn.prepareStatement(consulta);
            stm.setDouble(1, limiteInferior);
            rs = stm.executeQuery();
            
            while(rs.next()) {
                DeudasPorProyectoVo vo = new DeudasPorProyectoVo();
                vo.setId(rs.getInt("ID_Proyecto"));
                vo.setValor(rs.getDouble("VALOR"));
                respuesta.add(vo);
            }
        } catch(SQLException e) {
            System.err.print("Error: " + e.getMessage());
        } finally {
            if(rs != null) {
                rs.close();
            }
            
            if(stm != null) {
               stm.close();
            }
            
            if(conn != null) {
                conn.close();
            }
        }
        
        return respuesta;
    }
}
