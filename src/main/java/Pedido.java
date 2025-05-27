import java.util.Observable;

public class Pedido extends Observable {

    private PedidoEstado estado;

    public Pedido() {
        this.estado = PedidoSolicitado.getInstance();
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
        setChanged();
        notifyObservers(estado.getNomeEstado());
    }

    public void proximoEstado() {
        this.estado.proximoEstado(this);
    }
}
