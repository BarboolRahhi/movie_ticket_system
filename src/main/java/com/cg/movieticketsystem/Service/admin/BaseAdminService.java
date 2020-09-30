package com.cg.movieticketsystem.Service.admin;

import java.util.List;

import com.cg.movieticketsystem.exception.NotFoundException;

/**
 * @param <T> it represent Entity class or model
 * @param <V> it represent id  or primary key of class
 */
public interface BaseAdminService<T, V> {
	List<T> getItems();
	T getItem(V id);
    T addItem(T model);
    T updateItem(V id, T model) throws NotFoundException;
    void deleteItem(V id) throws NotFoundException;
}
