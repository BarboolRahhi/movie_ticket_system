package com.cg.movieticketsystem.Service.admin;

import com.cg.movieticketsystem.exception.NotFoundException;


public interface BaseAdminService<T, V> {
    T addItem(T model);
    T updateItem(V id, T model) throws NotFoundException;
    void deleteItem(V id) throws NotFoundException;
}
