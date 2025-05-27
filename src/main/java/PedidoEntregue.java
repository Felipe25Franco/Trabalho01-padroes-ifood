public class PedidoEntregue extends PedidoEstado {

    private static PedidoEntregue instance = new PedidoEntregue();

    private PedidoEntregue() {}

    public static PedidoEntregue getInstance() {
        return instance;
    }

    public void proximoEstado(Pedido pedido) {
        // Estado final, não avança mais.
    }

    public String getNomeEstado() {
        return "Pedido Entregue";
    }

    public Aprovador getChain() {
        return () -> true; // Sempre aprova (ou nenhum aprovador)
    }
}
