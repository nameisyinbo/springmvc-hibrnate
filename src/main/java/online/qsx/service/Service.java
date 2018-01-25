package online.qsx.service;

import java.util.List;

public interface Service<T> {
    List<T> findAll();
    void save(T t);
    void edit(T t);
    void remove(T t);
    List<T> pageAll(int pageSize, int pageNo);
    int totalCount();
}
