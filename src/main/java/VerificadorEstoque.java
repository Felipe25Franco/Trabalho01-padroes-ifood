public class VerificadorEstoque extends VerificadorPedido {
    protected String verificarEtapa(Pedido pedido) {
        return "OK"; // Simulando estoque disponível
    }
}
