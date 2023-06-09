package com.bemfis.algajpaintroducao.jpa;

import com.bemfis.algajpaintroducao.AlgaJpaIntroducaoApplication;
import com.bemfis.algajpaintroducao.domain.model.Cozinha;
import com.bemfis.algajpaintroducao.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscaCozinhaMain {
    public static void main(String[] args) {
        //instanciando um construtor (builder) de springApplication, para informar, com alguns parâmetros,
        //que a nossa aplicação não é web.
        //passa a classe AlgaJpaIntroducaoApplication pois é a fonte primaria de configurações da nossa aplicação.
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaJpaIntroducaoApplication.class)
                .web(WebApplicationType.NONE) //afirma que não é aplicação web.
                .run(args); //argumentos do método main.

        CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha = cozinhas.porId(1L);

        System.out.println(cozinha.getNome());

    }
}
