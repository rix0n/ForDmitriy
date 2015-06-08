package DAO;

import DAO.Entity.ABaseEntity;

import java.util.List;

/**
 * Created by 1 on 04.06.2015.
 */
public interface BaseGenericDAO<T extends ABaseEntity> {

    public T getByPK(int key);

    public T persist(T entity);

    public void update(T entity);

    public void delete(T entity);

    public List<T> getAll();

}
