package br.com.dio.desafio.dominio;

import java.util.Objects;

public sealed abstract class Conteudo permits Curso, Mentoria {

    protected static final double XP_PADRAO = 10;
    private static long contadorId = 1;

    private final long id;
    private String titulo;
    private String descricao;

    public Conteudo(String titulo, String descricao) {
        this.id = contadorId++;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public abstract double calcularXp();
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Conteudo conteudo)) return false;
        return id == conteudo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
