import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuCrud {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> logOperacoes;

    public MenuCrud(List<String> logOperacoes) {
        this.logOperacoes = logOperacoes;
    }

    public void mostrarMenu(List<String> lista, String formato) {
        while (true) {
            try {
                System.out.print("\n--- Menu ---\n" +
                    "1. Cadastrar\n" +
                    "2. Listar\n" +
                    "3. Atualizar\n" +
                    "4. Remover\n" +
                    "5. Exibir Log\n" +
                    "0. Sair\n" +
                    "Escolha: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> cadastrar(lista, formato);
                    case 2 -> listar(lista);
                    case 3 -> atualizar(lista, formato);
                    case 4 -> remover(lista);
                    case 5 -> exibirLog();
                    case 0 -> {
                        System.out.println("Saindo...");
                        return;
                    }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um número inteiro.");
                scanner.nextLine();
            }
        }
    }

    private void cadastrar(List<String> lista, String formato) {
        String dados = solicitarDados(formato);
        if (validar(dados, formato)) {
            lista.add(dados);
            logOperacoes.add("Cadastrado: " + dados);
            System.out.println("Cadastrado com sucesso.");
        } else {
            System.out.println("Dados inválidos. Tente novamente.");
        }
    }

    private void listar(List<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia.");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("[" + i + "] " + lista.get(i));
            }
        }
    }

    private void atualizar(List<String> lista, String formato) {
        listar(lista);
        System.out.print("Índice para atualizar: ");
        int i = lerIndice(lista);
        if (i == -1) return;

        String novosDados = solicitarDados(formato);
        if (validar(novosDados, formato)) {
            lista.set(i, novosDados);
            logOperacoes.add("Atualizado: " + novosDados);
            System.out.println("Atualizado.");
        } else {
            System.out.println("Formato inválido. Nada foi alterado.");
        }
    }

    private void remover(List<String> lista) {
        listar(lista);
        System.out.print("Índice para remover: ");
        int i = lerIndice(lista);
        if (i != -1) {
            String registroRemovido = lista.remove(i);
            logOperacoes.add("Removido: " + registroRemovido);
            System.out.println("Removido.");
        }
    }

    private int lerIndice(List<String> lista) {
        try {
            int i = scanner.nextInt();
            scanner.nextLine();
            if (i < 0 || i >= lista.size()) {
                System.out.println("Índice fora do intervalo.");
                return -1;
            }
            return i;
        } catch (InputMismatchException e) {
            System.out.println("Digite um número válido.");
            scanner.nextLine();
            return -1;
        }
    }

    private String solicitarDados(String formato) {
        System.out.print("Informe os dados (" + formato + "): ");
        return scanner.nextLine();
    }

    private boolean validar(String dados, String formato) {
        if (dados == null || dados.isBlank()) return false;

        String[] valores = dados.split("-");
        String[] campos = formato.split(" - ");

        if (valores.length != campos.length) return false;

        for (String valor : valores) {
            if (valor.trim().isEmpty()) return false;
        }

        return true;
    }

    private void exibirLog() {
        if (logOperacoes.isEmpty()) {
            System.out.println("Nenhuma operação realizada.");
        } else {
            System.out.println("\n--- Log de Operações ---");
            logOperacoes.forEach(System.out::println);
        }
    }
}