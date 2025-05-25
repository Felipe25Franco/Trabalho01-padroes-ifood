import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String nome;
    private String notificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNotificacao() {
        return notificacao;
    }

    public void update(Observable pedido, Object arg) {
        this.notificacao = this.nome + " foi notificado: Pedido agora está em estado " + pedido.toString();
    }
}
