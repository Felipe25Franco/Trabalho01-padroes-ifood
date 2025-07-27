public class LancheSimples implements Lanche{

    private float preco;

    public LancheSimples(float preco) {
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public String getDescricao() {
        return "Lanche";
    }
}
