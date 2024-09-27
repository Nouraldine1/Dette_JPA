package com.ism.repositories;

import java.util.List;

public interface Repository<T> {
    void insert(T entity);
    List<T> selectAll();
    T selectById(String id);
}
