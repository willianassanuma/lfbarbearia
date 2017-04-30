package br.edu.tcc.lfbarbearia.controller;


import br.edu.tcc.lfbarbearia.dao.CidadeDao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import br.edu.tcc.lfbarbearia.entidades.Cidade;

@ViewScoped
@Named(value="cidadeController")
@Stateless
public class CidadeController extends BaseController<Cidade, Integer> implements Serializable {

    @EJB
    private CidadeDao CidadeDao;
    
    public CidadeController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Cidade());
        setObjetoDao(CidadeDao);
    }

    @Override
    public Cidade getObjeto() {
        return super.getObjeto();
    }

    @Override
    public void setObjeto(Cidade objeto) {
        super.setObjeto(objeto);
    } 

}
