public class multa {
    private String placa;
    private String descricao;
    private int nivel; // 0: sem multa, 1: leve, 2: média, 3: grave

    public multa(String placa, String descricao, int nivel) {
        this.placa = placa;
        this.descricao = descricao;
        this.nivel = nivel;
    }

    public String getPlaca() {
        return placa;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Descrição: " + descricao + ", Nível: " + nivel;
    }
}
