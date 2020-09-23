package com.cg.movieticketsystem.controller.admin;

import com.cg.movieticketsystem.Service.admin.AdminScreenService;
import com.cg.movieticketsystem.dto.response.MessageResponse;
import com.cg.movieticketsystem.entity.Screen;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/screen")
public class AdminScreenController implements BaseAdminController<Screen, Long> {

    @Autowired
    private AdminScreenService screenService;

    @Override
    public ResponseEntity<?> addItem(Screen model) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(screenService.addItem(model));
    }

    @Override
    public ResponseEntity<?> updateItem(Long id, Screen model) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(screenService.updateItem(id, model));
    }

    @Override
    public ResponseEntity<?> deleteItem(Long id) throws NotFoundException {
        screenService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageResponse(Constants.DELETE_SUCCESSFULLY));
    }
}
