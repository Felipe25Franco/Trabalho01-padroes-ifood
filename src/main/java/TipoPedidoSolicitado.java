public class TipoPedidoSolicitado implements TipoPedido{
    private static TipoPedidoSolicitado tipoPedidoSolicitado = new TipoPedidoSolicitado();
    private TipoPedidoSolicitado() {};
    public static TipoPedidoSolicitado getTipoPedidoSolicitado() {
        return tipoPedidoSolicitado;
    }
}
