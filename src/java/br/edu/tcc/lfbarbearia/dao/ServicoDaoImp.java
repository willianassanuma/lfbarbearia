package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Servico;
import java.io.Serializable;
import javax.ejb.Stateless;


//@DaoAcao
@Stateless
public class ServicoDaoImp  extends BaseDaoImp<Servico, Integer> implements ServicoDao, Serializable{

}
