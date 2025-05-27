public class PedidoPronto extends PedidoEstado {

    private static PedidoPronto instance = new PedidoPronto();

    private PedidoPronto() {}

    public static PedidoPronto getInstance() {
        return instance;
    }

    public void proximoEstado(Pedido pedido) {
        if (getChain().aprovar()) {
            pedido.setEstado(PedidoEmEntrega.getInstance());
        }
    }

    public String getNomeEstado() {
        return "Pedido Pronto";
    }

    public Aprovador getChain() {
        return new Entregador();
    }
}
