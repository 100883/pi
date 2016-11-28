/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import bo.ChaleBO;
import java.sql.ResultSet;

/**
 *
 * @author Gui Freitas
 */
public class ChaleDAO {
    public void AlterarChale(ChaleBO chaleBo) throws Exception {
        Conexao conexao = new Conexao();
        String SQL = "UPDATE chales SET nome_cli = "
                + "'" + chaleBo.getCod_chale()+ "'"
                + ", tipo_cli = '" + chaleBo.getDesc_chale()+ "'"
                + " WHERE codigo_cli = " + chaleBo.getCod_chale()+ "";
        
        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public void IncluirChale(ChaleBO chaleBo) throws Exception {
        Conexao conexao = new Conexao();
        String SQL = "INSERT INTO chales (nome_cli,tipo_cli,documento_cli,codigo_conv,cep_cli,numero_cli,complemento_cli,fone_cli,fax_cli,email_cli) "
                + "VALUES (" + chaleBo.getCod_chale()+ ","
                + "'" + chaleBo.getDesc_chale()+ "'";
                               
        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
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
