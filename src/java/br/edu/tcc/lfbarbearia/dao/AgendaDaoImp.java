package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Agenda;
import java.io.Serializable;
import javax.ejb.Stateless;


//@DaoAcao
@Stateless
public class AgendaDaoImp  extends BaseDaoImp<Agenda, Integer> implements AgendaDao, Serializable{

}
