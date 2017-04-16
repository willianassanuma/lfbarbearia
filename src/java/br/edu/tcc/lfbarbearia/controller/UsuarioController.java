package br.edu.tcc.lfbarbearia.controller;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import br.edu.tcc.lfbarbearia.dao.UsuarioDao;
import br.edu.tcc.lfbarbearia.entidades.Usuario;

@ViewScoped
@Named(value="usuarioController")
@Stateless
public class UsuarioController extends BaseController<Usuario, Integer> implements Serializable {

    @EJB
    private UsuarioDao usuarioDao;
    
    public UsuarioController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Usuario());
        setObjetoDao(usuarioDao);
    }

    @Override
    public Usuario getObjeto() {
        return super.getObjeto();
    }

    @Override
    public void setObjeto(Usuario objeto) {
        super.setObjeto(objeto);
    } 
    
}
