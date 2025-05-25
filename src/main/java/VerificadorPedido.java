public abstract class VerificadorPedido {
    private VerificadorPedido proximo;

    public VerificadorPedido getProximo() {
        return proximo;
    }

    public void setProximo(VerificadorPedido proximo) {
        this.proximo = proximo;
    }

    public String verificar(Pedido pedido) {
        String resultado = verificarEtapa(pedido);
        if (resultado.equals("OK") && proximo != null) {
            return proximo.verificar(pedido);
        }
        return resultado;
    }

    protected abstract String verificarEtapa(Pedido pedido);
}
