public class PedidoEmPreparo extends PedidoEstado {

    private static PedidoEmPreparo instance = new PedidoEmPreparo();

    private PedidoEmPreparo() {}

    public static PedidoEmPreparo getInstance() {
        return instance;
    }

    public void proximoEstado(Pedido pedido) {
        if (getChain().aprovar()) {
            pedido.setEstado(PedidoPronto.getInstance());
        }
    }

    public String getNomeEstado() {
        return "Pedido em Preparo";
    }

    public Aprovador getChain() {
        return new Cozinheiro();
    }
}
