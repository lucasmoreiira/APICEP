package com.example.apicep.service;

import com.example.apicep.dto.CEP;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CepService {

    public CEP getCEP(String cep){

        try {
            String URI = "https://viacep.com.br/ws/" + cep + "/json/";
            String URL = "/api";

            CEP response = WebClient
                    .create(URL)
                    .get()
                    .uri(URI, cep)
                    .retrieve()
                    .bodyToMono(CEP.class).block();

            return response;
        } catch (Exception e) {
            throw new IllegalArgumentException("data not found with the provided cep");
        }
    }
}
