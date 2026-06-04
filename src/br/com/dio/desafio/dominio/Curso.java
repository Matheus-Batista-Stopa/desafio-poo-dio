package br.com.dio.desafio.dominio;

public final class Curso extends Conteudo {

    private double cargaHoraria;

    public Curso(String titulo, String descricao, double cargaHoraria) {
        super(titulo, descricao);
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXp() { return XP_PADRAO * cargaHoraria; }

    public double getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(double cargaHoraria) { this.cargaHoraria = cargaHoraria; }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + getId() +
                ", titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }

}
