public class regrarodizio extends regramulta {
    private String logradouro;
    private int diaRodizio;
    private int finalPlaca;

    public regrarodizio(String logradouro, int diaRodizio, int finalPlaca) {
        this.logradouro = logradouro;
        this.diaRodizio = diaRodizio;
        this.finalPlaca = finalPlaca;
    }

    @Override
    public int verificarNivelMulta(ocorrencia ocorrencia) {
        if (ocorrencia.getTipo().equalsIgnoreCase("rodizio") &&
                ocorrencia.getLogradouro().equalsIgnoreCase(logradouro)) {

            // Supondo que a data esteja no formato "AAAA-MM-DD" e final da placa seja último dígito
            String[] partes = ocorrencia.getDataHora().split("-");
            int dia = Integer.parseInt(partes[2]) % 7; // Calcula o dia da semana
            int finalPlacaOcorrencia = Integer.parseInt(ocorrencia.getPlaca().substring(ocorrencia.getPlaca().length() - 1));

            if (dia == diaRodizio && finalPlacaOcorrencia == finalPlaca) {
                return MULTA_MEDIA;
            }
        }
        return 0; // Sem multa
    }

    @Override
    public String obterDescricaoMulta() {
        return "Violação do rodízio no logradouro: " + logradouro;
    }
}
