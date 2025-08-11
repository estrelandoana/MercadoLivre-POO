package model;

import java.util.ArrayList;
import java.util.List;

public class Filme {
    private String titulo;
    private String dataLancamento;
    private double orcamento;
    private String descricao;
    private Diretor diretor;
    private List<Ator> atores;

    public Filme(String titulo, String dataLancamento,double orcamento, String descricao, Diretor diretor) {
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.diretor = diretor;
        this.atores = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String nome) {
        this.titulo = titulo;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void adicionarAtor(Ator ator) {
        this.atores.add(ator);
    }

    public String mostrarInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Filme\n");
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("Data de Lançamento: ").append(dataLancamento).append("\n");
        sb.append("Orçamento: ").append(orcamento).append("\n");
        sb.append("Descrição: ").append(descricao).append("\n\n");
        sb.append("--- Diretor ---\n");
        sb.append(diretor.mostrarInfo()).append("\n");
        sb.append("--- Atores ---\n");
        for (Ator ator : atores) {
            sb.append(ator.mostrarInfo()).append("\n");
        }
        return sb.toString();
    }

}
