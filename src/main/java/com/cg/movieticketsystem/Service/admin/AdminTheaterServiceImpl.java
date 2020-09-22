package com.cg.movieticketsystem.Service.admin;

import com.cg.movieticketsystem.entity.Theater;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.repository.TheaterRepository;
import com.cg.movieticketsystem.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdminTheaterServiceImpl implements BaseAdminService<Theater, Long> {

    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public Theater addItem(Theater model) {
        return theaterRepository.save(model);
    }

    @Override
    public Theater updateItem(Long id, Theater model) throws NotFoundException {
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.NOT_FOUND));

        theater.setTheaterName(model.getTheaterName());
        theater.setTheaterCity(model.getTheaterCity());
        theater.setManagerName(model.getManagerName());
        theater.setManagerContact(model.getManagerContact());
        return theaterRepository.save(theater);
    }

    @Override
    public void deleteItem(Long id) throws NotFoundException {
        theaterRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.NOT_FOUND));
        theaterRepository.deleteById(id);
    }

}
