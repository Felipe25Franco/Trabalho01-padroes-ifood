package V2;

public class PedidoEstadoSolicitado extends PedidoEstado{


    private PedidoEstadoSolicitado() {};
    private static PedidoEstadoSolicitado instance = new PedidoEstadoSolicitado();
    public static PedidoEstadoSolicitado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Solicitado";
    }
    public boolean preparar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        return true;
    }
}
