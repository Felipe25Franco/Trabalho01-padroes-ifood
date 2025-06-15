
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {

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
    void devePagarComSaldoApp(){
        Cliente cliente = new Cliente("Maria");
        cliente.pagarComSaldoApp(90);
        assertEquals(90, cliente.getValorPago());
    }
}
