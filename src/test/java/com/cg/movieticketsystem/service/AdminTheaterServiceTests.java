package com.cg.movieticketsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.movieticketsystem.Service.admin.AdminTheaterService;
import com.cg.movieticketsystem.Service.admin.AdminTheaterServiceImpl;
import com.cg.movieticketsystem.entity.Theater;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.repository.TheaterRepository;
import com.cg.movieticketsystem.util.Constants;

@SpringBootTest
public class AdminTheaterServiceTests {

    @Mock
    private TheaterRepository theaterRepository;

    @InjectMocks
    private AdminTheaterServiceImpl theaterService;
    
    @Test
    void add_test() {
        Theater theater = new Theater(
                "Viva",
                "jalandhar",
                "Vikaram Pal",
                "9632146463"
        );
        Theater returnValue = new Theater(
                12L,
                "Viva",
                "jalandhar",
                "Vikaram Pal",
                "9632146463"
        );
        when(theaterRepository.save(any(Theater.class))).thenReturn(returnValue);

        assertEquals(theaterService.addItem(theater).getTheaterId(), 12L);
    }
    
    
    @Test
    void get_by_id_test() {
    	Theater returnValue = new Theater(
                10L,
                "Viva",
                "jalandhar",
                "Vikaram Pal",
                "9632146463"
        );
        when(theaterRepository.findById(10L)).thenReturn(Optional.of(returnValue));
       
        assertEquals(theaterService.getItem(10L).getTheaterName(), returnValue.getTheaterName());
        verify(theaterRepository, times(1)).findById(any());
    }

    @Test
    void update_exception_test() {
        doThrow(new NotFoundException(Constants.THEATER_NOT_FOUND)).when(theaterRepository).findById(10L);
        Exception ex = assertThrows(NotFoundException.class, () -> {
            theaterService.updateItem(10L, any(Theater.class));
        });
        assertEquals(Constants.THEATER_NOT_FOUND, ex.getMessage());
        verify(theaterRepository, never()).save(any(Theater.class));
    }

    @Test
    void delete_test() {
        doNothing().when(theaterRepository).deleteById(anyLong());
        when(theaterRepository.findById(anyLong())).thenReturn(Optional.of(new Theater()));
        theaterService.deleteItem(anyLong());
        verify(theaterRepository, times(1)).deleteById(anyLong());
    }
    
    
    
}
