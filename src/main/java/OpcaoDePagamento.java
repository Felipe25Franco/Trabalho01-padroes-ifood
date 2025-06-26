

public class OpcaoDePagamento {

    private double valor;

    public OpcaoDePagamento(double valor) {
        this.valor = valor;
    }
    public double executarPagamento(OpcaoPagamento opcao) {
        return opcao.pagar(valor);
    }
}
