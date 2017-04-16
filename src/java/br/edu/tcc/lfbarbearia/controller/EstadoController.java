package br.edu.tcc.lfbarbearia.controller;


import br.edu.tcc.lfbarbearia.entidades.Estado;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import br.edu.tcc.lfbarbearia.dao.EstadoDao;
import br.edu.tcc.lfbarbearia.util.FacesUtils;
import com.sun.javafx.logging.PulseLogger;
import java.util.EventObject;
import javax.faces.event.ActionEvent;

@ViewScoped
@Named(value="estadoController")
@Stateless
public class EstadoController extends BaseController<Estado, Integer> implements Serializable {

    @EJB
    private EstadoDao EstadoDao;
    
    public EstadoController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Estado());
        setObjetoDao(EstadoDao);
    }

    @Override
    public Estado getObjeto() {
        return super.getObjeto();
    }

    @Override
    public void setObjeto(Estado objeto) {
        super.setObjeto(objeto);
    } 
  
    
}
