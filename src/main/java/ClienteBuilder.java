public class ClienteBuilder {
    private Cliente cliente;

    public ClienteBuilder(){
        cliente = new Cliente();
    }

    public Cliente build(){
        if (cliente.getNome().equals("")) {
            throw new IllegalArgumentException("Nome inválido");
        }
        return cliente;
    }

    public ClienteBuilder setNome(String nome) {
        cliente.setNome(nome);
        return this;
    }

    public ClienteBuilder setUltimaNotificacao(String ultimaNotificacao) {
        cliente.setUltimaNotificacao(ultimaNotificacao);
        return this;
    }

    public ClienteBuilder setValorPago(double valorPago) {
        cliente.setValorPago(valorPago);
        return this;
    }

    public ClienteBuilder setSaldoApp(double saldoApp) {
        cliente.setSaldoApp(saldoApp);
        return this;
    }
}
