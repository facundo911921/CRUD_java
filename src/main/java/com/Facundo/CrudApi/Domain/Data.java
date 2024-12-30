package com.Facundo.CrudApi.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Entidade permite que criemos uma classe que represente uma tabela do banco de dados. Essa classe será uma entidade.
@Entity
@lombok.Data
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coinName;
    private String coinValue;
}
