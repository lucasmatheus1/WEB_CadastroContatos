package br.edu.ifpb.iseries.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Temporada {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String qtdAssistiu;

    @ManyToOne
    private Serie serie;

    @OneToMany
    private List<Episodio> episodios;

    public Temporada(String nome, Serie serie) {
        this.nome = nome;
        this.serie = serie;
    }

    public Temporada() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    public String getQtdAssistiu() {
        return qtdAssistiu;
    }

    public void setQtdAssistiu(String qtdAssistiu) {
        this.qtdAssistiu = qtdAssistiu;
    }

    @Override
    public String toString() {
        return "Temporada{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", serie=" + serie +
                ", episodios=" + episodios +
                '}';
    }
}
