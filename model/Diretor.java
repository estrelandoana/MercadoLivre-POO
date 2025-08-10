package model;

public class Diretor extends Pessoa {
    private int quantidadeFilmesDirigidos;
    private String credencial;

    public Diretor(String nome, String dataNascimento, int quantidadeFilmesDirigidos, String credencial) {
        super(nome, dataNascimento);
        this.quantidadeFilmesDirigidos = quantidadeFilmesDirigidos;
        this.credencial = credencial;
    }

    public int getQuantidadeFilmesDirigidos() {
        return quantidadeFilmesDirigidos;
    }

    public void setQuantidadeFilmesDirigidos(int quantidadeFilmesDirigidos) {
        this.quantidadeFilmesDirigidos = quantidadeFilmesDirigidos;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() +
            "Quantidade de Filmes Dirigidos: " +quantidadeFilmesDirigidos + "\n" +
            "Credencial: " + credencial + "\n";
    }
}
