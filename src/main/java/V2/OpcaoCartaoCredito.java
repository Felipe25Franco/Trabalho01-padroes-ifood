package V2;

public class OpcaoCartaoCredito implements OpcaoPagamento{

    @Override
    public double pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com Cartão de Credito.");
        return valor;
    }
}
