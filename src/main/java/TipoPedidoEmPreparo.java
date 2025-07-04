

public class TipoPedidoEmPreparo implements TipoPedido{

    private static TipoPedidoEmPreparo tipoPedidoEmPreparo = new TipoPedidoEmPreparo();
    private TipoPedidoEmPreparo() {};
    public static TipoPedidoEmPreparo getTipoPedidoEmPreparo() {
        return tipoPedidoEmPreparo;
    }


}
