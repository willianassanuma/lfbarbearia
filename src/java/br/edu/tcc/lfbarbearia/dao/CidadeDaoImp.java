package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Cidade;
import java.io.Serializable;
import javax.ejb.Stateless;


//@DaoAcao
@Stateless
public class CidadeDaoImp  extends BaseDaoImp<Cidade, Integer> implements CidadeDao, Serializable{

}
