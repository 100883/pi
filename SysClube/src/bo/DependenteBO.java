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
    private String telefone;
    private String CPF;
    private String cod_socio;
    protected String grau_dependencia;

    //Metodos
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCod_socio() {
        return cod_socio;
    }

    public void setCod_socio(String cod_socio) {
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
