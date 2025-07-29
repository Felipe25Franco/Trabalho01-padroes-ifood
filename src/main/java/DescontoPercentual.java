public class DescontoPercentual implements IDesconto{

    private double percentual; // Ex: 10.0 = 10%

    public DescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double aplicar(double valorOriginal) {
        double desconto = valorOriginal * (percentual / 100.0);
        return valorOriginal - desconto;
    }
}
