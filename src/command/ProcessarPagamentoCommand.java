package command;

import domain.Pedido;
import service.PagamentoService;

public class ProcessarPagamentoCommand implements Command{
    private PagamentoService pagamentoService;
    private Pedido pedido;

    public ProcessarPagamentoCommand(PagamentoService pagamentoService, Pedido pedido){
        this.pagamentoService = pagamentoService;
        this.pedido = pedido;
    }
    @Override
    public void executar() {
        pagamentoService.processarPagamento(pedido);
    }
}
