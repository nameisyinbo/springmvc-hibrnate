package online.qsx.dao;

import java.util.List;

public interface Dao<T> {
    List<T> findAll();
    void save(T t);
    void edit(T t);
    void remove(T t);
    List<T> pageAll(int pageSize, int pageNo);
    int totalCount();
}
