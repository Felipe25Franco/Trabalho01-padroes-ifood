public class EntregarPedidoComando implements Comando{
    private Pedido pedido;

    public EntregarPedidoComando(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        boolean sucesso = pedido.entregando();

        if (sucesso) {
            System.out.println("[COMMAND] Pedido preparado. Estado atual: " + pedido.getEstado());
        } else {
            System.out.println("[COMMAND] Falha ao preparar. Estado atual: " + pedido.getEstado());
        }
    }


}
