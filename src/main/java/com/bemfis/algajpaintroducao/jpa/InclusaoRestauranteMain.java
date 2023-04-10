package com.bemfis.algajpaintroducao.jpa;

import com.bemfis.algajpaintroducao.AlgaJpaIntroducaoApplication;
import com.bemfis.algajpaintroducao.domain.model.Restaurante;
import com.bemfis.algajpaintroducao.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class InclusaoRestauranteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaJpaIntroducaoApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("LaisBem");
        restaurante1.setTaxaFrete(new BigDecimal(12.50));

        restaurantes.adicionar(restaurante1);

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNome("BemGuedes");
        restaurante2.setTaxaFrete(new BigDecimal(22.50));

        restaurantes.adicionar(restaurante2);
    }
}
