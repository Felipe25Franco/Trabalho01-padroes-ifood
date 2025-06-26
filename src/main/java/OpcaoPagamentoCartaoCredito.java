
public class OpcaoPagamentoCartaoCredito implements OpcaoPagamento{


    public double pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com Cartão de Credito.");
        return valor;
    }
}
