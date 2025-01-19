package com.example.apicep.controller;

import com.example.apicep.dto.CEP;
import com.example.apicep.service.CepService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class CepControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CepService cepService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getCEPSucess() throws Exception{

        String cep= "01001000";

        CEP mockResponse = new CEP();
        mockResponse.setCep("01001-000");
        mockResponse.setLogradouro("Praça da Sé");
        mockResponse.setComplemento("lado ímpar");
        mockResponse.setBairro("Sé");
        mockResponse.setLocalidade("São Paulo");
        mockResponse.setUf("SP");



        Mockito.when(cepService.getCEP(cep)).thenReturn(mockResponse);

                String expectedResponse = """
                {
                "cep": "01001-000",
                "logradouro": "Praça da Sé",
                "complemento": "lado ímpar",
                "bairro": "Sé",
                "localidade": "São Paulo",
                "uf": "SP"
            }""";


        mockMvc.perform(get("/cep/{cep}", cep))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));
    }


    @Test
    void getCEPFailure() throws Exception {

        String cep = "";

        mockMvc.perform(get("/cep/{cep}", cep))
                .andExpect(status().isNotFound());
    }
}