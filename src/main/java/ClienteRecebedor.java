public class ClienteRecebedor implements Aprovador {
    public boolean aprovar() {
        System.out.println("Cliente confirmou o recebimento.");
        return true;
    }
}