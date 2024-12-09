public class ocorrencia {
    private String placa;
    private String logradouro;
    private String tipo; // Exemplo: "velocidade", "rodízio", "corredor"
    private String dataHora;

    public ocorrencia(String placa, String logradouro, String tipo, String dataHora) {
        this.placa = placa;
        this.logradouro = logradouro;
        this.tipo = tipo;
        this.dataHora = dataHora;
    }

    public String getPlaca() {
        return placa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDataHora() {
        return dataHora;
    }
}
