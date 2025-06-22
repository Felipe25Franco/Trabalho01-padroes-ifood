

public class FuncionarioEntregador extends Funcionario{

    private FuncionarioEntregador() {}

    private static FuncionarioEntregador instance = new FuncionarioEntregador();
    public static FuncionarioEntregador getInstance() {return instance;}
    public FuncionarioEntregador(Funcionario superior) {
        listaPedidos.add(TipoPedidoEmEntrega.getTipoPedidoEmEntrega());
        listaPedidos.add(TipoPedidoEntregue.getTipoPedidoEntregue());
        setFuncionarioSuperior(superior);
    }

    public String getDescricaoCargo(){return "Entregador";}
}
