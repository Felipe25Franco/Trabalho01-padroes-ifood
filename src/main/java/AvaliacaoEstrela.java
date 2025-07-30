public class AvaliacaoEstrela implements IAvaliacao {

    private int estrela;

    @Override
    public int getAvaliacao() {
        return this.estrela;
    }

    @Override
    public void setAvaliacao(int estrela) {
        if (estrela < 0 || estrela > 5) {
            throw new IllegalArgumentException("Estrelas devem estar entre 0 e 5");
        }
        this.estrela = estrela;
    }
}