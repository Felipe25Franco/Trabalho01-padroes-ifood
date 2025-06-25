
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class SingletonTest {

    @Test
    void deveRetornarInstanciaDeEstadoDePedidoSolicitado() {
        PedidoEstadoSolicitado.getInstance().getEstado();
        assertEquals("Solicitado", PedidoEstadoSolicitado.getInstance().getEstado());
    }

    @Test
    void deveRetornarInstanciaDeEstadoDePedidoEmPreparo() {
        PedidoEstadoEmPreparo.getInstance().getEstado();
        assertEquals("Em Preparo", PedidoEstadoEmPreparo.getInstance().getEstado());
    }
    @Test
    void deveRetornarInstanciaDeEstadoDePedidoPronto() {
        PedidoEstadoPronto.getInstance().getEstado();
        assertEquals("Pronto", PedidoEstadoPronto.getInstance().getEstado());
    }
    @Test
    void deveRetornarInstanciaDeEstadoDePedidoEmEntrega() {
        PedidoEstadoEmEntrega.getInstance().getEstado();
        assertEquals("Em Entrega", PedidoEstadoEmEntrega.getInstance().getEstado());
    }
    @Test
    void deveRetornarInstanciaDeEstadoDePedidoEntregue() {
        PedidoEstadoEntregue.getInstance().getEstado();
        assertEquals("Entregue", PedidoEstadoEntregue.getInstance().getEstado());
    }


}