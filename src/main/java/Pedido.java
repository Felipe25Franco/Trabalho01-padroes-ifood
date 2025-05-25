import java.util.Observable;

public class Pedido extends Observable {
    private EstadoPedido estado;

    public Pedido() {
        this.estado = new PedidoCriado();
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        setChanged();
        notifyObservers();
    }

    public String processar() {
        String resultado = estado.processar(this);
        return resultado;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return estado.getNomeEstado();
    }
}
