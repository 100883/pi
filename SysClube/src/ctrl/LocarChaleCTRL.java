/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import bo.ChaleBO;
import bo.ClienteBO;
import bo.LocarChaleBO;
import persistencia.ChaleDAO;
import persistencia.ClienteDAO;
import persistencia.LocarChaleDAO;

/**
 *
 * @author Gui Freitas
 */
public class LocarChaleCTRL {
    
    public LocarChaleBO locarchaleBo = new LocarChaleBO();
    public LocarChaleDAO locarchaleDao = new LocarChaleDAO();
    public void IncluirLocacao(LocarChaleBO locarchaleBo) throws Exception {
        locarchaleDao.IncluirLocacao(locarchaleBo);
    }
    public void AlterarLocacao(LocarChaleBO locarchaleBo) throws Exception {
        locarchaleDao.AlterarLocacao(locarchaleBo);
    }
    public LocarChaleBO BuscaLocacao(LocarChaleBO locarchaleBo) throws Exception {
        LocarChaleBO retorno = new LocarChaleBO();
        retorno = locarchaleDao.BuscaLocacao(locarchaleBo);
        return retorno;
    }
    
    
    
}
