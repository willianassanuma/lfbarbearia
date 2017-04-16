package br.edu.tcc.lfbarbearia.dao;

import br.edu.tcc.lfbarbearia.entidades.Usuario;
import java.io.Serializable;
import javax.ejb.Stateless;


//@DaoAcao
@Stateless
public class UsuarioDaoImp  extends BaseDaoImp<Usuario, Integer> implements UsuarioDao, Serializable{

}
