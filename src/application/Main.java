import command.Command;
import command.PrepararPedidoCommand;
import command.ProcessarPagamentoCommand;
import domain.Pedido;
import invoker.GerenciadorDeAcoesPedido;
import service.CozinhaService;
import service.PagamentoService;
import service.PedidoService;

void main() {

    Pedido pedido = new Pedido("Pedido-5574", 55.90);

    PagamentoService pagamentoService = new PagamentoService();
    CozinhaService  cozinhaService = new CozinhaService();

    Command pagar = new ProcessarPagamentoCommand(pagamentoService, pedido);
    Command preparar = new PrepararPedidoCommand(cozinhaService, pedido);

    GerenciadorDeAcoesPedido gerenciador = new GerenciadorDeAcoesPedido();

    gerenciador.setComando(pagar);
    gerenciador.executarComando();

    gerenciador.setComando(preparar);
    gerenciador.executarComando();
}
