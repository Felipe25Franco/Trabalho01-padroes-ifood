
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {

    @Test
    void devePagarComCartaoDeCredito(){
        Cliente cliente = new Cliente("Maria");
        cliente.pagarComCartaoCredito(59.80);
        assertEquals(59.80, cliente.getValorPago());

    }
}
