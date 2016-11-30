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
                + "VALUES (" + locarchaleBo.getNum_aluguel() + ","
                + "'" + locarchaleBo.getMatriculaSocio() + "',"
                + "'" + locarchaleBo.getNum_chale() + "',"
                + "'Alugado'" + ","
                + locarchaleBo.getQtdDiarias() + ","
                + locarchaleBo.getVlrDiarias() + ","
                + locarchaleBo.getTotalDiaria() + ")";

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
                + "qdtDias = " + locarchaleBo.getQtdDiarias() + ","
                + "vlrDia = " + locarchaleBo.getVlrDiarias() + ","
                + "totalDias = " + locarchaleBo.getTotalDiaria() + ","
                + " WHERE num_aluguel = " + locarchaleBo.getNum_aluguel() + "";

        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public LocarChaleBO BuscaLocacao(LocarChaleBO locarchaleBo) throws SQLException {
        LocarChaleBO retorno = new LocarChaleBO();
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        String SQL = "SELECT\n"
                + "\n"
                + "L.NUM_ALUGUEL, \n"
                + "S.CODIGO_CLI, S.NOME_CLI,\n"
                + "C.COD_CHALE, C.DESC_CHALE,\n"
                + "L.QDTDIAS, L.VLRDIAS, L.TOTALDIAS\n"
                + "\n"
                + "FROM LOCACAO L \n"
                + "INNER JOIN SOCIOS S ON L.CODIGO_CLI = S.CODIGO_CLI\n"
                + "INNER JOIN CHALES C ON L.NUM_CHALE  = C.COD_CHALE\n"
                + "WHERE\n"
                + "L.NUM_ALUGUEL = " + locarchaleBo.getNum_aluguel() + "";

        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);

        if (rs.next()) {
            retorno.setMatriculaSocio(rs.getInt("CODIGO_CLI"));
            retorno.setNomeSocio(rs.getString("NOME_CLI"));
            retorno.setNum_chale(rs.getInt("COD_CHALE"));
            retorno.setDesc_chale(rs.getString("DESC_CHALE"));
            retorno.setQtdDiarias(rs.getInt("QDTDIAS"));
            retorno.setVlrDiarias(rs.getDouble("VLRDIAS"));
            retorno.setTotalDiaria(rs.getDouble("TOTALDIAS"));

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
