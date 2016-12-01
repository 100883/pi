/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import bo.UsuarioBO;
import ctrl.UsuarioCTRL;
import java.sql.ResultSet;

/**
 *
 * @author Gui Freitas
 */
public class UsuarioDAO{

    public void IncluirUsuario(UsuarioBO usuarioBo) throws Exception {
        Conexao conexao = new Conexao();
        String SQL = "INSERT INTO usuarios (matricula_usu, cpf_usu, nome_usu, acesso_usu, senha_usu, status_usu) "
                + "VALUES ("    + usuarioBo.getMatricula()      + ","    
                                + "'" + usuarioBo.getCpf()      + "',"
                                + "'" + usuarioBo.getNome()     + "'," 
                                + "'" + usuarioBo.getAcesso()   + "',"
                                + "'" + usuarioBo.getSenha()    + "',"
                                + usuarioBo.getStatus()         + ")";
        
        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public void AlterarUsuario(UsuarioBO usuarioBo) throws Exception {
        Conexao conexao = new Conexao();
        String SQL = "UPDATE usuarios SET "
                                + "status_usu = '" + usuarioBo.getStatus() 
                                + "', cpf_usu = '" + usuarioBo.getCpf() 
                                + "', nome_usu = '" + usuarioBo.getNome() 
                                + "', acesso_usu = '" + usuarioBo.getAcesso() 
                                + "', senha_usu = '" + usuarioBo.getSenha() 
                 + "' WHERE matricula_usu = " + usuarioBo.getMatricula() + "";
        
        conexao.conectaBD();
        conexao.executaSQL(SQL);
        conexao.desconectaBD();
    }

    public UsuarioBO BuscaMatricula(UsuarioBO usuarioBo) throws Exception {
        UsuarioBO retorno = new UsuarioBO();
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        
        String SQL = "SELECT * FROM usuarios WHERE matricula_usu = " + usuarioBo.getMatricula() + "";
        
        conexao.conectaBD();
        rs = conexao.executaConsulta(SQL);
        
        if (rs.next()) {
            retorno.setMatricula(rs.getInt("matricula_usu"));
            retorno.setCpf(rs.getString("cpf_usu"));
            retorno.setNome(rs.getString("nome_usu"));
            retorno.setSenha(rs.getString("senha_usu"));
            retorno.setAcesso(rs.getString("acesso_usu"));
            retorno.setStatus(rs.getBoolean("status_usu"));
        }
        rs.close();
        conexao.desconectaBD();
        return retorno;
    }
}
