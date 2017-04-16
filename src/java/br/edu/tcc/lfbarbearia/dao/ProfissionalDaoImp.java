package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Profissional;
import java.io.Serializable;
import javax.ejb.Stateless;


//@DaoAcao
@Stateless
public class ProfissionalDaoImp  extends BaseDaoImp<Profissional, Integer> implements ProfissionalDao, Serializable{

}
