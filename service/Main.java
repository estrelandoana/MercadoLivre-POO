package service;

import model.Ator;
import model.Diretor;
import model.Filme;
import service.Catalogo;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        Ator ator1 = new Ator("Maria Silva", "1980-05-10", 15, "DRT12345");
        Ator ator2 = new Ator("João Souza", "1975-08-20", 20, "DRT67890");

        Diretor diretor1 = new Diretor("Carlos Lima", "1960-11-02", 10, "CredencialXYZ");

        catalogo.cadastrarAtor(ator1);
        catalogo.cadastrarAtor(ator2);
        catalogo.cadastrarDiretor(diretor1);

        Filme filme1 = new Filme("O Grande Filme", "2023-04-15", 5000000, "Um filme emocionante.", diretor1);
        catalogo.cadastrarFilme(filme1);

        catalogo.associarAtorFilme("O Grande Filme", "Maria Silva");
        catalogo.associarAtorFilme("O Grande Filme", "João Souza");

        Filme filmeBuscado = catalogo.buscarFilmePorNome("o grande filme");
        if (filmeBuscado != null) {
            System.out.println(filmeBuscado.mostrarInfo());
        } else {
            System.out.println("Filme não encontrado.");
        }
    }
}
