import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<String> epis = new ArrayList<>();
    static List<String> funcionarios = new ArrayList<>();
    static List<String> emprestimos = new ArrayList<>();
    static List<String> logOperacoes = new ArrayList<>();

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        MenuCrud menuCrud = new MenuCrud(logOperacoes);

        while (true) {
            System.out.print("\n=== Sistema de Gerenciamento ===\n" +
                    "1. Módulo de EPIs\n" +
                    "2. Módulo de Funcionários\n" +
                    "3. Módulo de Empréstimos\n" +
                    "4. Log de Operações\n" +
                    "0. Sair\n" +
                    "Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> menuCrud.mostrarMenu(epis, "Nome - Quantidade - Descrição");
                case 2 -> menuCrud.mostrarMenu(funcionarios, "Nome - E-mail");
                case 3 -> menuCrud.mostrarMenu(emprestimos, "Nome EPI - Nome funcionário - Data empréstimo - Data devolução");
                case 4 -> menuCrud.exibirLog();
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}