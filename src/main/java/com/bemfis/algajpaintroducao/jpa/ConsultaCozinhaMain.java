package com.bemfis.algajpaintroducao.jpa;

import com.bemfis.algajpaintroducao.AlgaJpaIntroducaoApplication;
import com.bemfis.algajpaintroducao.domain.model.Cozinha;
import com.bemfis.algajpaintroducao.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {

    public static void main(String[] args) {
        //instanciando um construtor (builder) de springApplication, para informar, com alguns parâmetros,
        //que a nossa aplicação não é web.
        //passa a classe AlgaJpaIntroducaoApplication pois é a fonte primaria de configurações da nossa aplicação.

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaJpaIntroducaoApplication.class)
                .web(WebApplicationType.NONE) //afirma que não é aplicação web.
                .run(args); //argumentos do método main.

        //gera um bean do tipo CadastroCozinha, uma instância.

        CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);

        List<Cozinha> todasCozinhas = cozinhas.todas();

        for (Cozinha cozinha : todasCozinhas) {
            System.out.println(cozinha.getNome());
        }

    }
}
