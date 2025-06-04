package V2;

public class OpcaoCartaoDebito implements OpcaoPagamento{

    @Override
    public double pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com Cartão de Débito.");
        return valor;
    }
}
