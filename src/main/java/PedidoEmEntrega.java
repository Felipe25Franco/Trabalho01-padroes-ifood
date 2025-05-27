public class PedidoEmEntrega extends PedidoEstado {

    private static PedidoEmEntrega instance = new PedidoEmEntrega();

    private PedidoEmEntrega() {}

    public static PedidoEmEntrega getInstance() {
        return instance;
    }

    public void proximoEstado(Pedido pedido) {
        if (getChain().aprovar()) {
            pedido.setEstado(PedidoEntregue.getInstance());
        }
    }

    public String getNomeEstado() {
        return "Pedido em Entrega";
    }

    public Aprovador getChain() {
        return new ClienteRecebedor();
    }
}
