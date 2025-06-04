package V2;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String nome;
    private String ultimaNotificacao;
    private double valorPago;

    public Cliente(String nome) {this.nome = nome;}
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
        this.valorPago = opcao.executarPagamento(new OpcaoSaldoApp());
    }

    public void updade(Observable o, Object arg) {
        this.ultimaNotificacao = nome + ": status do pedido atualizado para " + arg;
        System.out.println(ultimaNotificacao);
    }
}
