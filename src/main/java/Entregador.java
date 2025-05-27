public class Entregador implements Aprovador {
    public boolean aprovar() {
        System.out.println("Entregador retirou o pedido.");
        return true;
    }
}