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
    private int matriculaSocio;
    private String status;
    
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
    
    
    
}
