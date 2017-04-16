package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Cliente;
import java.io.Serializable;
import javax.ejb.Stateless;


//@DaoAcao
@Stateless
public class ClienteDaoImp  extends BaseDaoImp<Cliente, Integer> implements ClienteDao, Serializable{

}
