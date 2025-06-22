public class OpcaoSaldoApp implements OpcaoPagamento{

    private Cliente cliente;

    public OpcaoSaldoApp(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public double pagar(double valor) {
        if (cliente.getSaldoApp() >= valor) {
            cliente.setSaldoApp(cliente.getSaldoApp() - valor);
            System.out.println("Pagamento de R$" + valor +" com saldo do app realizado com sucesso.");
            return valor;
        } else {
            System.out.println("Saldo insuficiente no app.");
            return 0.0;
        }
    }
}
