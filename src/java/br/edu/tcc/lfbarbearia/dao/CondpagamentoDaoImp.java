package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Condpagamento;
import java.io.Serializable;
import javax.ejb.Stateless;


//@DaoAcao
@Stateless
public class CondpagamentoDaoImp  extends BaseDaoImp<Condpagamento, Integer> implements CondpagamentoDao, Serializable{

}
