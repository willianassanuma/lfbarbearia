package br.edu.tcc.lfbarbearia.controller;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import br.edu.tcc.lfbarbearia.dao.PerfilacessoDao;
import br.edu.tcc.lfbarbearia.entidades.Perfilacesso;

@ViewScoped
@Named(value="perfilAcessoController")
@Stateless
public class PerfilacessoController extends BaseController<Perfilacesso, Integer> implements Serializable {

    @EJB
    private PerfilacessoDao PerfilacessoDao;
    
    public PerfilacessoController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Perfilacesso());
        setObjetoDao(PerfilacessoDao);
    }

    @Override
    public Perfilacesso getObjeto() {
        return super.getObjeto();
    }

    @Override
    public void setObjeto(Perfilacesso objeto) {
        super.setObjeto(objeto);
    } 
  
    
}
