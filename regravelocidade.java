public class regravelocidade extends regramulta {
    private int limiteVelocidade;
    private String logradouro;

    public regravelocidade(int limiteVelocidade, String logradouro) {
        this.limiteVelocidade = limiteVelocidade;
        this.logradouro = logradouro;
    }

    @Override
    public int verificarNivelMulta(ocorrencia ocorrencia) {
        if (ocorrencia.getTipo().equalsIgnoreCase("velocidade") &&
                ocorrencia.getLogradouro().equalsIgnoreCase(logradouro)) {

            // Supondo que o nível seja inferido a partir de uma string no formato "velocidade:xx"
            String[] partes = ocorrencia.getTipo().split(":");
            if (partes.length > 1) {
                int velocidade = Integer.parseInt(partes[1]);
                if (velocidade > limiteVelocidade + 20) {
                    return MULTA_GRAVE;
                } else if (velocidade > limiteVelocidade + 10) {
                    return MULTA_MEDIA;
                } else if (velocidade > limiteVelocidade) {
                    return MULTA_LEVE;
                }
            }
        }
        return 0; // Sem multa
    }

    @Override
    public String obterDescricaoMulta() {
        return "Excesso de velocidade no logradouro: " + logradouro;
    }
}
