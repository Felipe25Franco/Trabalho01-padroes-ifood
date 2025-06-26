public class OpcaoPagamentoSaldoApp implements OpcaoPagamento{

    private Cliente cliente;

    public OpcaoPagamentoSaldoApp(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public double pagar(double valor) {
        if (cliente.getSaldoApp() >= valor) {
            cliente.setSaldoApp(cliente.getSaldoApp() - valor);
            return valor;
        } else {
            return 0.0;
        }
    }
}
