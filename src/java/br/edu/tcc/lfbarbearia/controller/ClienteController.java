package br.edu.tcc.lfbarbearia.controller;


import br.edu.tcc.lfbarbearia.dao.ClienteDao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import br.edu.tcc.lfbarbearia.entidades.Cliente;

@ViewScoped
@Named(value="clienteController")
@Stateless
public class ClienteController extends BaseController<Cliente, Integer> implements Serializable {

    @EJB
    private ClienteDao clienteDao;
    
    public ClienteController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setObjeto(new Cliente());
        setObjetoDao(clienteDao);
    }

    @Override
    public Cliente getObjeto() {
        return super.getObjeto();
    }

    @Override
    public void setObjeto(Cliente objeto) {
        super.setObjeto(objeto);
    } 
    
}
