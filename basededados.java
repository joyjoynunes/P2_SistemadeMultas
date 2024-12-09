import java.util.ArrayList;

public class basededados {
    private ArrayList<ocorrencia> ocorrenciasNaoProcessadas;
    private ArrayList<ocorrencia> ocorrenciasProcessadas;
    private ArrayList<multa> multas;

    public basededados() {
        ocorrenciasNaoProcessadas = new ArrayList<>();
        ocorrenciasProcessadas = new ArrayList<>();
        multas = new ArrayList<>();
    }

    public void adicionarOcorrencia(ocorrencia ocorrencia) {
        ocorrenciasNaoProcessadas.add(ocorrencia);
    }

    public void processarOcorrencias(ArrayList<regramulta> regras) {
        for (ocorrencia ocorrencia : ocorrenciasNaoProcessadas) {
            for (regramulta regra : regras) {
                multa multa = regra.calcularMulta(ocorrencia);
                if (multa != null) {
                    multas.add(multa);
                    break; // Apenas uma regra por ocorrência
                }
            }
            ocorrenciasProcessadas.add(ocorrencia);
        }
        ocorrenciasNaoProcessadas.clear();
    }

    public ArrayList<multa> getMultas() {
        return multas;
    }
}
