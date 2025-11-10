package dao;

import java.util.List;

public interface IDao<T> {
    boolean save(T o);
    T findById(int id);
    List<T> findAll();
}
