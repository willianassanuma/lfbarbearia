package br.edu.tcc.lfbarbearia.controller;


import br.edu.tcc.lfbarbearia.dao.ParametroDao;
import br.edu.tcc.lfbarbearia.entidades.Parametro;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named(value="parametroController")
@Stateless
public class ParametroController extends BaseController<Parametro, Integer> implements Serializable {

    @EJB
    private ParametroDao parametroDao;
    
    public ParametroController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Parametro());
        setObjetoDao(parametroDao);
    }

    @Override
    public Parametro getObjeto() {
        return super.getObjeto();
    }

    @Override
    public void setObjeto(Parametro objeto) {
        super.setObjeto(objeto);
    } 
    
}
