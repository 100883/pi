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
public class ChaleBO {
    //Atributos
    protected int cod_chale;
    protected String desc_chale;
    private String status;
    
      
    //Metodos
    public int getCod_chale() {
        return cod_chale;
    }

    public void setCod_chale(int cod_chale) {
        this.cod_chale = cod_chale;
    }

    public String getDesc_chale() {
        return desc_chale;
    }

    public void setDesc_chale(String desc_chale) {
        this.desc_chale = desc_chale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
