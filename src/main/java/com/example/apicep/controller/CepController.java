package com.example.apicep.controller;


import com.example.apicep.dto.CEP;
import com.example.apicep.exception.ExceptionDTO;
import com.example.apicep.service.CepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cep", produces = {"application/json"})
@Tag(name = "open-api")

public class CepController {

    @Autowired
    private CepService service;

    @Operation(summary = "Receive the data from a given cep", method = "GET")
    @GetMapping("/{cep}")
    public ResponseEntity getCEP(@PathVariable String cep){

        CEP response = service.getCEP(cep);

        return ResponseEntity.ok(response);
    }
}
