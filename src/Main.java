import model.Filme;
import model.Diretor;
import model.Ator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Filme> catalogo = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 - Adicionar filme");
            System.out.println("2 - Remover filme");
            System.out.println("3 - Listar filmes");
            System.out.println("4 - Editar filme");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }

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

                    System.out.println("Dados do diretor:");
                    System.out.print("Nome: ");
                    String nomeDir = scanner.nextLine();
                    System.out.print("Data de nascimento: ");
                    String dataDir = scanner.nextLine();
                    System.out.print("Quantidade de filmes dirigidos: ");
                    int qtdDir = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Credencial: ");
                    String credencialDir = scanner.nextLine();

                    Diretor diretor = new Diretor(nomeDir, dataDir, qtdDir, credencialDir);

                    Filme filme = new Filme(titulo, dataLancamento, orcamento, descricao, diretor);

                    System.out.println("Dados do ator:");
                    System.out.print("Nome do ator: ");
                    String nomeAtor = scanner.nextLine();
                    System.out.print("Data de nascimento do ator: ");
                    String dataAtor = scanner.nextLine();
                    System.out.print("Quantidade de filmes do ator: ");
                    int qtdAtor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("DRT do ator: ");
                    String drtAtor = scanner.nextLine();

                    Ator primeiroAtor = new Ator(nomeAtor, dataAtor, qtdAtor, drtAtor);
                    filme.adicionarAtor(primeiroAtor);

                    while (true) {
                        System.out.print("Deseja adicionar mais atores? (s/n): ");
                        String resp = scanner.nextLine();
                        if (!resp.equalsIgnoreCase("s")) {
                            break;
                        }
                        System.out.print("Nome do ator: ");
                        nomeAtor = scanner.nextLine();
                        System.out.print("Data de nascimento do ator: ");
                        dataAtor = scanner.nextLine();
                        System.out.print("Quantidade de filmes do ator: ");
                        qtdAtor = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("DRT do ator: ");
                        drtAtor = scanner.nextLine();

                        Ator ator = new Ator(nomeAtor, dataAtor, qtdAtor, drtAtor);
                        filme.adicionarAtor(ator);
                    }

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
                            System.out.println("---------------------");
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

                    if (filmeEditar == null) {
                        System.out.println("Filme não encontrado.");
                        break;
                    }

                    System.out.println("Novo título (Enter para manter): ");
                    String novoTitulo = scanner.nextLine();
                    if (!novoTitulo.trim().isEmpty()) {
                        filmeEditar.setTitulo(novoTitulo);
                    }

                    System.out.println("Nova data de lançamento (Enter para manter): ");
                    String novaData = scanner.nextLine();
                    if (!novaData.trim().isEmpty()) {
                        filmeEditar.setDataLancamento(novaData);
                    }

                    System.out.println("Novo orçamento (Enter para manter): ");
                    String novoOrcamentoStr = scanner.nextLine();
                    if (!novoOrcamentoStr.trim().isEmpty()) {
                        try {
                            double novoOrcamento = Double.parseDouble(novoOrcamentoStr);
                            filmeEditar.setOrcamento(novoOrcamento);
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido, orçamento não alterado.");
                        }
                    }

                    System.out.println("Nova descrição (Enter para manter): ");
                    String novaDescricao = scanner.nextLine();
                    if (!novaDescricao.trim().isEmpty()) {
                        filmeEditar.setDescricao(novaDescricao);
                    }

                    // Editar diretor
                    Diretor dir = filmeEditar.getDiretor();
                    System.out.println("Editar dados do diretor:");

                    System.out.println("Nome do diretor (Enter para manter): ");
                    String novoNomeDir = scanner.nextLine();
                    if (!novoNomeDir.trim().isEmpty()) {
                        dir.setNome(novoNomeDir);
                    }

                    System.out.println("Data de nascimento do diretor (Enter para manter): ");
                    String novaDataDir = scanner.nextLine();
                    if (!novaDataDir.trim().isEmpty()) {
                        dir.setDataNascimento(novaDataDir);
                    }

                    System.out.println("Quantidade de filmes dirigidos (Enter para manter): ");
                    String novaQtdDirStr = scanner.nextLine();
                    if (!novaQtdDirStr.trim().isEmpty()) {
                        try {
                            int novaQtdDir = Integer.parseInt(novaQtdDirStr);
                            dir.setQuantidadeFilmesDirigidos(novaQtdDir);
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido, quantidade não alterada.");
                        }
                    }

                    System.out.println("Credencial do diretor (Enter para manter): ");
                    String novaCredDir = scanner.nextLine();
                    if (!novaCredDir.trim().isEmpty()) {
                        dir.setCredencial(novaCredDir);
                    }

                    System.out.println("Editando atores:");
                    List<Ator> atores = filmeEditar.getAtores();
                    for (int i = 0; i < atores.size(); i++) {
                        Ator ator = atores.get(i);
                        System.out.println("Ator #" + (i + 1));

                        System.out.print("Nome do ator (Enter para manter) [" + ator.getNome() + "]: ");
                        String nomeAtorEdit = scanner.nextLine();
                        if (!nomeAtorEdit.trim().isEmpty()) {
                            ator.setNome(nomeAtorEdit);
                        }

                        System.out.print("Data de nascimento do ator (Enter para manter) [" + ator.getDataNascimento() + "]: ");
                        String dataAtorEdit = scanner.nextLine();
                        if (!dataAtorEdit.trim().isEmpty()) {
                            ator.setDataNascimento(dataAtorEdit);
                        }

                        System.out.print("Quantidade de filmes do ator (Enter para manter) [" + ator.getQuantidadeFilmes() + "]: ");
                        String qtdAtorEditStr = scanner.nextLine();
                        if (!qtdAtorEditStr.trim().isEmpty()) {
                            try {
                                int qtdAtorEdit = Integer.parseInt(qtdAtorEditStr);
                                ator.setQuantidadeFilmes(qtdAtorEdit);
                            } catch (NumberFormatException e) {
                                System.out.println("Valor inválido, quantidade não alterada.");
                            }
                        }

                        System.out.print("DRT do ator (Enter para manter) [" + ator.getDrt() + "]: ");
                        String drtAtorEdit = scanner.nextLine();
                        if (!drtAtorEdit.trim().isEmpty()) {
                            ator.setDrt(drtAtorEdit);
                        }
                    }

                    while (true) {
                        System.out.print("Deseja adicionar mais atores? (s/n): ");
                        String resposta = scanner.nextLine();
                        if (!resposta.equalsIgnoreCase("s")) {
                            break;
                        }
                        System.out.print("Nome do ator: ");
                        String nomeNovoAtor = scanner.nextLine();
                        System.out.print("Data de nascimento do ator: ");
                        String dataNovoAtor = scanner.nextLine();
                        System.out.print("Quantidade de filmes do ator: ");
                        int qtdNovoAtor = 0;
                        try {
                            qtdNovoAtor = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido, atribuído 0.");
                        }
                        System.out.print("DRT do ator: ");
                        String drtNovoAtor = scanner.nextLine();

                        Ator novoAtor = new Ator(nomeNovoAtor, dataNovoAtor, qtdNovoAtor, drtNovoAtor);
                        filmeEditar.adicionarAtor(novoAtor);
                    }

                    System.out.println("Filme editado com sucesso!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }
}

//javac -d bin $(find src -name "*.java")
//java -cp bin Main