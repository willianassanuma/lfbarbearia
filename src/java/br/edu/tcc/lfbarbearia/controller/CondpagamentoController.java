package br.edu.tcc.lfbarbearia.controller;


import br.edu.tcc.lfbarbearia.dao.CondpagamentoDao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import br.edu.tcc.lfbarbearia.entidades.Condpagamento;

@ViewScoped
@Named(value="condpagamentoController")
@Stateless
public class CondpagamentoController extends BaseController<Condpagamento, Integer> implements Serializable {

    @EJB
    private CondpagamentoDao CondpagamentoDao;
    
    public CondpagamentoController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Condpagamento());
        setObjetoDao(CondpagamentoDao);
    }

    @Override
    public Condpagamento getObjeto() {
        return super.getObjeto();
    }

    @Override
    public void setObjeto(Condpagamento objeto) {
        super.setObjeto(objeto);
    } 

    
}
