package com.cg.movieticketsystem.Service.admin;

import com.cg.movieticketsystem.exception.NotFoundException;

/**
 * @param <T> it represent Entity class or model
 * @param <V> it represent id  or primary key of class
 */
public interface BaseAdminService<T, V> {
    T addItem(T model);
    T updateItem(V id, T model) throws NotFoundException;
    void deleteItem(V id) throws NotFoundException;
}
