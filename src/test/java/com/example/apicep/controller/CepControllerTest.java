package com.example.apicep.controller;

import com.example.apicep.dto.CEP;
import com.example.apicep.service.CepService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private CepService cepService;

    @Test
    void getDataWithCepSuccess() throws Exception{

        //Given
        String cep = "01001000";

        CEP response  =new CEP();
        response.setCep(cep);
        response.setLogradouro("Praça da Sé");
        response.setComplemento("lado ímpar");
        response.setBairro("Sé");
        response.setLocalidade("São Paulo");
        response.setUf("SP");

        //When
        when(cepService.getCEP(cep)).thenReturn(response);

        //Then
        CEP expected = cepService.getCEP(cep);

        //Assert
        assertEquals(response,expected);
    }

    @Test
    void getDataWithCepFailure()throws Exception{
        //Given
        String cep = "";

        CEP emptyResponse= new CEP();
        emptyResponse.setCep(cep);
        emptyResponse.setLogradouro("");
        emptyResponse.setComplemento("");
        emptyResponse.setBairro("");
        emptyResponse.setLocalidade("");
        emptyResponse.setUf("");

        //When
        when(cepService.getCEP(cep)).thenThrow(new IllegalArgumentException("data not found with the provided cep"));

        //Then
        IllegalArgumentException response = assertThrows(IllegalArgumentException.class, () -> {
          cepService.getCEP(cep);
        });

        String expected = "data not found with the provided cep";

        //Assert
        assertEquals(expected, response.getMessage());

    }

}