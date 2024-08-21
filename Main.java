import java.util.Scanner;
import Model.Tarefas;
import Model.Comando_Banco;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Comando_Banco comandoBanco = new Comando_Banco();

        System.out.println("Sistema de Gestão de Tarefas");

        while (true) {
            System.out.println("Informe o que deseja fazer:" +
                    "A - Para Adicionar item na Lista" +
                    "R - Para Remover item na Lista" +
                    "E - Para Editar item na Lista" +
                    "C - Para Marcar como Concluída" +
                    "Qualquer outra tecla para sair e finalizar o programa");
            String escolha = scan.nextLine();

            if (escolha.equalsIgnoreCase("A")) {
                System.out.println("Informe o nome da tarefa");
                String nomeTarefa = scan.nextLine();
                System.out.println("Informe o nome da categoria");
                String nomeCategoria = scan.nextLine();
                System.out.println("Informe a situação da tarefa");
                String situacao = scan.nextLine();

                Tarefas tarefa = new Tarefas(nomeTarefa, nomeCategoria, situacao);
                comandoBanco.adicionarTarefa(tarefa);

            } else if (escolha.equalsIgnoreCase("R")) {
                System.out.println("Informe o id");
                int id = scan.nextInt();
                scan.nextLine();

                comandoBanco.removerTarefa(id);

            } else if (escolha.equalsIgnoreCase("E")) {
                System.out.println("Qual é o id da tarefa");
                int id = scan.nextInt();
                scan.nextLine();
                System.out.println("Informe o novo nome da tarefa");
                String nomeTarefa = scan.nextLine();
                System.out.println("Informe a nova categoria");
                String nomeCategoria = scan.nextLine();
                System.out.println("Informe a nova situação da tarefa");
                String situacao = scan.nextLine();

                Tarefas tarefa = new Tarefas(id, nomeTarefa, nomeCategoria, situacao);
                comandoBanco.editarTarefa(tarefa);

            } else if (escolha.equalsIgnoreCase("C")) {
                System.out.println("Qual é o id da tarefa que deseja marcar como concluída?");
                int id = scan.nextInt();
                scan.nextLine();

                comandoBanco.marcarComoConcluida(id);

            } else {
                System.out.println("Fim do Programa!");
                break;
            }
        }
    }
}
