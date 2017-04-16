package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Fornecedor;
import java.io.Serializable;
import javax.ejb.Stateless;


//@DaoAcao
@Stateless
public class FornecedorDaoImp  extends BaseDaoImp<Fornecedor, Integer> implements FornecedorDao, Serializable{

}
