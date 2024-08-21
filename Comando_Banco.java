package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Comando_Banco {

    public void adicionarTarefa(Tarefas tarefa) {
        String sql = "INSERT INTO tarefas (nome_tarefa, nome_categoria, situacao) VALUES (?, ?, ?)";

        try (Connection conn = Banco.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tarefa.getNomeTarefa());
            pstmt.setString(2, tarefa.getNomeCategoria());
            pstmt.setString(3, tarefa.getSituacao());
            pstmt.executeUpdate();

            System.out.println("Tarefa adicionada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar tarefa: " + e.getMessage());
        }
    }

    public void removerTarefa(int id) {
        String sql = "DELETE FROM tarefas WHERE id = ?";

        try (Connection conn = Banco.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Tarefa removida com sucesso!");
            } else {
                System.out.println("Nenhuma tarefa encontrada com o ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover tarefa: " + e.getMessage());
        }
    }

    public void editarTarefa(Tarefas tarefa) {
        String sql = "UPDATE tarefas SET nome_tarefa = ?, nome_categoria = ?, situacao = ? WHERE id = ?";

        try (Connection conn = Banco.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tarefa.getNomeTarefa());
            pstmt.setString(2, tarefa.getNomeCategoria());
            pstmt.setString(3, tarefa.getSituacao());
            pstmt.setInt(4, tarefa.getId());
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Tarefa editada com sucesso!");
            } else {
                System.out.println("Nenhuma tarefa encontrada com o ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao editar tarefa: " + e.getMessage());
        }
    }

    public void marcarComoConcluida(int id) {
        String sql = "UPDATE tarefas SET situacao = 'Concluída' WHERE id = ?";

        try (Connection conn = Banco.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Tarefa marcada como concluída com sucesso!");
            } else {
                System.out.println("Nenhuma tarefa encontrada com o ID.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao marcar tarefa como concluída: " + e.getMessage());
        }
    }
}
