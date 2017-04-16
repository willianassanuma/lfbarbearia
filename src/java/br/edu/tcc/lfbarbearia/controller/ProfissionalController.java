package br.edu.tcc.lfbarbearia.controller;


import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import br.edu.tcc.lfbarbearia.dao.ProfissionalDao;
import br.edu.tcc.lfbarbearia.entidades.Profissional;

@ViewScoped
@Named(value="profissionalController")
@Stateless
public class ProfissionalController extends BaseController<Profissional, Integer> implements Serializable {

    @EJB
    private ProfissionalDao profissionalDao;
    
    public ProfissionalController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Profissional());
        setObjetoDao(profissionalDao);
    }

    @Override
    public Profissional getObjeto() {
        return super.getObjeto();
    }

    @Override
    public void setObjeto(Profissional objeto) {
        super.setObjeto(objeto);
    } 
  
    
}
