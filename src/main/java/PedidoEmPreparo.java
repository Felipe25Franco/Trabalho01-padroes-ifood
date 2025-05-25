public class PedidoEmPreparo implements EstadoPedido {
    public String processar(Pedido pedido) {
        pedido.setEstado(new PedidoEmEntrega());
        return "Pedido saiu para entrega.";
    }

    public String getNomeEstado() {
        return "Em Preparo";
    }
}
