public class OpcaoSaldoApp implements OpcaoPagamento{

    public double pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com Saldo de APP.");
        return valor;
    }
}
