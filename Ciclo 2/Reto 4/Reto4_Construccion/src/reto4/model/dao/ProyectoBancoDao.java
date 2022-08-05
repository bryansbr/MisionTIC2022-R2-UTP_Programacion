/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto4.model.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import reto4.model.vo.ProyectoBancoVo;
import reto4.util.JDBCUtilities;

/**
 *
 * @author Bryan
 */
public class ProyectoBancoDao {
    public List<ProyectoBancoVo> listar(String banco) throws SQLException {      
        List<ProyectoBancoVo> respuesta = new ArrayList<>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        String consulta = """
                        SELECT p.ID_Proyecto AS ID, p.Constructora, p.Ciudad, p.Clasificacion, t.Estrato, l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS LIDER
                        FROM Proyecto p
                        INNER JOIN Tipo t ON (p.ID_Tipo = t.ID_Tipo)
                        INNER JOIN Lider l ON (p.ID_Lider = l.ID_Lider)
                        WHERE p.Banco_Vinculado = ?
                        ORDER BY Fecha_Inicio DESC, Ciudad, Constructora;
                        """;
        
        try {
            stm = conn.prepareStatement(consulta);
            stm.setString(1, banco);
            rs = stm.executeQuery();
            
            while(rs.next()) {
                ProyectoBancoVo vo = new ProyectoBancoVo();
                vo.setId(rs.getInt("ID"));
                vo.setConstructora(rs.getString("Constructora"));
                vo.setCiudad(rs.getString("Ciudad"));
                vo.setClasificacion(rs.getString("Clasificacion"));
                vo.setEstrato(rs.getInt("Estrato"));
                vo.setLider(rs.getString("LIDER"));
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