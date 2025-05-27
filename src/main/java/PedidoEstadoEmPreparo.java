public class PedidoEstadoEmPreparo extends PedidoEstado {



    private PedidoEstadoEmPreparo() {}
    private static PedidoEstadoEmPreparo instance = new PedidoEstadoEmPreparo();

    public static PedidoEstadoEmPreparo getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em Preparo";
    }

    public boolean pronto(Pedido pedido) {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        return true;
    }
}
