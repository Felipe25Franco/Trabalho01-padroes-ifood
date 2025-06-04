package V2;

public class PedidoEstadoEmEntrega extends PedidoEstado{

    private PedidoEstadoEmEntrega() {}
    private static PedidoEstadoEmEntrega instance = new PedidoEstadoEmEntrega();

    public static PedidoEstadoEmEntrega getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em Entrega";
    }

    public boolean entregue(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }
}
