import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
    public static void main(String[] args) {

        try {
            FileWriter escrita = new FileWriter("GuardarDados.txt");
            //escrita.write(String Consulta);
            escrita.close();
            System.out.println("Salvo com sucesso");

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar");
            e.printStackTrace();
        }

        try {


            FileReader leitura = new FileReader("GuardarDados.txt");
            BufferedReader bufferedReader = new BufferedReader(leitura);
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }
            bufferedReader.close();
            leitura.close();
        }catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar");
            e.printStackTrace();
        }

    }

}
