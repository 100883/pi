/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import bo.ChaleBO;
import persistencia.ChaleDAO;

/**
 *
 * @author Gui Freitas
 */
public class ChaleCTRL {
    public ChaleBO chaleBo = new ChaleBO();
    public ChaleDAO chaleDao = new ChaleDAO();
    public void IncluirChale(ChaleBO chaleBo) throws Exception {
        chaleDao.IncluirChale(chaleBo);
    }
    public void AlterarChale(ChaleBO chaleBo) throws Exception {
        chaleDao.AlterarChale(chaleBo);
    }
    public ChaleBO BuscaChale(ChaleBO chaleBo) throws Exception {
        ChaleBO retorno = new ChaleBO();
        retorno = chaleDao.BuscaChale(chaleBo);
        return retorno;
    }
}
