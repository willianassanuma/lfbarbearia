package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Parametro;
import java.io.Serializable;
import javax.ejb.Stateless;


//@DaoAcao
@Stateless
public class ParametroDaoImp  extends BaseDaoImp<Parametro, Integer> implements ParametroDao, Serializable{

}
