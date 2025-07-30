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
        Pedido pedidoClone2 = pedido.clone();


        pedidoClone.setEstado(PedidoEstadoPronto.getInstance());

        assertEquals("O pedido está Solicitado",pedido.toString());
        assertEquals("O pedido está Pronto",pedidoClone.toString());
        assertEquals("O pedido está Solicitado",pedidoClone2.toString());
    }


                                                    // DECORATOR

    @Test
    void deveRetornarPrecoLancheSimples() {
        Lanche lanche = new LancheSimples(10.0f);
        assertEquals(10.0f, lanche.getPreco(), 0.01f);
    }

    @Test
    void deveRetornarPrecoLancheComBebida() {
        Lanche lanche = new LancheSimples(10.0f);
        Lanche lancheComBebida = new Bebida(lanche);

        assertEquals(16.0f, lancheComBebida.getPreco());
    }

    @Test
    void deveRetornarDescricaoLancheComBebida() {
        Lanche lanche = new LancheSimples(10.0f);
        Lanche lancheComBebida = new Bebida(lanche);

        assertEquals("Lanche + Bebida", lancheComBebida.getDescricao());
    }

    @Test
    void deveRetornarPrecoLancheComSobremesa() {
        Lanche lanche = new LancheSimples(10.0f);
        Lanche lancheComSobremesa = new Sobremesa(lanche);

        assertEquals(20.0f, lancheComSobremesa.getPreco());
    }

    @Test
    void deveRetornarDescricaoLancheComSobremesa() {
        Lanche lanche = new LancheSimples(10.0f);
        Lanche lancheComSobremesa = new Sobremesa(lanche);

        assertEquals("Lanche + Sobremesa", lancheComSobremesa.getDescricao());
    }

    @Test
    void deveAceitarPedidoComLancheDecoradoComSobremesaEBebida() {
        Lanche lancheDecorado = new Sobremesa(new Bebida(new LancheSimples(12.0f)));
        pedido.setLanche(lancheDecorado);

        assertEquals(28.0f, pedido.getLanche().getPreco());
    }

                                                     // COMPOSITE

    @Test
    void deveRetornarPrecoTotalDoLancheComposto() {
        Lanche lancheSimples = new LancheSimples(12.0f);
        Lanche bebida = new Bebida(new LancheSimples(0)); // +6
        Lanche sobremesa = new Sobremesa(new LancheSimples(0)); // +10

        LancheComposto combo = new LancheComposto();
        combo.adicionar(lancheSimples);
        combo.adicionar(bebida);
        combo.adicionar(sobremesa);

        float precoEsperado = 12.0f + 6.0f + 10.0f;
        assertEquals(precoEsperado, combo.getPreco(), 0.01);
    }

    @Test
    void deveRetornarDescricaoDoLancheComposto() {
        Lanche lancheSimples = new LancheSimples(12.0f);
        Lanche bebida = new Bebida(new LancheSimples(0));
        Lanche sobremesa = new Sobremesa(new LancheSimples(0));

        LancheComposto combo = new LancheComposto();
        combo.adicionar(lancheSimples);
        combo.adicionar(bebida);
        combo.adicionar(sobremesa);

        String descricaoEsperada = "Combo: Lanche, Lanche + Bebida, Lanche + Sobremesa";

        assertEquals(descricaoEsperada, combo.getDescricao());
    }


    @Test
    void deveRetornarZeroParaComboVazio() {
        LancheComposto combo = new LancheComposto();
        assertEquals(0.0f, combo.getPreco(), 0.01);
        assertEquals("Combo: ", combo.getDescricao());
    }


                                                        // MEMENTO

    @Test
    void deveArmazenarEstados() {
        pedido = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());
        pedido.setEstado(PedidoEstadoSolicitado.getInstance());
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());

        assertEquals(2, pedido.getEstados().size());
    }
    @Test
    void deveRetornarEstadoInicial() {
        pedido = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());

        pedido.setEstado(PedidoEstadoSolicitado.getInstance());
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        pedido.restauraEstado(0);

        assertEquals(PedidoEstadoSolicitado.getInstance(), pedido.getEstado());
    }

    @Test
    void deveRetornarEstadoAnterior() {
        pedido = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());

        pedido.setEstado(PedidoEstadoSolicitado.getInstance());
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        pedido.setEstado(PedidoEstadoEmEntrega.getInstance());

        pedido.restauraEstado(2);

        assertEquals(PedidoEstadoPronto.getInstance(), pedido.getEstado());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            pedido = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());
            pedido.restauraEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }


                                                    // COMMAND

    @Test
    void deveMudarParaEmPreparo_QuandoEstadoEhSolicitado() {

        pedido = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());
        PrepararPedidoComando comando = new PrepararPedidoComando(pedido);

        comando.executar();
        assertEquals("Em Preparo", pedido.getEstado().getEstado());
    }

    @Test
    void deveManterEstado_QuandoNaoPodePreparar() {

        pedido = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());
        pedido.setEstado(PedidoEstadoEntregue.getInstance()); // Estado inválido
        PrepararPedidoComando comando = new PrepararPedidoComando(pedido);

        comando.executar();

        assertEquals("Entregue", pedido.getEstado().getEstado());
    }
    @Test
    void deveMudarParaEntregando_QuandoEstadoEhPronto() {

        pedido = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());
        pedido.setEstado(PedidoEstadoPronto.getInstance()); // Estado válido
        EntregarPedidoComando comando = new EntregarPedidoComando(pedido);

        comando.executar();

        assertEquals("Em Entrega", pedido.getEstado().getEstado());
    }

    @Test
    void deveManterEstado_QuandoNaoPodeEntregar() {
        pedido = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());
        pedido.setEstado(PedidoEstadoSolicitado.getInstance()); // Estado inválido
        EntregarPedidoComando comando = new EntregarPedidoComando(pedido);


        comando.executar();

        assertEquals("Solicitado", pedido.getEstado().getEstado());
    }

                                                        // FACTORY METHOD

    @Test
    void deveAplicarDescontoFixo() {
        pedido.setValorTotal(100.0);
        pedido.aplicarDesconto("Fixo", 15.0);
        assertEquals(85.0, pedido.calcularTotalComDesconto());
    }

    @Test
    void deveAplicarDescontoPercentual() {
        pedido.setValorTotal(100.0);
        pedido.aplicarDesconto("Percentual", 10.0);
        assertEquals(90.0, pedido.calcularTotalComDesconto());
    }

    @Test
    void naoDeveAplicarDescontoInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                pedido.aplicarDesconto("total", 0)
        );
    }



                                                // ADAPTER

    @Test
    void deveRetornarEstrelasAPartirDaNota() {
        IAvaliacao avaliacaoEstrela = new AvaliacaoEstrela();
        AvaliacaoAdapter adapter = new AvaliacaoAdapter(avaliacaoEstrela);
        adapter.setNota(9.2f);

        int estrelas = adapter.recuperarAvaliacao();

        assertEquals(5, estrelas);
    }

    @Test
    void deveRetornarNotaAPartirDasEstrelas() {
        IAvaliacao avaliacaoEstrela = new AvaliacaoEstrela();
        AvaliacaoAdapter adapter = new AvaliacaoAdapter(avaliacaoEstrela);

        avaliacaoEstrela.setAvaliacao(3); // 3 estrelas
        adapter.salvarAvaliacao();

        assertEquals(7.5f, adapter.getNota());
    }

    @Test
    void deveConverterNotaBaixaEmPoucasEstrelas() {
        IAvaliacao avaliacaoEstrela = new AvaliacaoEstrela();
        AvaliacaoAdapter adapter = new AvaliacaoAdapter(avaliacaoEstrela);
        adapter.setNota(2.5f);

        int estrelas = adapter.recuperarAvaliacao();

        assertEquals(0, estrelas);
    }

    @Test
    void deveConverterEstrelasZeroEmNotaBaixa() {
        IAvaliacao avaliacaoEstrela = new AvaliacaoEstrela();
        AvaliacaoAdapter adapter = new AvaliacaoAdapter(avaliacaoEstrela);

        avaliacaoEstrela.setAvaliacao(0);
        adapter.salvarAvaliacao();

        assertEquals(2.0f, adapter.getNota());
    }
}
