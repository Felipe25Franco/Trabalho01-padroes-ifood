package V2;

public class OpcaoPix implements OpcaoPagamento{

    @Override
    public double pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado via PIX.");
        return valor;
    }
}
