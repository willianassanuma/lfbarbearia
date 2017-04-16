package br.edu.tcc.lfbarbearia.controller;


import br.edu.tcc.lfbarbearia.dao.ServicoDao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import br.edu.tcc.lfbarbearia.entidades.Servico;

@ViewScoped
@Named(value="servicoController")
@Stateless
public class ServicoController extends BaseController<Servico, Integer> implements Serializable {

    @EJB
    private ServicoDao servicoDao;
    
    public ServicoController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Servico());
        setObjetoDao(servicoDao);
    }

    @Override
    public Servico getObjeto() {
        return super.getObjeto();
    }

    @Override
    public void setObjeto(Servico objeto) {
        super.setObjeto(objeto);
    } 
    
}
