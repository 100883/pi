/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import bo.ChaleBO;
import bo.ClienteBO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gui Freitas
 */
public class ChaleDAO {
    public void AlterarChale(ChaleBO chaleBo) throws Exception {
        Conexao conexao = new Conexao();
        String SQL = "UPDATE chales SET cod_chale = " + "'" + chaleBo.getCod_chale()+ "'"
                + ", desc_chale = '" + chaleBo.getDesc_chale()+ "'"
                + " WHERE cod_chale = " + chaleBo.getCod_chale()+ "";
        
        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public void IncluirChale(ChaleBO chaleBo) throws Exception {
        Conexao conexao = new Conexao();
        String SQL = "INSERT INTO chales (cod_chale, desc_chale, status) "
                + "VALUES (" + chaleBo.getCod_chale()+ ","
                + "'" + chaleBo.getDesc_chale() + "',"
                + "'Disponível')";
                               
        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public ChaleBO BuscaChale(ChaleBO chaleBo) throws Exception {
        ChaleBO retorno = new ChaleBO();
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        String SQL = "SELECT * FROM chales WHERE cod_chale = " + chaleBo.getCod_chale() + "";
        
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
    
    public ArrayList listar(String desc) throws SQLException {
        ChaleBO chaleBo = new ChaleBO();
        ResultSet rs = null;
        Conexao conexao = new Conexao();

        ArrayList dados = new ArrayList();
        String SQL = "SELECT * FROM chales WHERE desc_chale LIKE '%" + desc + "%';";
        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);

        while (rs.next()) {

            chaleBo.setCod_chale(rs.getInt("cod_chale"));
            chaleBo.setDesc_chale(rs.getString("desc_chale"));
            chaleBo.setStatus(rs.getString("status"));
            dados.add(chaleBo);
        }
        rs.close();
        conexao.desconectaBD();
        return dados;

    }
    
}
