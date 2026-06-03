package command;

import domain.Pedido;
import service.EstoqueService;

public class CancelarPedidoCommand implements Command {
    private EstoqueService estoqueService;
    private Pedido pedido;

    public CancelarPedidoCommand(EstoqueService estoqueService, Pedido pedido) {
        this.estoqueService = estoqueService;
        this.pedido = pedido;
    }
    @Override
    public void executar() {
        estoqueService.cancelarEVoltarAoEstoque(pedido);
    }
}
