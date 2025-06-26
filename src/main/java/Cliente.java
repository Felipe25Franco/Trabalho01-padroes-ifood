
import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String nome;
    private String ultimaNotificacao;
    private double valorPago;
    private double saldoApp;

    public Cliente(String nome) {this.nome = nome;}

    public double getSaldoApp() {
        return saldoApp;
    }

    public void setSaldoApp(double saldoApp) {
        this.saldoApp = saldoApp;
    }
    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void pagarComCartaoDebito(double valor) {
        OpcaoDePagamento opcaoDePagamento = new OpcaoDePagamento(valor);
        this.valorPago = opcaoDePagamento.executarPagamento(new OpcaoPagamentoCartaoDebito());
    }

    public void pagarComPix(double valor) {
        OpcaoDePagamento opcaoDePagamento = new OpcaoDePagamento(valor);
        this.valorPago = opcaoDePagamento.executarPagamento(new OpcaoPagamentoPix());
    }

    public void pagarComDinheiro(double valor) {
        OpcaoDePagamento opcaoDePagamento = new OpcaoDePagamento(valor);
        this.valorPago = opcaoDePagamento.executarPagamento(new OpcaoPagamentoDinheiro());
    }

    public void pagarComCartaoCredito(double valor) {
        OpcaoDePagamento opcaoDePagamento = new OpcaoDePagamento(valor);
        this.valorPago = opcaoDePagamento.executarPagamento(new OpcaoPagamentoCartaoCredito());
    }

    public void pagarComSaldoApp(double valor) {
        OpcaoDePagamento opcaoDePagamento = new OpcaoDePagamento(valor);
        this.valorPago = opcaoDePagamento.executarPagamento(new OpcaoPagamentoSaldoApp(this));
    }

    public void acompanhar(Pedido pedido) {
        pedido.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        this.ultimaNotificacao = nome + ": status do pedido atualizado para " + arg;
    }
}
