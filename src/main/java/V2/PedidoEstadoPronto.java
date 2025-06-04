package V2;

public class PedidoEstadoPronto extends PedidoEstado{

    private PedidoEstadoPronto() {}
    private static PedidoEstadoPronto instance = new PedidoEstadoPronto();

    public static PedidoEstadoPronto getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pronto";
    }

    public boolean entregando(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmEntrega.getInstance());
        return true;
    }
}
