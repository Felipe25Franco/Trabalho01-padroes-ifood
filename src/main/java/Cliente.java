
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
        Opcao opcao = new Opcao(valor);
        this.valorPago = opcao.executarPagamento(new OpcaoCartaoDebito());
    }

    public void pagarComPix(double valor) {
        Opcao opcao = new Opcao(valor);
        this.valorPago = opcao.executarPagamento(new OpcaoPix());
    }

    public void pagarComDinheiro(double valor) {
        Opcao opcao = new Opcao(valor);
        this.valorPago = opcao.executarPagamento(new OpcaoDinheiro());
    }

    public void pagarComCartaoCredito(double valor) {
        Opcao opcao = new Opcao(valor);
        this.valorPago = opcao.executarPagamento(new OpcaoCartaoCredito());
    }

    public void pagarComSaldoApp(double valor) {
        Opcao opcao = new Opcao(valor);
        this.valorPago = opcao.executarPagamento(new OpcaoSaldoApp(this));
    }

    public void acompanhar(Pedido pedido) {
        pedido.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        this.ultimaNotificacao = nome + ": status do pedido atualizado para " + arg;
        System.out.println(ultimaNotificacao);
    }
}
