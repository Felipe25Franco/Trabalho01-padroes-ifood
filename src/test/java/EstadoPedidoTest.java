import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstadoPedidoTest {

    @Test
    void deveMudarEstadosCorretamente() {
        Pedido pedido = new Pedido();

        assertEquals("Criado", pedido.getEstado().getNomeEstado());

        pedido.processar();
        assertEquals("Em Preparo", pedido.getEstado().getNomeEstado());

        pedido.processar();
        assertEquals("Em Entrega", pedido.getEstado().getNomeEstado());

        pedido.processar();
        assertEquals("Entregue", pedido.getEstado().getNomeEstado());

        String resultado = pedido.processar(); // já está entregue
        assertEquals("Pedido já foi entregue.", resultado);
    }
}
