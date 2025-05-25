public class PedidoEntregue implements EstadoPedido {
    public String processar(Pedido pedido) {
        return "Pedido já foi entregue.";
    }

    public String getNomeEstado() {
        return "Entregue";
    }
}
