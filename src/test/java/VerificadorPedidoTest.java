import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VerificadorPedidoTest {

    @Test
    void deveRetornarErroSeVerificadorInterromper() {
        VerificadorEstoque estoque = new VerificadorEstoque() {
            @Override
            protected String verificarEtapa(Pedido pedido) {
                return "Estoque insuficiente";
            }
        };

        VerificadorPagamento pagamento = new VerificadorPagamento();
        estoque.setProximo(pagamento);

        String resultado = estoque.verificar(new Pedido());
        assertEquals("Estoque insuficiente", resultado);
    }
}
