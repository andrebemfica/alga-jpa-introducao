package com.bemfis.algajpaintroducao.domain.repository;

import com.bemfis.algajpaintroducao.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> todas();
    Cozinha porId(Long id);
    Cozinha adicionar(Cozinha cozinha);
    void remover(Cozinha cozinha);
}
