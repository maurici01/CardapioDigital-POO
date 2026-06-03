package command;

import command.annotations.AcaoDoCommand;
import domain.Pedido;
import service.CozinhaService;

@AcaoDoCommand(nomeAcao = "PREPARAR")
public class PrepararPedidoCommand implements Command{
    private CozinhaService cozinhaService;
    private Pedido pedido;

    public PrepararPedidoCommand(CozinhaService cozinhaService, Pedido pedido) {
        this.cozinhaService = cozinhaService;
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        cozinhaService.iniciarPreparo(pedido);
    }
}
