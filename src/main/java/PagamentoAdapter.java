public class PagamentoAdapter implements Pagamento {
    private Object sistemaPagamento;

    public PagamentoAdapter(Object sistemaPagamento) {
        this.sistemaPagamento = sistemaPagamento;
    }

    @Override
    public String processarPagamento(double valor) {
        if (sistemaPagamento instanceof PayPalAdapter) {
            return ((PayPalAdapter) sistemaPagamento).processarPagamento(valor);
        } else if (sistemaPagamento instanceof PagSeguroAdapter) {
            return ((PagSeguroAdapter) sistemaPagamento).processarPagamento(valor);
        } else {
            return "Método de pagamento não suportado.";
        }
    }
}
