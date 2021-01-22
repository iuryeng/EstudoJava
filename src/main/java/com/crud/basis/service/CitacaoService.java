package com.crud.basis.service;

import com.crud.basis.dominio.Citacao;

import java.util.List;

public interface CitacaoService {
    Citacao createCitacao(Citacao citacao);

    Citacao updateCitacao(Citacao citacao);

    List<Citacao> getAllCitacao();

    Citacao getCitacaoById(long citacaoId);

    void deleteCitacao(long id);

}
