import java.util.ArrayList;
public abstract class Funcionario {
    protected ArrayList listaPedidos = new ArrayList();
    private  Funcionario funcionarioSuperior;

    public Funcionario getFuncionarioSuperior() {return funcionarioSuperior;}

    public void setFuncionarioSuperior(Funcionario funcionarioSuperior) {
        this.funcionarioSuperior = funcionarioSuperior;
    }

    public abstract String getDescricaoCargo();

    public String validarEtapaPedido(Pedido pedido) {
        if (listaPedidos.contains(pedido.getTipoPedido())){
            return getDescricaoCargo();
        }
        else {
            if (funcionarioSuperior != null) {
                return getFuncionarioSuperior().validarEtapaPedido(pedido);
            }
            else {
                return "Sem proxima etapa";
            }
        }
    }

    public void processarPedido(Pedido pedido, Comando comando) {
        if (listaPedidos.contains(pedido.getTipoPedido())) {
            System.out.println("[CHAIN] " + getDescricaoCargo() + " está processando o pedido.");
            comando.executar();
        } else if (funcionarioSuperior != null) {
            funcionarioSuperior.processarPedido(pedido, comando);
        } else {
            System.out.println("[CHAIN] Nenhum funcionário pode processar este pedido.");
        }
    }
}
