package Model;

public class Tarefas {
    private int id;
    private String nomeTarefa;
    private String nomeCategoria;
    private String situacao;

    public Tarefas(String nomeTarefa, String nomeCategoria, String situacao) {
        this.nomeTarefa = nomeTarefa;
        this.nomeCategoria = nomeCategoria;
        this.situacao = situacao;
    }

    public Tarefas(int id, String nomeTarefa, String nomeCategoria, String situacao) {
        this.id = id;
        this.nomeTarefa = nomeTarefa;
        this.nomeCategoria = nomeCategoria;
        this.situacao = situacao;
    }

    public int getId() {
        return id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
