public class VerificadorPagamento extends VerificadorPedido {
    protected String verificarEtapa(Pedido pedido) {
        return "OK"; // Simulando pagamento confirmado
    }
}
