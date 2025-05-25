public class CentralNotificacoes {
    private static CentralNotificacoes instancia = new CentralNotificacoes();

    private CentralNotificacoes() {}

    public static CentralNotificacoes getInstancia() {
        return instancia;
    }

    public void notificarCliente(Cliente cliente, String mensagem) {
        System.out.println("Notificando " + cliente + ": " + mensagem);
    }
}
