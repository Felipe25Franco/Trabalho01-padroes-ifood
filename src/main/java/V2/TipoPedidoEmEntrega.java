package V2;

public class TipoPedidoEmEntrega implements TipoPedido{
    private static TipoPedidoEmEntrega tipoPedidoEmEntrega = new TipoPedidoEmEntrega();
    private TipoPedidoEmEntrega() {};
    public static TipoPedidoEmEntrega getTipoPedidoEmEntrega() {
        return tipoPedidoEmEntrega;
    }


}
