

public class TipoPedidoEntregue implements TipoPedido{

    private static TipoPedidoEntregue tipoPedidoEntregue = new TipoPedidoEntregue();
    private TipoPedidoEntregue() {};
    public static TipoPedidoEntregue getTipoPedidoEntregue() {
        return tipoPedidoEntregue;
    }
}
