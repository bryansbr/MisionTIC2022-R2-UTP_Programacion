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
public class DeudasPorProyectoDao {
    public String resultado = "";
    
    public DeudasPorProyectoDao(Double limiteInferior) throws SQLException {
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet datos; 
        
        String consulta = "SELECT c.ID_Proyecto, SUM(mc.Precio_Unidad * c.Cantidad) AS VALOR\n" +
                    "FROM Compra c\n" +
                    "INNER JOIN MaterialConstruccion mc ON (c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion)\n" +
                    "WHERE c.Pagado = 'No'\n" +
                    "GROUP BY ID_Proyecto\n" +
                    "HAVING VALOR > "+ limiteInferior +"\n" +
                    "ORDER BY VALOR DESC;";
               
        datos = stmt.executeQuery(consulta);
        
        while (datos.next()) {
            int id = datos.getInt("ID_Proyecto");
            Double valor = datos.getDouble("VALOR");
            
            resultado+= String.format("%3d %,15.1f", id, valor);
            resultado+= "\n";
        }
    }
}
