/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;
import bo.DependenteBO;
import persistencia.DependenteDAO;

/**
 *
 * @author Gui Freitas
 */
public class DependenteCTRL {
    public DependenteBO dependenteBo = new DependenteBO();
    public DependenteDAO dependenteDao = new DependenteDAO();
    public void IncluirCliente(DependenteBO dependenteBo) throws Exception {
        DependenteDAO.IncluirCliente(dependenteBo);
    }
    public void AlterarCliente(DependenteBO dependenteBo) throws Exception {
        DependenteDAO.AlterarCliente(dependenteBo);
    }
    public DependenteBO BuscaCliente(DependenteBO dependenteBo) throws Exception {
        DependenteBO retorno = new DependenteBO();
        retorno = dependenteDao.BuscaCliente(dependenteBo);
        return retorno;
    }
}
