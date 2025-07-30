public class EntregarPedidoComando implements Comando{
    private Pedido pedido;

    public EntregarPedidoComando(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String executar() {
        boolean sucesso = pedido.entregando();

        if (sucesso) {
            return "[COMMAND] Pedido preparado. Estado atual: " + pedido.getEstado();
        } else {
            return "[COMMAND] Falha ao preparar. Estado atual: " + pedido.getEstado();
        }
    }


}
