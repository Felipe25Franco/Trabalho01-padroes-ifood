public class PedidoSolicitado extends PedidoEstado {

    private static PedidoSolicitado instance = new PedidoSolicitado();

    private PedidoSolicitado() {}

    public static PedidoSolicitado getInstance() {
        return instance;
    }

    public void proximoEstado(Pedido pedido) {
        if (getChain().aprovar()) {
            pedido.setEstado(PedidoEmPreparo.getInstance());
        }
    }

    public String getNomeEstado() {
        return "Pedido Solicitado";
    }

    public Aprovador getChain() {
        return new Atendente();
    }
}
