package br.edu.tcc.lfbarbearia.controller;


import br.edu.tcc.lfbarbearia.dao.AgendaDao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import br.edu.tcc.lfbarbearia.entidades.Agenda;

@ViewScoped
@Named(value="agendaController")
@Stateless
public class AgendaController extends BaseController<Agenda, Integer> implements Serializable {

    @EJB
    private AgendaDao agendaDao;
    
    public AgendaController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Agenda());
        setObjetoDao(agendaDao);
    }
    
    @Override
    public Agenda getObjeto() {
        return super.getObjeto();
    }

    @Override
    public void setObjeto(Agenda objeto) {
        super.setObjeto(objeto);
    }
    
    
    
    
}
