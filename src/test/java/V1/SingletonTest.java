package V1;

import V1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class SingletonTest {

    @Test
    void deveRetornarMesmaInstanciaTipoPedidoSolicitado() {
        TipoPedidoSolicitado instancia1 = TipoPedidoSolicitado.getTipoPedidoSolicitado();
        TipoPedidoSolicitado instancia2 = TipoPedidoSolicitado.getTipoPedidoSolicitado();
        assertSame(instancia1, instancia2);
    }

    @Test
    void deveRetornarMesmaInstanciaTipoPedidoEmPreparo() {
        TipoPedidoEmPreparo instancia1 = TipoPedidoEmPreparo.getTipoPedidoEmPreparo();
        TipoPedidoEmPreparo instancia2 = TipoPedidoEmPreparo.getTipoPedidoEmPreparo();
        assertSame(instancia1, instancia2);
    }

    @Test
    void deveRetornarMesmaInstanciaTipoPedidoPronto() {
        TipoPedidoPronto instancia1 = TipoPedidoPronto.getTipoPedidoPronto();
        TipoPedidoPronto instancia2 = TipoPedidoPronto.getTipoPedidoPronto();
        assertSame(instancia1, instancia2);
    }

    @Test
    void deveRetornarMesmaInstanciaTipoPedidoEntregue() {
        TipoPedidoEntregue instancia1 = TipoPedidoEntregue.getTipoPedidoEntregue();
        TipoPedidoEntregue instancia2 = TipoPedidoEntregue.getTipoPedidoEntregue();
        assertSame(instancia1, instancia2);
    }

    @Test
    void deveRetornarMesmaInstanciaPedidoEstadoSolicitado() {
        PedidoEstadoSolicitado instancia1 = PedidoEstadoSolicitado.getInstance();
        PedidoEstadoSolicitado instancia2 = PedidoEstadoSolicitado.getInstance();
        assertSame(instancia1, instancia2);
    }

    @Test
    void deveRetornarInstanciasDiferentesEntreTipos() {
        TipoPedidoSolicitado tipoSolicitado = TipoPedidoSolicitado.getTipoPedidoSolicitado();
        TipoPedidoPronto tipoPronto = TipoPedidoPronto.getTipoPedidoPronto();
        assertNotSame(tipoSolicitado, tipoPronto);
    }

    @Test
    void deveRetornarInstanciasDiferentesEntreEstados() {
        PedidoEstadoSolicitado estadoSolicitado = PedidoEstadoSolicitado.getInstance();
        PedidoEstadoPronto estadoPronto = PedidoEstadoPronto.getInstance();
        assertNotSame(estadoSolicitado, estadoPronto);
    }
}