package com.cg.movieticketsystem.controller;

import com.cg.movieticketsystem.Service.AuthService;
import com.cg.movieticketsystem.TestUtil;
import com.cg.movieticketsystem.dto.request.SignupRequest;
import com.cg.movieticketsystem.dto.response.MessageResponse;
import com.cg.movieticketsystem.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.binding.When;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
public class AuthControllerTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private AuthService service;

    @Test
    public void signup_test() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();

        when(service.registerUser(any(SignupRequest.class)))
                .thenReturn(new MessageResponse(Constants.REGISTERED_SUCCESSFULLY));

        SignupRequest payload = new SignupRequest("test1", "test1@gmail.com",
                "test12345", "7899456123");

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/auth/signup")
                .content(TestUtil.asJsonString(payload))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.message")
                        .value(Constants.REGISTERED_SUCCESSFULLY)
                );
    }

}
