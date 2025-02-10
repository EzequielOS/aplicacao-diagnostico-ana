package br.edu.iftm.services.impl;

import br.edu.iftm.models.Resposta;
import br.edu.iftm.repositories.RespostaRepository;
import br.edu.iftm.services.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaServiceImpl implements RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Override
    public List<Resposta> findAll() {
        return respostaRepository.findAll();
    }

    @Override
    public Resposta findById(String id) {
        return respostaRepository.findById(id).orElse(null);
    }

    @Override
    public Resposta save(Resposta resposta) {
        return respostaRepository.save(resposta);
    }

    @Override
    public void deleteById(String id) {
        respostaRepository.deleteById(id);
    }
}