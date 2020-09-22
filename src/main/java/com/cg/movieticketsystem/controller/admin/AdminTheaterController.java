package com.cg.movieticketsystem.controller.admin;

import com.cg.movieticketsystem.Service.admin.AdminTheaterServiceImpl;
import com.cg.movieticketsystem.dto.response.MessageResponse;
import com.cg.movieticketsystem.entity.Theater;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/theater")
public class AdminTheaterController implements BaseAdminController<Theater, Long>{

    @Autowired
    AdminTheaterServiceImpl adminTheaterService;

    @Override
    public Theater addItem(Theater model) {
        return adminTheaterService.addItem(model);
    }

    @Override
    public Theater updateItem(Long id, Theater model) throws NotFoundException {
        return adminTheaterService.updateItem(id, model);
    }

    @Override
    public MessageResponse deleteItem(Long id) throws NotFoundException {
        adminTheaterService.deleteItem(id);
        return new MessageResponse(Constants.DELETE_SUCCESSFULLY);
    }
}
