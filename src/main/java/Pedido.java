import java.util.Observable;

public class Pedido extends Observable {

    private PedidoEstado estado;
    private TipoPedido tipoPedido;

    public Pedido(TipoPedido tipoPedido) {

        this.estado = PedidoEstadoSolicitado.getInstance();
        this.tipoPedido = tipoPedido;
    }


    public void acompanharPedido() {
        setChanged();
        notifyObservers();
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }
    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }


    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public boolean solicitar() {
        return estado.solicitar(this);
    }
    public boolean preparar() {
        return estado.preparar(this);
    }

    public boolean pronto() {
        return estado.pronto(this);
    }
    public boolean entregando() {
        return estado.entregando(this);
    }
    public boolean entregue() {
        return estado.entregue(this);
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "O pedido está" + estado;
    }
}
