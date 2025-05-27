public abstract class PedidoEstado {

    public abstract void proximoEstado(Pedido pedido);

    public abstract String getNomeEstado();

    public abstract Aprovador getChain();
}
