/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto4.model.vo;

/**
 *
 * @author Bryan
 */
public class DeudasPorProyectoVo {
    private Integer id;
    private Double valor;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String darFormato() {
        return String.format("%3d %,15.1f", id, valor);
    }
}
