/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import bo.ProdutoBO;
import java.sql.ResultSet;

/**
 *
 * @author Gui Freitas
 */
public class ProdutoDAO {

    public void IncluirProduto(ProdutoBO produtoBo) throws Exception {
        Conexao conexao = new Conexao();
        String SQL = ""
                + "INSERT INTO produtos (codigo_prod, nome_prod, status_prod, minimo_prod, valor_prod) " 
                + "VALUES ('" + produtoBo.getCodigo()+ "',"
                + "'" + produtoBo.getNome()+ "',"
                + "'" + produtoBo.getStatus() + "',"
                + "" + produtoBo.getMinimo() + "," 
                + produtoBo.getValor_prod() + ");";

        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public void AlterarProduto(ProdutoBO produtoBo) throws Exception {
        Conexao conexao = new Conexao();
        String cod = produtoBo.getCodigo();
        String SQL = "UPDATE produtos SET "
                + "codigo_prod = '" + produtoBo.getCodigo() + "',"
                + "nome_prod = '" + produtoBo.getNome()+ "',"
                + "status_prod = '" + produtoBo.getStatus() + "'," 
                + "minimo_prod = " + produtoBo.getMinimo() + ","
                + "valor_prod = " + produtoBo.getValor_prod() + ""
                + " WHERE codigo_prod = " + produtoBo.getCodigo()+ "";


        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public ProdutoBO BuscaProduto(ProdutoBO produtoBo) throws Exception {
        ProdutoBO retorno = new ProdutoBO();
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        String SQL = "SELECT * FROM produtos WHERE codigo_prod = " + produtoBo.getCodigo() + "";
        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);
        if (rs.next()) {
            retorno.setStatus(rs.getBoolean("status_prod"));
            retorno.setMinimo(rs.getInt("minimo_prod"));
            retorno.setNome(rs.getString("nome_prod"));
            retorno.setMinimo(rs.getInt("minimo_prod"));
            retorno.setValor_prod(rs.getFloat("valor_prod"));

        }
        rs.close();
        conexao.desconectaBD();
        return retorno;
    }

}
