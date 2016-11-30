/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import bo.ChaleBO;
import bo.ClienteBO;
import bo.LocarChaleBO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gui Freitas
 */
public class LocarChaleDAO {

    public void IncluirLocacao(LocarChaleBO locarchaleBo) throws Exception {
        Conexao conexao = new Conexao();
        String SQL = "INSERT INTO locacao (num_aluguel, codigo_cli, num_chale, status, qdtDias, vlrDia, totalDias) "
                + "VALUES (" + locarchaleBo.getNum_aluguel()            + ","
                             + "'" + locarchaleBo.getMatriculaSocio()   + "',"
                             + "'" + locarchaleBo.getNum_chale()        + "',"
                             + "'Alugado'"                              + ","
                             + locarchaleBo.getQtdDiarias()             + ","
                             + locarchaleBo.getVlrDiarias()             + "," 
                             + locarchaleBo.getTotalDiaria()            + ")";

        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();

    }

    public void AlterarLocacao(LocarChaleBO locarchaleBo) {
        Conexao conexao = new Conexao();
        String SQL = "UPDATE locacao SET "
                + "num_aluguel = '" + locarchaleBo.getNum_aluguel() + "',"
                + "codigo_cli = '" + locarchaleBo.getMatriculaSocio() + "',"
                + "num_chale = " + locarchaleBo.getNum_chale() + ","
                + "qdtDias = " + locarchaleBo.getQtdDiarias()+ ","
                + "vlrDia = " + locarchaleBo.getVlrDiarias()+ ","
                + "totalDias = " + locarchaleBo.getTotalDiaria()+ ","
                + " WHERE num_aluguel = " + locarchaleBo.getNum_aluguel() + "";

        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public LocarChaleBO BuscaLocacao(LocarChaleBO locarchaleBo) throws SQLException {
        LocarChaleBO retorno = new LocarChaleBO();
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        String SQL = "SELECT * FROM locacao WHERE num_aluguel = " + locarchaleBo.getNum_aluguel() + "";

        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);

        if (rs.next()) {
            retorno.setMatriculaSocio(rs.getInt("matriculaSocio"));
            retorno.setNum_chale(rs.getInt("num_chale"));
            retorno.setStatus(rs.getString("status"));

        }
        rs.close();
        conexao.desconectaBD();
        return retorno;

    }

    public ClienteBO BuscaCliente(ClienteBO clienteBo) throws Exception {
        ClienteBO retorno = new ClienteBO();
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        String SQL = "SELECT * FROM clientes WHERE codigo_cli = " + clienteBo.getCodigo() + "";
        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);
        if (rs.next()) {
            retorno.setNome(rs.getString("nome_cli"));
            retorno.setCodigo(rs.getInt("codigo"));

        }
        rs.close();
        conexao.desconectaBD();
        return retorno;
    }

    public ChaleBO BuscaChale(ChaleBO chaleBo) throws Exception {
        ChaleBO retorno = new ChaleBO();
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        String SQL = "SELECT * FROM chales WHERE codigo_chale = " + chaleBo.getCod_chale() + "";

        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);

        if (rs.next()) {
            retorno.setCod_chale(rs.getInt("cod_chale"));
            retorno.setDesc_chale(rs.getString("desc_chale"));

        }
        rs.close();
        conexao.desconectaBD();
        return retorno;
    }

}
