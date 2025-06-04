package V1;

import java.util.ArrayList;

public abstract class Funcionario {
    protected ArrayList listaPedidos = new ArrayList();
    private Funcionario funcionarioSuperior;

    public Funcionario getFuncionarioSuperior() {
        return funcionarioSuperior;
    }

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
                return funcionarioSuperior.validarEtapaPedido(pedido);
            }
            else {
                return "Sem proxima etapa";
            }
        }
    }


}
