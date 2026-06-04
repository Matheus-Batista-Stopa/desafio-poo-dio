package br.com.dio.desafio.dominio;

import java.time.OffsetDateTime;
import java.util.*;

public class Bootcamp {

    protected static final int DURACAO_PADRAO = 45;
    private static long contadorId = 1;

    private final long id;
    private String nome;
    private String descricao;
    private final OffsetDateTime dataInicial = OffsetDateTime.now();
    private final OffsetDateTime dataFinal;
    private final Set<Conteudo> conteudos = new LinkedHashSet<>();
    private final Set<Dev> devsInscritos = new HashSet<>();

    public Bootcamp(String nome, String descricao) {
        this.id = contadorId++;
        this.nome = nome;
        this.descricao = descricao;
        this.dataFinal = dataInicial.plusDays(DURACAO_PADRAO);
    }

    public Bootcamp(String nome, String descricao, int duracao) {
        this.id = contadorId++;
        this.nome = nome;
        this.descricao = descricao;
        this.dataFinal = dataInicial.plusDays(duracao);
    }

    public void inscreverDev(Dev dev){ if (devsInscritos.add(dev)) dev.adicionarConteudos(conteudos); }

    public void adicionarConteudo(Conteudo conteudo){ conteudos.add(conteudo); }

    public long getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public OffsetDateTime getDataInicial() { return dataInicial; }
    public OffsetDateTime getDataFinal() { return dataFinal; }
    public Set<Conteudo> getConteudos() { return Collections.unmodifiableSet(conteudos); }
    public Set<Dev> getDevsInscritos() { return Collections.unmodifiableSet(devsInscritos); }

    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bootcamp bootcamp)) return false;
        return id == bootcamp.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
