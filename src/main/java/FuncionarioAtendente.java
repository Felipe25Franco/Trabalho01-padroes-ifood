public class FuncionarioAtendente extends Funcionario{

    private FuncionarioAtendente() {}

    private static FuncionarioAtendente instance = new FuncionarioAtendente();
    public static FuncionarioAtendente getInstance() {return instance;}
    public FuncionarioAtendente(Funcionario superior) {
        listaPedidos.add(TipoPedidoSolicitado.getTipoPedidoSolicitado());
        setFuncionarioSuperior(superior);
    }
    public String getDescricaoCargo() {
        return "Atendente";
    }

}
