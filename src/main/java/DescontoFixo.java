public class DescontoFixo implements IDesconto{

    private double valor;

    public DescontoFixo(double valor) {
        this.valor = valor;
    }

    @Override
    public double aplicar(double valorOriginal) {
        return valorOriginal - valor;
    }
}


