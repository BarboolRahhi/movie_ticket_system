package com.cg.movieticketsystem.controller.admin;

import com.cg.movieticketsystem.Service.admin.AdminTheaterService;
import com.cg.movieticketsystem.dto.response.MessageResponse;
import com.cg.movieticketsystem.entity.Theater;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AdminTheaterController implements BaseAdminController
 * Where all rest methods are defined.
 */
@RestController
@RequestMapping("/api/admin/theater")
public class AdminTheaterController implements BaseAdminController<Theater, Long>{

    @Autowired
    AdminTheaterService adminTheaterService;

    @Override
    public ResponseEntity<?> addItem(Theater model) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(adminTheaterService.addItem(model));
    }

    @Override
    public ResponseEntity<?> updateItem(Long id, Theater model) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(adminTheaterService.updateItem(id, model));
    }

    @Override
    public ResponseEntity<?> deleteItem(Long id) throws NotFoundException {
        adminTheaterService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageResponse(Constants.DELETE_SUCCESSFULLY));
    }
}
