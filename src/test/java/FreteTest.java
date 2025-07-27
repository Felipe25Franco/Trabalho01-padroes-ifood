import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FreteTest {

    @Test
    void deveRetornarValorDeFreteDistcanciaCurta() {
        FreteCurtaDistancia frete = new FreteCurtaDistancia();
        frete.setValorFrete(10);
        assertEquals(12.00, frete.calcularFrete());
    }

    @Test
    void deveRetornarInformacoesDeFreteDistanciaCurta() {
        FreteCurtaDistancia frete = new FreteCurtaDistancia();
        frete.setValorFrete(10);
        assertEquals("Frete{valor=10.0, frete=2.0}", frete.getInfo());
    }

    @Test
    void deveRetornarValorDeFreteDistcanciaMedia() {
        FreteMediaDistancia frete = new FreteMediaDistancia();
        frete.setValorFrete(10);
        assertEquals(15.00, frete.calcularFrete());
    }

    @Test
    void deveRetornarInformacoesDeFreteDistanciaMedia() {
        FreteMediaDistancia frete = new FreteMediaDistancia();
        frete.setValorFrete(10);
        assertEquals("Frete{valor=10.0, frete=5.0}", frete.getInfo());
    }

    @Test
    void deveRetornarValorDeFreteDistcanciaLonga() {
        FreteLongaDistancia frete = new FreteLongaDistancia();
        frete.setValorFrete(10);
        assertEquals(20.00, frete.calcularFrete());
    }

    @Test
    void deveRetornarInformacoesDeFreteDistanciaLonga(){
        FreteLongaDistancia frete = new FreteLongaDistancia();
        frete.setValorFrete(10);
        assertEquals("Frete{valor=10.0, frete=10.0}", frete.getInfo());
    }
}
