package com.cg.movieticketsystem.controller.admin;

import com.cg.movieticketsystem.dto.response.MessageResponse;
import com.cg.movieticketsystem.exception.NotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @param <T> it represent Entity class or model
 * @param <V> it represent id  or primary key of class
 */
public interface BaseAdminController<T, V> {

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    T addItem(@RequestBody T model);

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    T updateItem(@PathVariable("id") V id, @RequestBody T model) throws NotFoundException;

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    MessageResponse deleteItem(@PathVariable("id") V id) throws NotFoundException;
}
