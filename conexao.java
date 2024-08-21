import java.sql.SQLException;

public class conexao {
    public static void main (String[] args) {

        try (var connection = Banco.connect()) {
            System.out.println("Conectado com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
