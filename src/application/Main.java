import domain.Pedido;
import service.PedidoService;

void main() {

    PedidoService servico = new PedidoService();
    Pedido pedido = new Pedido("Pedido-5574", 55.90);

    servico.executarPedido("Pagar", pedido);
    servico.executarPedido("Preparar", pedido);

}
