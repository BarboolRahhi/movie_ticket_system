package com.cg.movieticketsystem.controller;

import com.cg.movieticketsystem.MovieTicketSystemApplication;
import com.cg.movieticketsystem.Service.AuthService;
import com.cg.movieticketsystem.dto.request.SignupRequest;
import com.cg.movieticketsystem.dto.response.MessageResponse;
import com.cg.movieticketsystem.security.service.UserDetailsServiceImpl;
import com.cg.movieticketsystem.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = AuthController.class)
public class AuthControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AuthService service;
    @Test
    void signupTest() throws Exception {
        SignupRequest payload = new SignupRequest("test1", "test1@gmail.com",
                "test12345", "7899456123");
        when(service.registerUser(any()))
                .thenReturn(new MessageResponse(Constants.REGISTERED_SUCCESSFULLY));
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/auth/signup")
                .content(asJsonString(payload))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.message")
                        .value(Constants.REGISTERED_SUCCESSFULLY)
                );

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
