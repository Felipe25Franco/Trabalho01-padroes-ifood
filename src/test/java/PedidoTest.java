import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido pedido;


    @BeforeEach
    public void setUp() {
        pedido = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());

    }


    @Test
    public void naoDeveSolicitarPedidoSolicitado() {
        pedido.setEstado(PedidoEstadoSolicitado.getInstance());
        assertFalse(pedido.solicitar());
    }
    @Test
    public void devePrepararPedidoSolicitado() {
        pedido.setEstado(PedidoEstadoSolicitado.getInstance());
        assertTrue(pedido.preparar());
        assertEquals(PedidoEstadoEmPreparo.getInstance(),pedido.getEstado());
    }

    @Test
    public void naoDeveEstarProntoPedidoSolicitado() {
        pedido.setEstado(PedidoEstadoSolicitado.getInstance());
        assertFalse(pedido.pronto());
    }
    @Test
    public void naoDeveIrEntregarPedidoSolicitado() {
        pedido.setEstado(PedidoEstadoSolicitado.getInstance());
        assertFalse(pedido.entregando());
    }
    @Test
    public void naoDeveEntregarPedidoSolicitado() {
        pedido.setEstado(PedidoEstadoSolicitado.getInstance());
        assertFalse(pedido.entregue());
    }


    @Test
    public void naoDeveSolicitarPedidoEmPreparo() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertFalse(pedido.solicitar());
    }
    @Test
    public void naoDeveFicarEmPreparoPedidoEmPreparo() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertFalse(pedido.preparar());
    }
    @Test
    public void deveFicarProntoPedidoEmPreparo() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertTrue(pedido.pronto());
        assertEquals(PedidoEstadoPronto.getInstance(),pedido.getEstado());
    }
    @Test
    public void naoDeveIrEntregarPedidoEmPreparo() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertFalse(pedido.entregando());
    }
    @Test
    public void naoDeveEntregarPedidoEmPreparo() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertFalse(pedido.entregue());
    }

}
