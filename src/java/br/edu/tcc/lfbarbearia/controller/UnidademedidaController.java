package br.edu.tcc.lfbarbearia.controller;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import br.edu.tcc.lfbarbearia.dao.UnidademedidaDao;
import br.edu.tcc.lfbarbearia.entidades.Unidademedida;

@ViewScoped
@Named(value="unidademedidaController")
@Stateless
public class UnidademedidaController extends BaseController<Unidademedida, Integer> implements Serializable {

    @EJB
    private UnidademedidaDao unidademedidaDao;
    
    public UnidademedidaController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Unidademedida());
        setObjetoDao(unidademedidaDao);
    }

    @Override
    public Unidademedida getObjeto() {
        return super.getObjeto();
    }

    @Override
    public void setObjeto(Unidademedida objeto) {
        super.setObjeto(objeto);
    } 
  
}
