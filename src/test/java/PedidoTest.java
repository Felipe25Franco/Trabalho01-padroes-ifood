import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    Pedido pedido;
    Cliente cliente;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
        cliente = new Cliente("Maria");
        pedido.addObserver(cliente);
    }

    @Test
    void deveNotificarClienteAoMudarEstado() {
        pedido.processar(); // Criado -> Em Preparo
        assertEquals("Maria foi notificado: Pedido agora está em estado Em Preparo", cliente.getNotificacao());

        pedido.processar(); // Em Preparo -> Em Entrega
        assertEquals("Maria foi notificado: Pedido agora está em estado Em Entrega", cliente.getNotificacao());

        pedido.processar(); // Em Entrega -> Entregue
        assertEquals("Maria foi notificado: Pedido agora está em estado Entregue", cliente.getNotificacao());
    }

    @Test
    void naoDeveMudarEstadoSePedidoEntregue() {
        pedido.setEstado(new PedidoEntregue());
        String resultado = pedido.processar();
        assertEquals("Pedido já foi entregue.", resultado);
    }

    @Test
    void deveVerificarPedidoComChainComSucesso() {
        VerificadorEstoque estoque = new VerificadorEstoque();
        VerificadorPagamento pagamento = new VerificadorPagamento();
        VerificadorEndereco endereco = new VerificadorEndereco();

        estoque.setProximo(pagamento);
        pagamento.setProximo(endereco);

        String resultado = estoque.verificar(pedido);
        assertEquals("OK", resultado);
    }
}
