public abstract class Frete {
    private double valorFrete;

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public abstract double verificarFrete();

    public double calcularFrete() { return  (valorFrete + this.verificarFrete());}

    public String getTipo() {return "Frete";}

    public String getInfo() {
        return getTipo() + "{" +
                "valor=" + this.valorFrete +
                ", frete=" + this.verificarFrete() +
                "}";
    }
}
