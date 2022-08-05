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
public class ProyectoBancoDao {

    public String resultado = "";
    
    public ProyectoBancoDao(String banco) throws SQLException {
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet datos; 
        
        String consulta = "SELECT p.ID_Proyecto AS ID, p.Constructora, p.Ciudad, p.Clasificacion, t.Estrato, l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS LIDER\n" +
                    "FROM Proyecto p\n" +
                    "INNER JOIN Tipo t ON (p.ID_Tipo = t.ID_Tipo)\n" +
                    "INNER JOIN Lider l ON (p.ID_Lider = l.ID_Lider)\n" +
                    "WHERE p.Banco_Vinculado = '"+ banco +"'\n" +
                    "ORDER BY Fecha_Inicio DESC, Ciudad, Constructora;";
               
        datos = stmt.executeQuery(consulta);
        
        while (datos.next()) {
            int id = datos.getInt("ID");
            String constructora = datos.getString("Constructora");
            String ciudad = datos.getString("Ciudad");
            String clasificacion = datos.getString("Clasificacion");
            int estrato = datos.getInt("Estrato");
            String lider = datos.getString("LIDER");
            
            resultado+= String.format("%3d %-25s %-20s %-15s %7d %-30s", id, constructora, ciudad, clasificacion, estrato, lider);
            resultado+= "\n";
        }
    }
}
