import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PedidoTest {

    //STATE

    private Pedido pedido;


    @BeforeEach
    public void setUp() {
        pedido = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());
        entregador = new FuncionarioEntregador(null);
        cozinheiro = new FuncionarioCozinheiro(entregador);
        atendente = new FuncionarioAtendente(cozinheiro);


    }
//SOLICITAR

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

    //EMPREPARO
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

    //PRONTO
    @Test
    public void naoDeveSolicitarPedidoPronto () {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.solicitar());
    }
    @Test
    public void naoDevePrepararPedidoPronto () {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.preparar());
    }
    @Test
    public void naoDeveFicarProntoPedidoPronto () {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.pronto());
    }
    @Test
    public void deveIrParaEntregaPedidoEmPreparo() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertTrue(pedido.entregando());
        assertEquals(PedidoEstadoEmEntrega.getInstance(),pedido.getEstado());
    }
    @Test
    public void naoDeveEntregarPedidoPronto () {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.entregue());
    }

    //EM ENTREGA
    @Test
    public void naoDeveSolicitarPedidoEmEntrega () {
        pedido.setEstado(PedidoEstadoEmEntrega.getInstance());
        assertFalse(pedido.solicitar());
    }
    @Test
    public void naoDevePrepararPedidoEmEntrega () {
        pedido.setEstado(PedidoEstadoEmEntrega.getInstance());
        assertFalse(pedido.preparar());
    }
    @Test
    public void naoDeveFicarProntoPedidoEmEntrega () {
        pedido.setEstado(PedidoEstadoEmEntrega.getInstance());
        assertFalse(pedido.pronto());
    }
    @Test
    public void naoDeveIrEntregarProntoPedidoEmEntrega () {
        pedido.setEstado(PedidoEstadoEmEntrega.getInstance());
        assertFalse(pedido.entregando());
    }
    @Test
    public void deveEntregarProntoPedidoEmEntrega () {
        pedido.setEstado(PedidoEstadoEmEntrega.getInstance());
        assertTrue(pedido.entregue());
        assertEquals(PedidoEstadoEntregue.getInstance(),pedido.getEstado());
    }

    //ENTREGUE

    @Test
    public void naoDeveSolicitarPedidoEntregue () {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.solicitar());
    }
    @Test
    public void naoDevePrepararPedidoEntregue () {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.preparar());
    }
    @Test
    public void naoDeveFicarProntorPedidoEntregue () {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.pronto());
    }
    @Test
    public void naoDeveIrEntregarPedidoEntregue () {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.entregue());
    }
    @Test
    public void naoDeveEntregarPedidoEmEntrega () {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.entregue());
    }

    // CHAIN

    FuncionarioAtendente atendente;
    FuncionarioCozinheiro cozinheiro;
    FuncionarioEntregador entregador;



    @Test
    public void deveRetornarAtendenteParaValidarEtapaDePedido() {
        assertEquals("Atendente", atendente.validarEtapaPedido(new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado())));
    }

    @Test
    public void deveRetornarCozinheiroParaValidarEtapaDePedido() {
        assertEquals("Cozinheiro", cozinheiro.validarEtapaPedido(new Pedido(TipoPedidoEmPreparo.getTipoPedidoEmPreparo())));
    }

    @Test
    public void deveRetornarCozinheiroParaValidarEtapaDePedido2() {
        assertEquals("Cozinheiro", cozinheiro.validarEtapaPedido(new Pedido(TipoPedidoPronto.getTipoPedidoPronto())));
    }

    @Test
    public void deveRetornarEntregadorParaValidarEtapaDePedido() {
        assertEquals("Entregador", entregador.validarEtapaPedido(new Pedido(TipoPedidoEmEntrega.getTipoPedidoEmEntrega())));
    }

    @Test
    public void deveRetornarEntregadorParaValidarEtapaDePedido2() {
        assertEquals("Entregador", entregador.validarEtapaPedido(new Pedido(TipoPedidoEntregue.getTipoPedidoEntregue())));
    }
    @Test
    public void deveRetornarSemProximaEtapaDePedido() {
        assertEquals("Sem proxima etapa", entregador.validarEtapaPedido(new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado())));
    }

    // SINGLETON

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


    // PROTOTYPE

    @Test
    void testClone() throws CloneNotSupportedException {
        pedido = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());

        Pedido pedidoClone = pedido.clone();
        pedidoClone.setEstado(PedidoEstadoPronto.getInstance());

        assertEquals("O pedido está Solicitado",pedido.toString());
        assertEquals("O pedido está Pronto",pedidoClone.toString());
    }
}
