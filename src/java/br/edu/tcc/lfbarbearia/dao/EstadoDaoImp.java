package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Estado;
import java.io.Serializable;
import javax.ejb.Stateless;


//@DaoAcao
@Stateless
public class EstadoDaoImp  extends BaseDaoImp<Estado, Integer> implements EstadoDao, Serializable{

}
