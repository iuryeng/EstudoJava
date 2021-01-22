package com.crud.basis.dominio;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="CITACOES")
public class Citacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CITACA0", nullable = false)
    private String citacao;

    @Column(name = "AUTOR", nullable = false)
    private String autor;

}
