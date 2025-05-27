import java.util.Observable;

public class Pedido extends Observable {

    private PedidoEstado estado;
    private TipoPedido tipoPedido;

    public Pedido(TipoPedido tipoPedido) {
        this.estado = PedidoEstadoSolicitado.getInstance();
        this.tipoPedido = tipoPedido;
    }

    // Método modificado para permitir que um cliente se inscreva como observador
    public void acompanharPedido(Cliente cliente) {
        addObserver(cliente);  // Adiciona o cliente como observador
    }

    public void acompanharPedido() {
        setChanged();
        notifyObservers(estado.getEstado()); // Atualiza os observadores com o novo estado
    }

    // Métodos de transição de estado
    public boolean solicitar() {
        return estado.solicitar(this);
    }

    public boolean preparar() {
        boolean result = estado.preparar(this);
        if (result) {
            setChanged();
            notifyObservers(estado.getEstado());  // Notificar observadores após mudança
        }
        return result;
    }

    public boolean pronto() {
        boolean result = estado.pronto(this);
        if (result) {
            setChanged();
            notifyObservers(estado.getEstado());  // Notificar observadores após mudança
        }
        return result;
    }

    public boolean entregando() {
        boolean result = estado.entregando(this);
        if (result) {
            setChanged();
            notifyObservers(estado.getEstado());  // Notificar observadores após mudança
        }
        return result;
    }

    public boolean entregue() {
        boolean result = estado.entregue(this);
        if (result) {
            setChanged();
            notifyObservers(estado.getEstado());  // Notificar observadores após mudança
        }
        return result;
    }

    // Configuração e obtenção do estado do pedido
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
}
