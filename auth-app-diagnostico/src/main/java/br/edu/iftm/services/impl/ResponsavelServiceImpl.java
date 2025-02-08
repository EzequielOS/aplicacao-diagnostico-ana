package br.edu.iftm.services.impl;

import br.edu.iftm.models.Responsavel;
import br.edu.iftm.repositories.ResponsavelRepository;
import br.edu.iftm.services.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResponsavelServiceImpl implements ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Override
    public Responsavel save(Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    @Override
    public Responsavel findById(String id) {
        return responsavelRepository.findById(id).orElse(null);
    }

    @Override
    public List<Responsavel> findAll() {
        return responsavelRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        responsavelRepository.deleteById(id);
    }
}