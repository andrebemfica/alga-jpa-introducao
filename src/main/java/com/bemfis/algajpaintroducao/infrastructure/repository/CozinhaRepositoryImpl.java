package com.bemfis.algajpaintroducao.infrastructure.repository;

import com.bemfis.algajpaintroducao.domain.model.Cozinha;
import com.bemfis.algajpaintroducao.domain.repository.CozinhaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CozinhaRepositoryImpl implements CozinhaRepository {
    @PersistenceContext //injeta EntityManager
    private EntityManager manager;
    //gerencia o contexto de persistencia, intermediação dos comandos em tradução para sql.
    //com esse EntityManager podemos salvar um objeto no banco, fazer consultas, etc.

    @Override
    public List<Cozinha> todas() {
        //createQuery cria uma consulta, tem como argumento uma String (consulta JPQL) e o tipo do retorno da consulta.
        //createQuery retorna uma consulta tipada de cozinha (TypedQuery).
        //getResultList retorna uma lista de cozinha.
        return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }
    @Override
    public Cozinha porId(Long id) {
        //faz um select from Cozinha where id é igual ao id recebido.
        return manager.find(Cozinha.class, id);
    }

    //quando fazemos uma modificação no nosso banco de dados precisamos de uma transação
    //método adicionar foi alterado para salvar, já que serve para adicionar e atualizar
    @Override
    @Transactional //esse método será executado dentro de uma transação
    public Cozinha adicionar(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Override
    @Transactional
    public void remover(Cozinha cozinha) {
        //we need to change from transient state to managed state for the JPA to be able to manage.
        cozinha = porId(cozinha.getId());
        manager.remove(cozinha);
    }
}
