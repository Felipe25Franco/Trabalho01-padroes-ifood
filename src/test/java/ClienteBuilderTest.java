import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteBuilderTest {
    @Test
    void deveRetornarExcecaoParaClienteSemNome() {
        try {
            ClienteBuilder clienteBuilder = new ClienteBuilder();
            Cliente cliente = clienteBuilder
                    .setValorPago(50)
                    .setSaldoApp(30)
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome inválido", e.getMessage());
        }
    }


    @Test
    void deveRetornarClienteValido() {
        ClienteBuilder clienteBuilder = new ClienteBuilder();
        Cliente cliente = clienteBuilder
                .setNome("Felipe")
                .setValorPago(50)
                .setSaldoApp(30)
                .build();

        assertNotNull(cliente);
    }

}
