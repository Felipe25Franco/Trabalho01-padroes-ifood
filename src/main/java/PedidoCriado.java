public class PedidoCriado implements EstadoPedido {
    public String processar(Pedido pedido) {
        pedido.setEstado(new PedidoEmPreparo());
        return "Pedido foi para preparo.";
    }

    public String getNomeEstado() {
        return "Criado";
    }
}
