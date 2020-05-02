package com.customerContext.api;


import com.customerContext.CustomerContextApplication;
import com.customerContext.application.dtos.CreateCustomerRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
@ExtendWith(SpringExtension.class)
@WebAppConfiguration()
@ContextConfiguration(classes = {CustomerContextApplication.class})
public class CustomerControllerTests   {

    @Autowired
    private WebApplicationContext wac;

    private static MockMvc mockMvc;

    public CustomerControllerTests(){

    }

    @BeforeEach
    void setup() {
        if(mockMvc ==null){
            this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
            log.warn("spring started!!!");
        }
    }

    @Test
    public void should_be_ok_when_post() throws Exception {
        CreateCustomerRequestDto reqDto = new CreateCustomerRequestDto(20, "qweqwe@gmail.com", 800);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(reqDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customers/")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andReturn();

        int status = result.getResponse().getStatus();

        assertThat(status).isEqualTo(HttpStatus.SC_OK);

    }

    @ParameterizedTest
    @ValueSource(strings = {"/api/v1/customers/", "/api/v1/customers/2"})
    public void should_be_ok_when_get(String url) throws Exception {
        CreateCustomerRequestDto reqDto = new CreateCustomerRequestDto(20, "qweqwe@gmail.com", 800);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(reqDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andReturn();

        int status = result.getResponse().getStatus();

        assertThat(status).isEqualTo(HttpStatus.SC_OK);

    }
}
