package com.danila.applications;


import com.danila.applications.controller.ApplicationsController;
import com.danila.applications.data.InputData;
import com.danila.applications.service.ApplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ApplicationsController.class)
public class TestController {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ApplicationService applicationService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testPostMapping() throws Exception {
        mvc.perform(post("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(InputData.createLoanApplication())))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMapping() throws Exception {
        mvc.perform(get("/application/{number}", 3L))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(InputData.createLoanApplication())));
    }

}
