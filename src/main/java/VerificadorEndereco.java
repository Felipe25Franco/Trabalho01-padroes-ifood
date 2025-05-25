public class VerificadorEndereco extends VerificadorPedido {
    protected String verificarEtapa(Pedido pedido) {
        return "OK"; // Simulando endereço válido
    }
}
