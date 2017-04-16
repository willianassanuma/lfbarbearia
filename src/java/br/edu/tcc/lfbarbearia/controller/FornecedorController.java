package br.edu.tcc.lfbarbearia.controller;


import br.edu.tcc.lfbarbearia.dao.FornecedorDao;
import br.edu.tcc.lfbarbearia.entidades.Fornecedor;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named(value="fornecedorController")
@Stateless
public class FornecedorController extends BaseController<Fornecedor, Integer> implements Serializable {

    @EJB
    private FornecedorDao fornecedorDao;
    
    public FornecedorController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Fornecedor());
        setObjetoDao(fornecedorDao);
    }

    @Override
    public Fornecedor getObjeto() {
        return super.getObjeto();
    }

    @Override
    public void setObjeto(Fornecedor objeto) {
        super.setObjeto(objeto);
    } 
  
}
