import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    //OBSERVER

    private Pedido pedido;
    private Cliente cliente1;
    private Cliente cliente2;
    @BeforeEach
    public void setUp() {
        pedido = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());
        cliente1 = new Cliente("João");
        cliente2 = new Cliente("Maria");


        pedido.acompanharPedido(cliente1);
        pedido.acompanharPedido(cliente2);
    }

    @Test
    void deveNotificarClientesQuandoPedidoEmPreparo() {
        pedido.preparar();

        assertEquals("João: status do pedido atualizado para Em Preparo", cliente1.getUltimaNotificacao());
        assertEquals("Maria: status do pedido atualizado para Em Preparo", cliente2.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientesQuandoPedidoPronto() {
        pedido.preparar();
        pedido.pronto();

        assertEquals("João: status do pedido atualizado para Pronto", cliente1.getUltimaNotificacao());
        assertEquals("Maria: status do pedido atualizado para Pronto", cliente2.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientesQuandoPedidoEmEntrega() {
        pedido.preparar();
        pedido.pronto();
        pedido.entregando();

        assertEquals("João: status do pedido atualizado para Em Entrega", cliente1.getUltimaNotificacao());
        assertEquals("Maria: status do pedido atualizado para Em Entrega", cliente2.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientesQuandoPedidoEntregue() {
        pedido.preparar();
        pedido.pronto();
        pedido.entregando();
        pedido.entregue();

        assertEquals("João: status do pedido atualizado para Entregue", cliente1.getUltimaNotificacao());
        assertEquals("Maria: status do pedido atualizado para Entregue", cliente2.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarDiferenteParaCadaCliente() {

        Pedido pedido1 = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());
        Cliente cliente1 = new Cliente("João");
        pedido1.acompanharPedido(cliente1);
        pedido1.preparar();
        pedido1.pronto();

        Pedido pedido2 = new Pedido(TipoPedidoSolicitado.getTipoPedidoSolicitado());
        Cliente cliente2 = new Cliente("Maria");
        pedido2.acompanharPedido(cliente2);
        pedido2.preparar();
        pedido2.pronto();
        pedido2.entregando();
        pedido2.entregue();


        assertEquals("João: status do pedido atualizado para Pronto", cliente1.getUltimaNotificacao());
        assertEquals("Maria: status do pedido atualizado para Entregue", cliente2.getUltimaNotificacao());
    }

    // STRATEGY

    @Test
    void devePagarComCartaoDeCredito(){
        Cliente cliente = new Cliente("Maria");
        cliente.pagarComCartaoCredito(59.80);
        assertEquals(59.80, cliente.getValorPago());

    }
    @Test
    void devePagarComCartaoDeDebito(){
        Cliente cliente = new Cliente("Maria");
        cliente.pagarComCartaoDebito(60);
        assertEquals(60.00, cliente.getValorPago());

    }

    @Test
    void devePagarComDinheiro(){
        Cliente cliente = new Cliente("Maria");
        cliente.pagarComDinheiro(70);
        assertEquals(70, cliente.getValorPago());
    }

    @Test
    void devePagarComPix() {
        Cliente cliente = new Cliente("Maria");
        cliente.pagarComPix(80);
        assertEquals(80, cliente.getValorPago());
    }
    @Test
    void devePagarComSaldoAppSuficiente(){
        Cliente cliente = new Cliente("Maria");
        cliente.setSaldoApp(100);
        cliente.pagarComSaldoApp(90);
        assertEquals(90, cliente.getValorPago());

    }

    @Test
    void deveRetornarSaldoDeAppAposPagamento(){
        Cliente cliente = new Cliente("Maria");
        cliente.setSaldoApp(100);
        cliente.pagarComSaldoApp(90);
        assertEquals(10, cliente.getSaldoApp());
    }
    @Test
    void naoDevePagarComSaldoAppInsuficiente(){
        Cliente cliente = new Cliente("Maria");
        cliente.setSaldoApp(30);
        cliente.pagarComSaldoApp(50);
        assertEquals(30, cliente.getSaldoApp());
    }
}
