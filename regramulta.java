import java.util.ArrayList;

public abstract class regramulta {
    protected static final int MULTA_LEVE = 1;
    protected static final int MULTA_MEDIA = 2;
    protected static final int MULTA_GRAVE = 3;

    public abstract int verificarNivelMulta(ocorrencia ocorrencia);
    public abstract String obterDescricaoMulta();

    public multa calcularMulta(ocorrencia ocorrencia) {
        int nivel = verificarNivelMulta(ocorrencia);
        if (nivel > 0) {
            return new multa(ocorrencia.getPlaca(), obterDescricaoMulta(), nivel);
        }
        return null; // Sem multa
    }
}
