package com.crud.basis.service;

import com.crud.basis.dominio.Citacao;
import com.crud.basis.exception.ResourceNotFoundException;
import com.crud.basis.repository.CitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CitacoesServiceImpl implements CitacaoService {

    @Autowired
    private CitacaoRepository citacaoRepository;


    @Override
    public Citacao createCitacao(Citacao citacao) {
        return citacaoRepository.save(citacao);
    }

    @Override
    public Citacao updateCitacao(Citacao citacao) {
        Optional<Citacao> citacaoDb = this.citacaoRepository.findById(citacao.getId());
        if(citacaoDb.isPresent()){
            Citacao citacaoUpdate = citacaoDb.get();
            citacaoUpdate.setId(citacao.getId());
            citacaoUpdate.setCitacao(citacao.getCitacao());
            citacaoUpdate.setAutor(citacao.getAutor());
            citacaoRepository.save(citacaoUpdate);
            return citacaoUpdate;

        }else{
            throw new ResourceNotFoundException("Não encontrado por id: " + citacao.getId());
        }

    }

    @Override
    public List<Citacao> getAllCitacao() {
        return this.citacaoRepository.findAll();
    }

    @Override
    public Citacao getCitacaoById(long citacaoId) {
        Optional<Citacao> citacaoDb = this.citacaoRepository.findById(citacaoId);

        if (citacaoDb.isPresent()){
            return citacaoDb.get();

        }else{
            throw new ResourceNotFoundException("Não captado por id:" + citacaoId);

        }

    }

    @Override
    public void deleteCitacao(long citacaoId) {
        Optional<Citacao> citacaoDb = this.citacaoRepository.findById(citacaoId);

        if (citacaoDb.isPresent()){
            this.citacaoRepository.delete(citacaoDb.get());

        }else{
            throw new ResourceNotFoundException("Não captado por id:" + citacaoId);

        }
    }
}
