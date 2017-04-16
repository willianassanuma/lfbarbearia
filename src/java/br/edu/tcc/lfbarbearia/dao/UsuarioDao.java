package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Usuario;
import javax.ejb.Local;

@Local
public interface UsuarioDao extends BaseDao<Usuario, Integer>{

}
