package com.desafiomvc.services;

import com.desafiomvc.entities.UnidadeDeMedida;
import com.desafiomvc.repositories.UnidadeDeMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeDeMedidaService {

    @Autowired
    public UnidadeDeMedidaRepository unidadeDeMedidaRepository;

    public UnidadeDeMedida salvarUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {

        return unidadeDeMedidaRepository.save(unidadeDeMedida);
    }
    public List<UnidadeDeMedida> listarUnidadeDeMedida(){

        return unidadeDeMedidaRepository.findAll();
    }
    public UnidadeDeMedida obterUnidadeDeMedida(Long id) throws Exception {

        Optional<UnidadeDeMedida> unidadeDeMedida = unidadeDeMedidaRepository.findById(id);

        if(unidadeDeMedida.isEmpty()) {
            throw new Exception("Unidade de medida não encontrada.");
        }

        return unidadeDeMedida.get();
    }
    public void excluirUnidadeDeMedida(Long id) {

        unidadeDeMedidaRepository.deleteById(id);
    }
}
