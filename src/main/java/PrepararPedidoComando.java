public class PrepararPedidoComando implements Comando{
    private Pedido pedido;

    public PrepararPedidoComando(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String executar() {
        boolean sucesso = pedido.preparar();

        if (sucesso) {
            return "[COMMAND] Pedido preparado. Estado atual: " + pedido.getEstado();
        } else {
            return "[COMMAND] Falha ao preparar. Estado atual: " + pedido.getEstado();
        }
    }


}