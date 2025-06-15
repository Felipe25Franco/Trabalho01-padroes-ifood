public class FuncionarioAtendente extends Funcionario{
    public FuncionarioAtendente(Funcionario superior) {
        listaPedidos.add(TipoPedidoSolicitado.getTipoPedidoSolicitado());
        setFuncionarioSuperior(superior);
    }
    public String getDescricaoCargo() {
        return "Atendente";
    }

}
