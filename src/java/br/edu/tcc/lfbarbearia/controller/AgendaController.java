package br.edu.tcc.lfbarbearia.controller;


import br.edu.tcc.lfbarbearia.dao.AgendaDao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import br.edu.tcc.lfbarbearia.entidades.Agenda;
import br.edu.tcc.lfbarbearia.entidades.Servico;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

@ViewScoped
@Named(value="agendaController")
@Stateless
public class AgendaController extends BaseController<Agenda, Integer> implements Serializable {

    @EJB
    private AgendaDao agendaDao;
    
    private Servico[] selecionarServicoNaAgenda;

    public Servico[] getSelecionarServicoNaAgenda() {
        return selecionarServicoNaAgenda;
    }

    public void setSelecionarServicoNaAgenda(Servico[] selecionarServicoNaAgenda) {
        this.selecionarServicoNaAgenda = selecionarServicoNaAgenda;
    }
    
    //Cria no prostConstruct o modelo do Schedule
    private ScheduleModel modelSchedule;

    public ScheduleModel getModelSchedule() {
        return modelSchedule;
    }

    public void setModelSchedule(ScheduleModel modelSchedule) {
        this.modelSchedule = modelSchedule;
    }
    
    public AgendaController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Agenda());
        setObjetoDao(agendaDao);
        
        //Constroe o schedule
        modelSchedule = new DefaultScheduleModel();
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
