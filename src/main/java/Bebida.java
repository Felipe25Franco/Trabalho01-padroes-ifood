public class Bebida extends LancheDecorator{
    public Bebida(Lanche lanche) {
        super(lanche);
    }

    public float getPrecoAdicional() {
        return 6.00f;
    }

    public String getNomeAdicional() {
        return "Bebida";
    }
}
