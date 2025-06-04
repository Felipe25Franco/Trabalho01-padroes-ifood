package V1;

public class FuncionarioCozinheiro extends Funcionario {
    public FuncionarioCozinheiro(Funcionario superior) {
        listaPedidos.add(TipoPedidoEmPreparo.getTipoPedidoEmPreparo());
        listaPedidos.add(TipoPedidoPronto.getTipoPedidoPronto());
        setFuncionarioSuperior(superior);
    }

    public String getDescricaoCargo() {
        return "Cozinheiro";
    }
}