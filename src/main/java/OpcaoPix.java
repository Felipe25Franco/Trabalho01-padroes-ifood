
public class OpcaoPix implements OpcaoPagamento{


    public double pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado via PIX.");
        return valor;
    }
}
