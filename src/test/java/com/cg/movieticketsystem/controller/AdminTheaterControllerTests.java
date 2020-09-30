package com.cg.movieticketsystem.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cg.movieticketsystem.TestUtil;
import com.cg.movieticketsystem.Service.admin.AdminTheaterService;
import com.cg.movieticketsystem.entity.Theater;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.util.Constants;

@SpringBootTest
public class AdminTheaterControllerTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private AdminTheaterService service;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void add_theater_test() throws Exception {
        Theater request = new Theater(
                "Viva",
                "jalandhar",
                "Vikaram Pal",
                "9632146463"
        );
        Theater response = new Theater(
                12L,
                "Viva",
                "jalandhar",
                "Vikaram Pal",
                "9632146463"
        );
        when(service.addItem(any(Theater.class))).thenReturn(response);
        mockMvc.perform(post("/api/admin/theaters")
                .content(TestUtil.asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andExpect(MockMvcResultMatchers
                .jsonPath("$.theaterId")
                .value(12)
        );
    }

    @Test
    @WithMockUser(roles = "CUSTOMER")
    void add_theater_exception_test() throws Exception {

        Theater request = new Theater(
                "Viva",
                "jalandhar",
                "Vikaram Pal",
                "9632146463"
        );
        mockMvc.perform(post("/api/admin/theaters")
                .content(TestUtil.asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof AccessDeniedException));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void delete_theater_test() throws Exception {

        doNothing().when(service).deleteItem(any(Long.class));

        mockMvc.perform(delete("/api/admin/theaters/{id}", 12L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.message").value(Constants.DELETE_SUCCESSFULLY)
                );
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void delete_theater_Exception_test() throws Exception {

        doThrow(NotFoundException.class).when(service).deleteItem(any(Long.class));

        mockMvc.perform(delete("/api/admin/theaters/{id}", 10L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NotFoundException));
    }
}
