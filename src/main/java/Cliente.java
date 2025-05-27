import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void acompanhar(Pedido pedido) {
        pedido.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        this.ultimaNotificacao = nome + ": status do pedido atualizado para " + arg;
        System.out.println(ultimaNotificacao);
    }
}
