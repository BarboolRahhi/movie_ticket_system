package com.cg.movieticketsystem.Service.admin;

import com.cg.movieticketsystem.entity.Show;
import com.cg.movieticketsystem.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminShowServiceImpl implements BaseAdminService<Show, Long> {

    @Override
    public Show addItem(Show model) {
        return null;
    }

    @Override
    public Show updateItem(Long id, Show model) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteItem(Long id) throws NotFoundException {

    }

}
