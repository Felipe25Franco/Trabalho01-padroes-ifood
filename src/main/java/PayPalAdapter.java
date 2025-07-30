public class PayPalAdapter implements Pagamento{
    @Override
    public String processarPagamento(double valor) {
        return "Pagamento de R$" + valor + " processado pelo PayPal.";
    }

}
