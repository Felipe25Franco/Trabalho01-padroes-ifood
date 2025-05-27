import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChainTest {

    FuncionarioAtendente atendente;
    FuncionarioCozinheiro cozinheiro;
    FuncionarioEntregador entregador;

    @BeforeEach
    void setUp() {
        entregador = new FuncionarioEntregador(null);
        cozinheiro = new FuncionarioCozinheiro(entregador);
        atendente = new FuncionarioAtendente(cozinheiro);
    }

    @Test
    public void deveRetornarAtendenteParaValidarEtapaDePedido() {
        assertEquals("Atendente", atendente.validarEtapaPedido(new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado())));
    }

    @Test
    public void deveRetornarCozinheiroParaValidarEtapaDePedido() {
        assertEquals("Cozinheiro", cozinheiro.validarEtapaPedido(new Pedido(TipoPedidoEmPreparo.getTipoPedidoEmPreparo())));
    }

    @Test
    public void deveRetornarCozinheiroParaValidarEtapaDePedido3() {
        assertEquals("Cozinheiro", cozinheiro.validarEtapaPedido(new Pedido(TipoPedidoPronto.getTipoPedidoPronto())));
    }

    @Test
    public void deveRetornarEntregadorParaValidarEtapaDePedido() {
        assertEquals("Entregador", entregador.validarEtapaPedido(new Pedido(TipoPedidoEmEntrega.getTipoPedidoEmEntrega())));
    }

    @Test
    public void deveRetornarEntregadorParaValidarEtapaDePedido5() {
        assertEquals("Entregador", entregador.validarEtapaPedido(new Pedido(TipoPedidoEntregue.getTipoPedidoEntregue())));
    }
    @Test
    public void deveRetornarSemProximaEtapaDePedido() {
        assertEquals("Sem proxima etapa", entregador.validarEtapaPedido(new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado())));
    }
}
