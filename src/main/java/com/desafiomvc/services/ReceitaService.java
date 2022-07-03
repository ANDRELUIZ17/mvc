package com.desafiomvc.services;

import com.desafiomvc.entities.Receita;
import com.desafiomvc.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita salvarReceita(Receita receita) {

        return receitaRepository.save(receita);
    }
    public List<Receita> listarReceitas(){

        return receitaRepository.findAll();
    }
    public Receita obterReceita(Long id) throws Exception{

        Optional<Receita> receita = receitaRepository.findById(id);

        if(receita.isEmpty()) {
            throw new Exception("Receita não encontrada");
        }

        return receita.get();
    }
    public void excluirReceita(Long id) {

        receitaRepository.deleteById(id);
    }
}
