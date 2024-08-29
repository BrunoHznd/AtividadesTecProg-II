import com.google.gson.annotations.SerializedName;

public class Endereco {

    @SerializedName("cep")
    public String CEP;

    @SerializedName("logradouro")
    public String rua;

    @SerializedName("bairro")
    public String bairro;

    @SerializedName("cidade")
    public String localidade;

    @SerializedName("uf")
    public String estado;

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "CEP='" + CEP + '\'' +
                ", LOGRADOURO='" + rua + '\'' +
                ", BAIRRO='" + bairro + '\'' +
                ", LOCALIDADE='" + localidade + '\'' +
                ", ESTADO='" + estado + '\'' +
                '}';
    }
}
