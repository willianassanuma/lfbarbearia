package br.edu.tcc.lfbarbearia.controller;


import br.edu.tcc.lfbarbearia.dao.InsumoDao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import br.edu.tcc.lfbarbearia.entidades.Insumo;

@ViewScoped
@Named(value="insumoController")
@Stateless
public class InsumoController extends BaseController<Insumo, Integer> implements Serializable {

    @EJB
    private InsumoDao insumoDao;
    
    public InsumoController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Insumo());
        setObjetoDao(insumoDao);
    }

    @Override
    public Insumo getObjeto() {
        return super.getObjeto();
    }

    @Override
    public void setObjeto(Insumo objeto) {
        super.setObjeto(objeto);
    } 
  
    
}
