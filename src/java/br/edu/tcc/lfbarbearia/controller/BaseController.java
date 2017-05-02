package br.edu.tcc.lfbarbearia.controller;

import br.edu.tcc.lfbarbearia.dao.BaseDao;
import br.edu.tcc.lfbarbearia.entidades.InterfaceEntidades;
import static br.edu.tcc.lfbarbearia.util.FacesUtils.addErrorMessage;
import static br.edu.tcc.lfbarbearia.util.FacesUtils.addInfoMessage;
import java.io.Serializable;
import static java.lang.System.out;
import java.util.List;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.faces.event.ActionEvent;

public class BaseController<T, ID> implements Serializable {

    private BaseDao<T, ID> objetoDao;

    public BaseDao<T, ID> getObjetoDao() {
        return objetoDao;
    }
    
    private T objeto;

    public T getObjeto() {
        return objeto;
    }

    public BaseController() {
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }

    public void setObjetoDao(BaseDao<T, ID> objetoDao) {
        this.objetoDao = objetoDao;
    }

    public void atualizar(ActionEvent event) {
        try {
            if (validacoes(event)) {
                objetoDao.update((T) objeto);
                metodoDepoisDoSalvarAtualizar();
                addInfoMessage("Dados atualizados com sucesso!");
            }
            
        } catch (Exception e) {
            addErrorMessage("Um erro ocorreu na atualização do registro. Informe ao administrados o sistema o seguinte erro: " + e.toString());
            e.printStackTrace();
        }
    }

    public void metodoDepoisDoSalvarAtualizar() {
    }
    
    public void salvar(ActionEvent event) {
        try {
            if (validacoes(event)) {
                objetoDao.save((T) objeto);
                metodoDepoisDoSalvarAtualizar();
                addInfoMessage("Dados salvo com sucesso!");
                objetoLimpo();
            }
        } catch (Exception e) {
            addErrorMessage("Um erro ocorreu na gravação do registro. Informe ao administrados o sistema o seguinte erro: " + e.toString());
            e.printStackTrace();
        }
    }

    public void excluir(ActionEvent event) {
        Integer id = ((InterfaceEntidades) objeto).getId();
        Integer codigo = 0;
        try {
            objetoDao.delete((T) objeto);
            objetoLimpo();
            ((InterfaceEntidades) objeto).setId(id);
            objetoLimpo();
            addInfoMessage("Dados excluidos com sucesso!");
        } catch (Exception e) {
            addInfoMessage("Não foi possível excluír. O registro não pode ser excluído por um erro interno ou por ser referênciado por um outro registro.");
            out.println("Erro ao excluir " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List todos() {
        return objetoDao.getAll();
    }

    public List pesquisar(String sql) {
        return objetoDao.pesq(sql, "");
    }

    public T buscarPorChave(Object chave) {
        return (T) objetoDao.getByID((ID) chave);
    }

    public void objetoLimpo() {
        try {
            objeto = (T) objeto.getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            getLogger(BaseController.class.getName()).log(SEVERE, null, ex);
        }
    }

    public InterfaceEntidades objetoPreenchido(Object data) {
        return (InterfaceEntidades) data;
    }

    public Boolean validacoes(ActionEvent event) {
        return true;
    }

    public void alterar(ActionEvent click) {       
        editar(click);
    }
  
    public void editar(ActionEvent event) {
        if ((getObjeto() != null) && ((InterfaceEntidades) getObjeto()).getId() != null) {
        }
    }

    public void visualizar(ActionEvent event) {
    }

    public void inserir(ActionEvent event) {
        objetoLimpo();
    }

    public void cancelar(ActionEvent event) {
        if (((InterfaceEntidades) getObjeto()).getId() != null) {
            setObjeto(objetoDao.getByID((ID) ((InterfaceEntidades) getObjeto()).getId()));
        } else {
            objetoLimpo();
        }
    }

    public void salvarRegistro(ActionEvent event) {
        if (((InterfaceEntidades) objeto).getId() != null) {
            atualizar(event);
        } else {
            salvar(event);
        }
    }
    
//    public void editarLinha (ActionEvent event){
//       objetoDao = (BaseDao<T, ID>) event.getComponent().getAttributes().get("editSelection");
//        
//        //event.getComponent().getAttributes().get("editSelection");
//    } 
}
