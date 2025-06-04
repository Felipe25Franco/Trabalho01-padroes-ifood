package V2;

public class OpcaoSaldoApp implements OpcaoPagamento{
    @Override
    public double pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com Saldo de APP.");
        return valor;
    }
}
