package com.skateflow.Skateflow.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Evento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_evento", nullable = false)
    private String nomeEvento;

    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;

    @Column(name = "local_evento", nullable = false)
    private String localEvento;

    @Column(name = "descricao", nullable = false)
    private String descricao;


    @Column(name = "imagem_evento")
    private String imagemEvento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public String getDescricao() {       return descricao;    }

    public void setDescricao(String descricao) {        this.descricao = descricao;    }

    public String getImagemEvento() {
        return imagemEvento;
    }

    public void setImagemEvento(String imagemEvento) {
        this.imagemEvento = imagemEvento;
    }
}
