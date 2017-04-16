package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Cliente;
import javax.ejb.Local;

@Local
public interface ClienteDao extends BaseDao<Cliente, Integer>{

}
