/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

/**
 *
 * @author Gui Freitas
 */
public class LocarChaleBO {
    //Atributos
    private int num_aluguel;
    private int num_chale;
    private String desc_chale;
    private int matriculaSocio;
    private String nomeSocio;
    private String status;
    private int qtdDiarias;
    private double vlrDiarias;
    private double totalDiaria;
    
    //Metodos
    public int getNum_chale() {
        return num_chale;
    }

    public void setNum_chale(int num_chale) {
        this.num_chale = num_chale;
    }

    public int getMatriculaSocio() {
        return matriculaSocio;
    }

    public void setMatriculaSocio(int matriculaSocio) {
        this.matriculaSocio = matriculaSocio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNum_aluguel() {
        return num_aluguel;
    }

    public void setNum_aluguel(int num_aluguel) {
        this.num_aluguel = num_aluguel;
    }

    public int getQtdDiarias() {
        return qtdDiarias;
    }

    public double getVlrDiarias() {
        return vlrDiarias;
    }

    public double getTotalDiaria() {
        return totalDiaria;
    }

    public void setQtdDiarias(int qtdDiarias) {
        this.qtdDiarias = qtdDiarias;
    }

    public void setVlrDiarias(double vlrDiarias) {
        this.vlrDiarias = vlrDiarias;
    }

    public void setTotalDiaria(double totalDiaria) {
        this.totalDiaria = totalDiaria;
    }

    public String getDesc_chale() {
        return desc_chale;
    }

    public String getNomeSocio() {
        return nomeSocio;
    }

    public void setDesc_chale(String desc_chale) {
        this.desc_chale = desc_chale;
    }

    public void setNomeSocio(String nomeSocio) {
        this.nomeSocio = nomeSocio;
    }
    
    
    
}
