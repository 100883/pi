/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import bo.ClienteBO;
import bo.DependenteBO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gui Freitas
 */
public class DependenteDAO {

    public static void IncluirCliente(DependenteBO dependenteBo) {
        Conexao conexao = new Conexao();
        String SQL = "INSERT INTO dependentes (cod_socio, nome_socio, nome_dependente, cpf_dependente, telefone, grau_dependencia) "
                + "VALUES (" + dependenteBo.getCod_socio() + ","
                + "'" + dependenteBo.getNomeSocio() + "',"
                + "'" + dependenteBo.getNome() + "',"
                + "'" + dependenteBo.getCPF() + "',"
                + "'" + dependenteBo.getTelefone() + "',"
                + "'" + dependenteBo.getGrau_dependencia() + "'";

        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public static void AlterarCliente(DependenteBO dependenteBo) {
        Conexao conexao = new Conexao();
        String SQL = "UPDATE dependentes SET "
                + "cod_socio = '" + dependenteBo.getCod_socio() + "'"
                + ", nome_socio = '" + dependenteBo.getNomeSocio() + "'"
                + ", nome_dependente = '" + dependenteBo.getNome() + "'"
                + ", cpf_dependente = '" + dependenteBo.getCPF() + "'"
                + ", telefone = '" + dependenteBo.getTelefone() + "'"
                + ", grau_dependencia = '" + dependenteBo.getGrau_dependencia() + "'"
                + " WHERE cod_socio = " + dependenteBo.getCod_socio() + "";

        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public DependenteBO BuscaCliente(DependenteBO dependenteBo) throws SQLException {
        DependenteBO retorno = new DependenteBO();
        ClienteBO retorno2 = new ClienteBO();

        ResultSet rs = null;
        Conexao conexao = new Conexao();
        String SQL = "SELECT * FROM dependentes WHERE cod_socio = " + dependenteBo.getCod_socio() + "";

        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);

        if (rs.next()) {
            retorno.setCod_socio(rs.getInt("cod_socio"));
            retorno2.setNome(rs.getString("nome"));
            retorno.setNome(rs.getString("nome"));
            retorno.setCPF(rs.getInt("CPF"));
            retorno.setTelefone(rs.getInt("telefone"));
            retorno.setGrau_dependencia(rs.getString("grau_dependencia"));
        }

        rs.close();
        conexao.desconectaBD();
        return retorno;
    }

}
