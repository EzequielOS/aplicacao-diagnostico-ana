package br.edu.iftm.services.impl;

import br.edu.iftm.models.Categoria;
import br.edu.iftm.repositories.CategoriaRepository;
import br.edu.iftm.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria findById(String id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        categoriaRepository.deleteById(id);
    }
}