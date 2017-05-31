package br.edu.tcc.lfbarbearia.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@TransactionAttribute(REQUIRES_NEW)
public class BaseDaoImp<T, ID> implements BaseDao<T, ID> {

    @PersistenceContext(unitName = "barbeariaLFPU")
    private EntityManager entityManager;
    private Class<T> persistentClass;
    private static Logger log;
//    @Resource
//    private UserTransaction userTransaction;

    public BaseDaoImp() {
        log = getLogger(this.getClass().getName());
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T save(T entidade) {
        try {
            getEntityManager().persist(entidade);
        } catch (Exception ex) {
            getLogger(BaseDaoImp.class.getName()).log(SEVERE, null, ex);
        }
        return (T) entidade;
    }

    @Override
    public T getByID(ID id) {
        T entidade = (T) getEntityManager().find(getPersistentClass(), id);
        return entidade;
    }

    @Override
    public void delete(T entidade) {
        try {
            if (!getEntityManager().contains(entidade)) {
                entidade = getEntityManager().merge(entidade);
            }
            getEntityManager().remove(entidade);
        } catch (Exception ex) {
            getLogger(BaseDaoImp.class.getName()).log(SEVERE, null, ex);
        }
    }

    @Override
    public void update(T entidade) {
        try {
            getEntityManager().merge(entidade);
        } catch (Exception ex) {
            getLogger(BaseDaoImp.class.getName()).log(SEVERE, null, ex);
        }
    }

    @Override
    public List<T> getAll() {
        Query query;
        String queryS;
        queryS = "SELECT obj FROM " + persistentClass.getSimpleName() + " obj";
        query = getEntityManager().createQuery(queryS);
        return query.getResultList();
    }
    
    @Override
    public List pesq(String query, String ordenacao) {
        try {
            if (entityManager.isOpen()) {
                return getEntityManager().createQuery(query + " " + ordenacao).getResultList();
            } else {
                return null;
            }
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    @Override
    public List<T> getByField(String campo, String texto) {
        List lista;
        lista = getEntityManager().createQuery("SELECT p FROM " + persistentClass.getSimpleName()
                + " p  WHERE p." + campo + " LIKE '" + texto + "%' ORDER BY p.id DESC").getResultList();
        return lista;
    }
    
    public void excluirTodos (String sql){
        Query q = entityManager.createQuery("delete from" + persistentClass.getSimpleName() + " " + sql);
        q.executeUpdate();
    }

}
