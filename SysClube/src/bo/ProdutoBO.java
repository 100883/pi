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
public class ProdutoBO {
    private String codigo;
    private int minimo;
    private boolean status;
    private String nome;
    private float valor_prod;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * @return the valor_prod
     */
    public float getValor_prod() {
        return valor_prod;
    }

    /**
     * @param valor_prod the valor_prod to set
     */
    public void setValor_prod(float valor_prod) {
        this.valor_prod = valor_prod;
    }

    
}
