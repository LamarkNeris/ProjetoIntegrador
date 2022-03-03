package com.dh.Projeto.Integrador.service;

import com.dh.Projeto.Integrador.model.Cidades;
import com.dh.Projeto.Integrador.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;


    public Cidades createCidade(Cidades cidades){
        return cidadeRepository.save(cidades);
    }

    public List<Cidades> selectAllCidades(){
        return cidadeRepository.findAll();
    }

}
