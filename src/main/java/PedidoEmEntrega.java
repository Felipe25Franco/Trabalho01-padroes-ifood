public class PedidoEmEntrega implements EstadoPedido {
    public String processar(Pedido pedido) {
        pedido.setEstado(new PedidoEntregue());
        return "Pedido entregue.";
    }

    public String getNomeEstado() {
        return "Em Entrega";
    }
}
