package com.bemfis.algajpaintroducao.jpa;

import com.bemfis.algajpaintroducao.domain.model.Cozinha;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext //injeta EntityManager
    private EntityManager manager;
    //gerencia o contexto de persistencia, intermediação dos comandos em tradução para sql.
    //com esse EntityManager podemos salvar um objeto no banco, fazer consultas, etc.

    public List<Cozinha> listar(){
        //createQuery cria uma consulta, tem como argumento uma String (consulta JPQL) e o tipo do retorno da consulta.
        //createQuery retorna uma consulta tipada de cozinha (TypedQuery).
        //getResultList retorna uma lista de cozinha.
        return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

    public Cozinha buscar (Long id){
        //faz um select from Cozinha where id é igual ao id recebido.
        return manager.find(Cozinha.class, id);
    }

    //quando fazemos uma modificação no nosso banco de dados precisamos de uma transação
    @Transactional //esse método será executado dentro de uma transação
    public Cozinha adicionar(Cozinha cozinha){
        return manager.merge(cozinha);
    }

}
