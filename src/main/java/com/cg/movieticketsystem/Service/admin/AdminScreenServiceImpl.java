package com.cg.movieticketsystem.Service.admin;

import com.cg.movieticketsystem.entity.Screen;
import com.cg.movieticketsystem.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminScreenServiceImpl implements BaseAdminService<Screen, Long> {

    @Override
    public Screen addItem(Screen model) {
        return null;
    }

    @Override
    public Screen updateItem(Long id, Screen model) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteItem(Long id) throws NotFoundException {

    }


}
