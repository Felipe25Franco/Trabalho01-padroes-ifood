package V2;

public class TipoPedidoPronto implements TipoPedido{
    private static TipoPedidoPronto tipoPedidoPronto = new TipoPedidoPronto();
    private TipoPedidoPronto() {};
    public static TipoPedidoPronto getTipoPedidoPronto() {
        return tipoPedidoPronto;
    }
}
