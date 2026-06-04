package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {

    private static long contadorId = 1;

    private final long id;
    private String nome;
    private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudosConcluidos = new HashSet<>();

    public Dev(String nome) {
        this.id = contadorId++;
        this.nome = nome;
    }

    public void adicionarConteudos(Set<Conteudo> conteudos){
        for (Conteudo conteudo : conteudos) {
            if (conteudosConcluidos.contains(conteudo)) continue;

            conteudosInscritos.add(conteudo);
        }
    }

    public void progredir() {
        conteudosInscritos.stream()
                .findFirst()
                .ifPresentOrElse(
                        this::concluirConteudo,
                        () -> System.err.println("Você não está matriculado em nenhum conteúdo!")
                );
    }

    private void concluirConteudo(Conteudo conteudo){
        conteudosConcluidos.add(conteudo);
        conteudosInscritos.remove(conteudo);
    }

    public double calcularTotalXp() {
        double soma = 0;

        for (Conteudo conteudo : conteudosConcluidos) soma += conteudo.calcularXp();

        return soma;
    }

    public long getId() { return id; }
    public String getNome() { return nome; }
    public Set<Conteudo> getConteudosInscritos() { return Collections.unmodifiableSet(conteudosInscritos); }
    public Set<Conteudo> getConteudosConcluidos() { return Collections.unmodifiableSet(conteudosConcluidos); }

    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() {
        return "Dev{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", conteudosInscritos=" + conteudosInscritos +
                ", conteudosConcluidos=" + conteudosConcluidos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dev dev)) return false;
        return id == dev.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
