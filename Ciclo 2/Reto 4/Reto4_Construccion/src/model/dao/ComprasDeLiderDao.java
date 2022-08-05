/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.*;
import util.JDBCUtilities;

/**
 *
 * @author Bryan
 */
public class ComprasDeLiderDao {
    public String resultado = "";
    
    public ComprasDeLiderDao() throws SQLException {
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet datos; 
        
        String consulta = "SELECT l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS LIDER, SUM(mc.Precio_Unidad * c.Cantidad) AS VALOR\n" +
                    "FROM Proyecto p\n" +
                    "INNER JOIN Lider l ON (p.ID_Lider = l.ID_Lider)\n" +
                    "INNER JOIN Compra c ON (p.ID_Proyecto = c.ID_Proyecto)\n" +
                    "INNER JOIN MaterialConstruccion mc ON (c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion)\n" +
                    "GROUP BY LIDER\n" +
                    "ORDER BY VALOR DESC\n" +
                    "LIMIT 10;";
               
        datos = stmt.executeQuery(consulta);
        
        while (datos.next()) {
            String lider = datos.getString("LIDER");
            Double valor = datos.getDouble("VALOR");
            
            resultado+= String.format("%-25s %,15.1f", lider, valor);
            resultado+= "\n";
        }
    }    
    
}
