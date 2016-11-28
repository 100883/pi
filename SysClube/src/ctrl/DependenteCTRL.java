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
    public void IncluirDependente(DependenteBO dependenteBo) throws Exception {
        DependenteDAO.IncluirDependente(dependenteBo);
    }
    public void AlterarDependente(DependenteBO dependenteBo) throws Exception {
        DependenteDAO.AlterarDependente(dependenteBo);
    }
    public DependenteBO BuscaDependente(DependenteBO dependenteBo) throws Exception {
        DependenteBO retorno = new DependenteBO();
        retorno = dependenteDao.BuscaDependente(dependenteBo);
        return retorno;
    }
}
