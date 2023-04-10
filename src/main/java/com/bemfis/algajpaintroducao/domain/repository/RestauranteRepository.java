package com.bemfis.algajpaintroducao.domain.repository;

import com.bemfis.algajpaintroducao.domain.model.Cozinha;
import com.bemfis.algajpaintroducao.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {
    List<Restaurante> todos();
    Restaurante porId(Long id);
    Restaurante adicionar(Restaurante restaurante);
    void remover(Restaurante restaurante);
}
