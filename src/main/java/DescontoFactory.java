import java.lang.reflect.Constructor;

public class DescontoFactory {

    public static IDesconto obterDesconto(String tipoDesconto, double valorParametro) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("Desconto" + tipoDesconto);
            Constructor<?> construtor = classe.getConstructor(double.class);
            objeto = construtor.newInstance(valorParametro);

        } catch (Exception ex) {
            throw new IllegalArgumentException("Tipo de desconto inexistente");
        }

        if (!(objeto instanceof IDesconto)) {
            throw new IllegalArgumentException("Tipo de desconto inválido");
        }
        return (IDesconto) objeto;
    }


}
