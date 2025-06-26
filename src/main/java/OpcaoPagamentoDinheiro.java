

public class OpcaoPagamentoDinheiro implements OpcaoPagamento{
    public double pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado em Dinheiro.");
        return valor;
    }
}
