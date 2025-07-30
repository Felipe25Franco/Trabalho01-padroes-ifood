

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Pedido extends Observable implements Cloneable {

    private PedidoEstado estado;
    private TipoPedido tipoPedido;
    private Lanche lanche;
    private Frete frete;

    private double valorTotal;
    private IDesconto desconto;
    private List<PedidoEstado> memento = new ArrayList<PedidoEstado>();
    private Pagamento pagamento;



    public Pedido(TipoPedido tipoPedido) {
        this.estado = PedidoEstadoSolicitado.getInstance();
        this.tipoPedido = tipoPedido;
    }

    public void aplicarDesconto(String tipoDesconto, double valorParametro) {
        this.desconto = DescontoFactory.obterDesconto(tipoDesconto, valorParametro);
    }

    public double calcularTotalComDesconto() {
        if (desconto != null) {
            return desconto.aplicar(valorTotal);
        }
        return valorTotal;
    }

    public void processarPagamento() {
        if (pagamento != null) {
            pagamento.processarPagamento(valorTotal);
        } else {
            System.out.println("Nenhum método de pagamento definido.");
        }
    }
    // Getters e Setters
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
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
        this.memento.add(this.estado);
    }

    public void restauraEstado(int indice) {
        if (indice < 0 || indice > this.memento.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.estado = this.memento.get(indice);
    }

    public List<PedidoEstado> getEstados() {
        return this.memento;
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

    public Lanche getLanche() {
        return lanche;
    }

    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }




    @Override
    public String toString() {
        return "O pedido está " + estado.getEstado();
    }

    @Override
    public Pedido clone() throws CloneNotSupportedException {
        Pedido pedidoClone = (Pedido) super.clone();
        pedidoClone.estado = this.estado;
        pedidoClone.tipoPedido = this.tipoPedido;
        pedidoClone.lanche =  this.lanche;
        return pedidoClone;
    }
}
