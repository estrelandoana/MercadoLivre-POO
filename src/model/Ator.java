package model;

public class Ator extends Pessoa {
    private int quantidadeFilmes;
    private String drt;

    public Ator(String nome, String dataNascimento, int quantidadeFilmes, String drt) {
        super(nome, dataNascimento);
        this.quantidadeFilmes = quantidadeFilmes;
        this.drt = drt;
    }
    
    public int getQuantidadeFilmes() {
        return quantidadeFilmes;
    }

    public void setQuantidadeFilmes(int quantidadeFilmes) {
        this.quantidadeFilmes = quantidadeFilmes;
    }

    public String getDrt() {
        return drt;
    }

    public void setDrt(String drt) {
        this.drt = drt;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() +
            "Quantidade de Filmes: " + quantidadeFilmes + "\n" +
            "DRT: " + drt + "\n";
    }
}
