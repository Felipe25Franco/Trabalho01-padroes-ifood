

public class FuncionarioCozinheiro extends Funcionario{

    private FuncionarioCozinheiro() {}

    private static FuncionarioCozinheiro instance = new FuncionarioCozinheiro();
    public static FuncionarioCozinheiro getInstance() {return instance;}
    public FuncionarioCozinheiro(Funcionario superior) {
        listaPedidos.add(TipoPedidoEmPreparo.getTipoPedidoEmPreparo());
        listaPedidos.add(TipoPedidoPronto.getTipoPedidoPronto());
        setFuncionarioSuperior(superior);
    }

    public String getDescricaoCargo(){return "Cozinheiro";}
}
