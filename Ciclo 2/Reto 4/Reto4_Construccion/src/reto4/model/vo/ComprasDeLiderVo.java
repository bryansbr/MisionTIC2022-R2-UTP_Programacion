/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto4.model.vo;

/**
 *
 * @author Bryan
 */
public class ComprasDeLiderVo {
    private String lider;
    private Double valor;
    
    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public String darFormato() {
        return String.format("%-25s %,15.1f", lider, valor);
    }
}
