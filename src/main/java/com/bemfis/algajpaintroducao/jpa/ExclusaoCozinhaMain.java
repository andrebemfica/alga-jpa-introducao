package com.bemfis.algajpaintroducao.jpa;

import com.bemfis.algajpaintroducao.AlgaJpaIntroducaoApplication;
import com.bemfis.algajpaintroducao.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ExclusaoCozinhaMain {
    public static void main(String[] args) {
        //instanciando um construtor (builder) de springApplication, para informar, com alguns parâmetros,
        //que a nossa aplicação não é web.
        //passa a classe AlgaJpaIntroducaoApplication pois é a fonte primaria de configurações da nossa aplicação.
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgaJpaIntroducaoApplication.class)
                .web(WebApplicationType.NONE) //afirma que não é aplicação web.
                .run(args); //argumentos do método main.

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        Cozinha cozinha = new Cozinha();
        cozinha.setId(1L);

        cadastroCozinha.remover(cozinha);

    }
}
