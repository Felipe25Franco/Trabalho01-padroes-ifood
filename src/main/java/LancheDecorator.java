public abstract class LancheDecorator implements Lanche{

    private Lanche lanche;

    public LancheDecorator(Lanche lanche) {
        this.lanche = lanche;
    }

    protected Lanche getLanche() {
        return lanche;
    }

    public float getPreco() {
        return lanche.getPreco() + getPrecoAdicional();
    }

    public String getDescricao() {
        return lanche.getDescricao() + " + " + getNomeAdicional();
    }

    public abstract float getPrecoAdicional();
    public abstract String getNomeAdicional();
}
