package br.edu.tcc.lfbarbearia.dao;

import java.util.List;


/**
 *
 * @param <T>
 * @param <ID>
 */

public interface BaseDao<T,  ID> {

    public abstract T save(T entidade);

    public abstract T getByID(ID id);

    public abstract void delete(T entidade);

    public abstract void update (T entidade);

    public abstract List<T> getAll();
    
    public abstract List pesq(String query, String ordenacao);
   
    public abstract List<T> getByField(String campo, String texto);

}
