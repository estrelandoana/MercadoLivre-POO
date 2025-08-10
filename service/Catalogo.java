package service;

import model.Filme;
import model.Ator;
import model.Diretor;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {

    private List<Filme> filmes = new ArrayList<>();
    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();

    public void cadastrarAtor(Ator ator) {
        atores.add(ator);
    }

    public void cadastrarDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public void cadastrarFilme(Filme filme) {
        filmes.add(filme);
    }

    public boolean associarAtorFilme(String nomeFilme, String nomeAtor) {
        Filme filme = buscarFilmePorNome(nomeFilme);
        Ator ator = buscarAtorPorNome(nomeAtor);
        if (filme != null && ator != null) {
            filme.adicionarAtor(ator);
            return true;
        }
        return false;
    }

    public boolean associarDiretorFilme(String nomeFilme, String nomeDiretor) {
        Filme filme = buscarFilmePorNome(nomeFilme);
        Diretor diretor = buscarDiretorPorNome(nomeDiretor);
        if (filme != null && diretor != null) {
            filme.setDiretor(diretor);
            return true;
        }
        return false;
    }

    public Filme buscarFilmePorNome(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                return filme;
            }
        }
        return null;
    }

    public Ator buscarAtorPorNome(String nome) {
        for (Ator ator : atores) {
            if (ator.getNome().equalsIgnoreCase(nome)) {
                return ator;
            }
        }
        return null;
    }

    public Diretor buscarDiretorPorNome(String nome) {
        for (Diretor diretor : diretores) {
            if (diretor.getNome().equalsIgnoreCase(nome)) {
                return diretor;
            }
        }
        return null;
    }

    public List<Filme> listarFilmes() {
        return filmes;
    }

    public List<Ator> listarAtores() {
        return atores;
    }

    public List<Diretor> listarDiretores() {
        return diretores;
    }
}
