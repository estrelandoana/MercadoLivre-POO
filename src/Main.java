import model.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Filme> catalogo = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n1 - Adicionar filme");
            System.out.println("2 - Remover filme");
            System.out.println("3 - Listar filmes");
            System.out.println("4 - Editar filme");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Data de lançamento: ");
                    String dataLancamento = scanner.nextLine();

                    System.out.print("Orçamento: ");
                    double orcamento = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();

                    Filme filme = new Filme(titulo, dataLancamento, orcamento, descricao, null);
                    catalogo.add(filme);

                    System.out.println("Filme adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Título do filme para remover: ");
                    String tituloRemover = scanner.nextLine();
                    boolean removido = catalogo.removeIf(f -> f.getTitulo().equalsIgnoreCase(tituloRemover));
                    if (removido) {
                        System.out.println("Filme removido com sucesso!");
                    } else {
                        System.out.println("Filme não encontrado.");
                    }
                    break;

                case 3:
                    if (catalogo.isEmpty()) {
                        System.out.println("Nenhum filme cadastrado.");
                    } else {
                        System.out.println("--- Lista de Filmes ---");
                        for (Filme f : catalogo) {
                            System.out.println(f.mostrarInfo());
                        }
                    }
                    break;

                case 4:
                    System.out.print("Título do filme para editar: ");
                    String tituloEditar = scanner.nextLine();
                    Filme filmeEditar = null;
                    for (Filme f : catalogo) {
                        if (f.getTitulo().equalsIgnoreCase(tituloEditar)) {
                            filmeEditar = f;
                            break;
                        }
                    }

                    if (filmeEditar != null) {
                        System.out.print("Novo título: ");
                        String novoTitulo = scanner.nextLine();
                        filmeEditar.setTitulo(novoTitulo);

                        System.out.print("Nova data de lançamento: ");
                        String novaData = scanner.nextLine();
                        filmeEditar.setDataLancamento(novaData);

                        System.out.print("Novo orçamento: ");
                        double novoOrcamento = scanner.nextDouble();
                        scanner.nextLine();

                        filmeEditar.setOrcamento(novoOrcamento);

                        System.out.print("Nova descrição: ");
                        String novaDescricao = scanner.nextLine();
                        filmeEditar.setDescricao(novaDescricao);

                        System.out.println("Filme atualizado com sucesso!");
                    } else {
                        System.out.println("Filme não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
