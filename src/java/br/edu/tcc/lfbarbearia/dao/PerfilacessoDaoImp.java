package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Perfilacesso;
import java.io.Serializable;
import javax.ejb.Stateless;


//@DaoAcao
@Stateless
public class PerfilacessoDaoImp  extends BaseDaoImp<Perfilacesso, Integer> implements PerfilacessoDao, Serializable{

}
