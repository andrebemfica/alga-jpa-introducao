package com.bemfis.algajpaintroducao.jpa;

import com.bemfis.algajpaintroducao.AlgaJpaIntroducaoApplication;
import com.bemfis.algajpaintroducao.domain.model.Restaurante;
import com.bemfis.algajpaintroducao.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ExclusaoRestauranteMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaJpaIntroducaoApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);

        Restaurante restaurante = new Restaurante();
        restaurante.setId(1L);

        restaurantes.remover(restaurante);
    }
}
