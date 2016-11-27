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
public class DependenteBO {

    //Atributos
    private String nome;
    protected String nomeSocio;
    private int telefone;
    private int CPF;
    private int cod_socio;
    protected String grau_dependencia;

    //Metodos
    public String getNome() {
        return nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public int getCPF() {
        return CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public int getCod_socio() {
        return cod_socio;
    }

    public void setCod_socio(int cod_socio) {
        this.cod_socio = cod_socio;
    }

    public String getNomeSocio() {
        return nomeSocio;
    }

    public void setNomeSocio(String nomeSocio) {
        this.nomeSocio = nomeSocio;
    }

    public String getGrau_dependencia() {
        return grau_dependencia;
    }

    public void setGrau_dependencia(String grau_dependencia) {
        this.grau_dependencia = grau_dependencia;
    }

}
