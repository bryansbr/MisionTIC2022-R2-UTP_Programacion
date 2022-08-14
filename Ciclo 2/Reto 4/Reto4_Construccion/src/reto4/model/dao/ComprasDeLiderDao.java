/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto4.model.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import reto4.model.vo.ComprasDeLiderVo;
import reto4.util.JDBCUtilities;

/**
 *
 * @author Bryan
 */
public class ComprasDeLiderDao {
    public List<ComprasDeLiderVo> listar() throws SQLException {      
        List<ComprasDeLiderVo> respuesta = new ArrayList<>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        
        String consulta = """
                        SELECT l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS LIDER, SUM(mc.Precio_Unidad * c.Cantidad) AS VALOR
                        FROM Proyecto p
                        INNER JOIN Lider l ON (p.ID_Lider = l.ID_Lider)
                        INNER JOIN Compra c ON (p.ID_Proyecto = c.ID_Proyecto)
                        INNER JOIN MaterialConstruccion mc ON (c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion)
                        GROUP BY LIDER
                        ORDER BY VALOR DESC
                        LIMIT 10;
                        """;
        
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            
            while(rs.next()) {
                ComprasDeLiderVo vo = new ComprasDeLiderVo();
                vo.setLider(rs.getString("LIDER"));
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
