public class regracorredoronibus extends regramulta {
    private String logradouro;
    private int horarioInicio;
    private int horarioFim;

    public regracorredorOnibus(int horarioInicio, int horarioFim, String logradouro) {
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.logradouro = logradouro;
    }

    @Override
    public int verificarNivelMulta(ocorrencia ocorrencia) {
        if (ocorrencia.getTipo().equalsIgnoreCase("corredor") &&
                ocorrencia.getLogradouro().equalsIgnoreCase(logradouro)) {

            // Supondo que a hora está no formato "HH:mm" dentro do campo dataHora
            String[] partes = ocorrencia.getDataHora().split(" ");
            String hora = partes[1];
            int horaOcorrencia = Integer.parseInt(hora.split(":")[0]);

            if (horaOcorrencia >= horarioInicio && horaOcorrencia <= horarioFim) {
                return MULTA_GRAVE;
            }
        }
        return 0; // Sem multa
    }

    @Override
    public String obterDescricaoMulta() {
        return "Tráfego ilegal em corredor de ônibus no logradouro: " + logradouro;
    }
}
