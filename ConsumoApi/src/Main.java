import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scan = new Scanner(System.in);
        Gson gson = new Gson();
        BancoFunc banco = new BancoFunc();

        while (true) {

            System.out.println("Selecione o que deseja fazer | 1 - Para Consultar o CEP | 2 - para ver as listas de CEPS cadastrados no banco de dados | 3 - Para sair do programa");
            int opcao = scan.nextInt();

            if (opcao == 1) {
                System.out.println("Informe o Cep Para ser Consultado");
                String Consulta = scan.nextLine();

                BuscaEndereco api = new BuscaEndereco();
                String resultado = api.consomeApi(Consulta);
                Endereco endereco = gson.fromJson(resultado, Endereco.class);
                System.out.println(endereco);

               BancoFunc.insertEndereco(endereco);


            }
            else if (opcao == 2) {
                System.out.println("A lista de Ceps Cadastrado no banco é");

                BancoFunc.selectEndereco();

            }
            else if (opcao == 3) {
                System.out.println("Você saiu do programa");
                break;
            }
            else {
                System.out.println("Código incorreto");
            }
        }
    }
}