public class Sobremesa extends LancheDecorator{
    public Sobremesa(Lanche lanche) {
        super(lanche);
    }

    public float getPrecoAdicional() {
        return 10.00f;
    }

    public String getNomeAdicional() {
        return "Sobremesa";
    }
}
