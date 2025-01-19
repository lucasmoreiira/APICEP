package com.example.apicep.controller;


import com.example.apicep.dto.CEP;
import com.example.apicep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private CepService service;


    @GetMapping("/{cep}")
    public ResponseEntity getCEP(@PathVariable String cep){

        CEP response = service.getCEP(cep);

        return ResponseEntity.ok(response);
    }
}
