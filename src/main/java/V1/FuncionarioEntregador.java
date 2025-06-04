package V1;

public class FuncionarioEntregador extends Funcionario {
    public FuncionarioEntregador(Funcionario superior) {
        listaPedidos.add(TipoPedidoEmEntrega.getTipoPedidoEmEntrega());
        listaPedidos.add(TipoPedidoEntregue.getTipoPedidoEntregue());
        setFuncionarioSuperior(superior);
    }

    public String getDescricaoCargo() {
        return "Entregador";
    }
}