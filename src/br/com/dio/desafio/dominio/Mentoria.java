package br.com.dio.desafio.dominio;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class Mentoria extends Conteudo{

    private OffsetDateTime data;

    public Mentoria(String titulo, String descricao, String dataString) {
        super(titulo, descricao);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDateTime localDateTime = LocalDateTime.parse(dataString, formatter);

        this.data = localDateTime.atZone(ZoneId.systemDefault()).toOffsetDateTime();
    }

    @Override
    public double calcularXp() { return XP_PADRAO + 20; }

    public OffsetDateTime getData() { return data; }
    public void setData(OffsetDateTime data) { this.data = data; }

    @Override
    public String toString() {
        return "Mentoria{" +
                "id=" + getId() +
                ", titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                '}';
    }

}
