package Jdbc.Model;

public class Address {
    private int cod_end;
    private String logradouro;
    private String tipo_logradouro;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;
    private String numero;
    private String bairro;

    public Address(int cod_end, String logradouro, String tipo_logradouro, String complemento, String cidade, String uf, String cep, String numero, String bairro) {
        this.cod_end = cod_end;
        this.logradouro = logradouro;
        this.tipo_logradouro = tipo_logradouro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
    }

    public int getCod_end() {
        return cod_end;
    }

    public void setCod_end(int cod_end) {
        this.cod_end = cod_end;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getTipo_logradouro() {
        return tipo_logradouro;
    }

    public void setTipo_logradouro(String tipo_logradouro) {
        this.tipo_logradouro = tipo_logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Address{" +
                "cod_end=" + cod_end +
                ", logradouro='" + logradouro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", numero='" + numero + '\'' +
                "}\n";
    }
}
