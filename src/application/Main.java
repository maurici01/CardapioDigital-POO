import command.CancelarPedidoCommand;
import command.Command;
import command.PrepararPedidoCommand;
import command.ProcessarPagamentoCommand;
import domain.Pedido;
import factory.FabricaDeComandos;
import invoker.GerenciadorDeAcoesPedido;
import service.CozinhaService;
import service.EstoqueService;
import service.PagamentoService;
import service.PedidoService;

void main() {
    try {

        Pedido pedido = new Pedido("Pedido-5574", 55.90);

        PagamentoService pagamentoService = new PagamentoService();
        CozinhaService cozinhaService = new CozinhaService();
        EstoqueService estoqueService = new EstoqueService();

        FabricaDeComandos fabrica = new FabricaDeComandos();
        fabrica.registrarComando(ProcessarPagamentoCommand.class);
        fabrica.registrarComando(PrepararPedidoCommand.class);
        fabrica.registrarComando(CancelarPedidoCommand.class);

        GerenciadorDeAcoesPedido gerenciador = new GerenciadorDeAcoesPedido();

        Command comandoPagar = fabrica.criarComando("PAGAR", pagamentoService, pedido);
        gerenciador.setComando(comandoPagar);
        gerenciador.executarComando();

        Command comandoPreparar = fabrica.criarComando("PREPARAR", cozinhaService, pedido);
        gerenciador.setComando(comandoPreparar);
        gerenciador.executarComando();

        Command comandoCancelar = fabrica.criarComando("CANCELAR", estoqueService, pedido);
        gerenciador.setComando(comandoCancelar);
        gerenciador.executarComando();

    } catch (Exception e){
        e.printStackTrace();
    }
}
