

public abstract class PedidoEstado{

    public abstract String getEstado();

    public boolean solicitar(Pedido pedido) {
        return false;
    }
    public boolean preparar(Pedido pedido) {
        return false;
    }

    public boolean pronto(Pedido pedido) {
        return false;
    }
    public boolean entregando(Pedido pedido) {
        return false;
    }
    public boolean entregue(Pedido pedido) {
        return false;
    }


}
