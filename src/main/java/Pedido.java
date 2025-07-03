

import java.util.Observable;

public class Pedido extends Observable implements Cloneable{

    private PedidoEstado estado;
    private TipoPedido tipoPedido;

    public Pedido(TipoPedido tipoPedido) {
        this.estado = PedidoEstadoSolicitado.getInstance();
        this.tipoPedido = tipoPedido;
    }

    public void acompanharPedido(Cliente cliente) {
        addObserver(cliente);
    }

    public void acompanharPedido() {
        setChanged();
        notifyObservers(estado.getEstado());
    }

    // Métodos de transição de estado
    public boolean solicitar() {
        return estado.solicitar(this);
    }

    public boolean preparar() {
        boolean result = estado.preparar(this);
        if (result) {
            setChanged();
            notifyObservers(estado.getEstado());
        }
        return result;
    }

    public boolean pronto() {
        boolean result = estado.pronto(this);
        if (result) {
            setChanged();
            notifyObservers(estado.getEstado());
        }
        return result;
    }

    public boolean entregando() {
        boolean result = estado.entregando(this);
        if (result) {
            setChanged();
            notifyObservers(estado.getEstado());
        }
        return result;
    }

    public boolean entregue() {
        boolean result = estado.entregue(this);
        if (result) {
            setChanged();
            notifyObservers(estado.getEstado());
        }
        return result;
    }


    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    @Override
    public String toString() {
        return "O pedido está " + estado.getEstado();
    }

    @Override
    public Pedido clone() throws CloneNotSupportedException {
        Pedido pedidoClone = (Pedido) super.clone();

        pedidoClone.estado = (PedidoEstado) pedidoClone.estado.clone();
        pedidoClone.tipoPedido = (TipoPedido) pedidoClone.tipoPedido.clone();
        return pedidoClone;
    }
}
