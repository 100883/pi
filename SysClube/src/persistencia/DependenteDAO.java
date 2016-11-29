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
import java.util.ArrayList;

/**
 *
 * @author Gui Freitas
 */
public class DependenteDAO {

    public static void IncluirDependente(DependenteBO dependenteBo) {
        Conexao conexao = new Conexao();
        String SQL = "INSERT INTO dependentes (codigo_dep, nome_dep, documento_dep, grau_dep, codigo_cli, fone_cli) "
                + "VALUES (" + dependenteBo.getNome()+ ","
                + "'" + dependenteBo.getCPF()+ "',"
                + "'" + dependenteBo.getGrau_dependencia()+ "',"
                + "'" + dependenteBo.getCod_socio()+ "',"
                + "'" + dependenteBo.getTelefone() + "'";

        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public static void AlterarDependente(DependenteBO dependenteBo) {
        Conexao conexao = new Conexao();
        String SQL = "UPDATE dependentes SET "
                + "codigo_cli = '" + dependenteBo.getCod_socio() + "'"
                + ", nome_dep = '" + dependenteBo.getNome() + "'"
                + ", documento_dep = '" + dependenteBo.getCPF() + "'"
                + ", fone_cli = '" + dependenteBo.getTelefone() + "'"
                + ", grau_dep = '" + dependenteBo.getGrau_dependencia() + "'"
                + " WHERE codigo_cli = " + dependenteBo.getCod_socio() + "";

        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public DependenteBO BuscaDependente(DependenteBO dependenteBo) throws SQLException {
        DependenteBO retorno = new DependenteBO();
        ClienteBO retorno2 = new ClienteBO();

        ResultSet rs = null;
        Conexao conexao = new Conexao();
        String SQL = "SELECT * FROM SOCIOS WHERE codigo_cli = " + dependenteBo.getCod_socio() + "";

        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);

        if (rs.next()) {
            retorno.setCod_socio(rs.getInt("codigo_cli"));
            retorno.setNomeSocio(rs.getString("nome_cli"));
        }

        rs.close();
        conexao.desconectaBD();
        return retorno;
    }
    
    public ArrayList listar() throws SQLException {
        DependenteBO dependenteBo = new DependenteBO();
        ResultSet rs = null;
        Conexao conexao = new Conexao();

        ArrayList dados = new ArrayList();
        String SQL = "select * from dependentes";
        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);

        while (rs.next()) {

            dependenteBo.setNome(rs.getString("nome_dep"));
            dependenteBo.setCPF(rs.getInt("documento_dep"));
            dependenteBo.setGrau_dependencia(rs.getString("grau_dep"));
            dependenteBo.setTelefone(rs.getInt("fone_cli"));
            dados.add(dependenteBo);
        }
        rs.close();
        conexao.desconectaBD();
        return dados;

    }

}
