package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Insumo;
import java.io.Serializable;
import javax.ejb.Stateless;


//@DaoAcao
@Stateless
public class InsumoDaoImp  extends BaseDaoImp<Insumo, Integer> implements InsumoDao, Serializable{

}
