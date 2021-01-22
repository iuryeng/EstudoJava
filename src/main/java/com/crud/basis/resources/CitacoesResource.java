package com.crud.basis.resources;


import com.crud.basis.dominio.Citacao;

import com.crud.basis.service.CitacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CitacoesResource {

    @Autowired
    private CitacaoService citacaoService;

    @GetMapping("/citacoes")
    public ResponseEntity<List<Citacao>> getAllCitacoes() {
        return ResponseEntity.status(HttpStatus.OK).body(citacaoService.getAllCitacao());
    }

    @GetMapping("/citacoes/{id}")
    public ResponseEntity<Citacao> getCitacaoById(@PathVariable long id) {
       return ResponseEntity.status(HttpStatus.OK).body(citacaoService.getCitacaoById(id));
    }

    @PostMapping("/citacoes")
    public ResponseEntity<Citacao> createCitacao(@RequestBody Citacao citacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.citacaoService.createCitacao((citacao)));
    }

    @PutMapping("/citacoes/{id}")
    public ResponseEntity<Citacao> updateCitacao(@PathVariable long id, @RequestBody Citacao citacao) {
        citacao.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(this.citacaoService.updateCitacao(citacao));
    }

    @DeleteMapping("/citacoes/{id}")
    public HttpStatus deleteCitacao(@PathVariable long id ) {
        this.citacaoService.deleteCitacao(id);
        return HttpStatus.OK;
    }

}
