package service;

import domain.Pedido;

public class PedidoService {
    private PagamentoService pagamentoService;
    private CozinhaService cozinhaService;
    private EstoqueService estoqueService;

    public PedidoService() {
        this.pagamentoService = new PagamentoService();
        this.cozinhaService = new CozinhaService();
        this.estoqueService = new EstoqueService();
    }

    public void executarPedido(String tipoAcao, Pedido pedido){
        if(tipoAcao.equalsIgnoreCase("Pagar")){
            pagamentoService.processarPagamento(pedido);
        }else if(tipoAcao.equalsIgnoreCase("Preparar")){
            cozinhaService.iniciarPreparo(pedido);
        }else if(tipoAcao.equalsIgnoreCase("Cancelar")){
            estoqueService.cancelarEVoltarAoEstoque(pedido);
        }else{
            System.out.println("Ação invalida");
        }
    }
}
