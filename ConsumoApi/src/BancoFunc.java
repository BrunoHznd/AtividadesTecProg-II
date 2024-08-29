import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoFunc {

    public static void insertEndereco(Endereco endereco) {
        try (Connection connection = Banco.connect()) {
            if (connection != null) {
                String query = "INSERT INTO ENDERECO(CEP, RUA, BAIRRO, CIDADE, UF) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, endereco.getCEP());
                    statement.setString(2, endereco.getRua());
                    statement.setString(3, endereco.getBairro());
                    statement.setString(4, endereco.getLocalidade()); // Ou getCidade() se preferir manter a consistência
                    statement.setString(5, endereco.getEstado());

                    statement.executeUpdate(); // Necessário para executar a inserção
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectEndereco() {
        try (Connection connection = Banco.connect()) {
            if (connection != null) {
                String query = "SELECT * FROM ENDERECO";
                try (PreparedStatement stmt = connection.prepareStatement(query)) {
                    ResultSet rs = stmt.executeQuery();
                    List<Endereco> enderecos = new ArrayList<>();

                    while (rs.next()) {
                        Endereco endereco = new Endereco();
                        endereco.setCEP(rs.getString("cep"));
                        endereco.setRua(rs.getString("rua"));
                        endereco.setBairro(rs.getString("bairro"));
                        endereco.setLocalidade(rs.getString("cidade"));
                        endereco.setEstado(rs.getString("uf"));
                        enderecos.add(endereco);
                    }

                    enderecos.forEach(endereco -> System.out.println(endereco.toString()));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar endereços");
            e.printStackTrace();
        }
    }
}
