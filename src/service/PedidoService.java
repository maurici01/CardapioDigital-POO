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
        if(tipoAcao.equalsIgnoreCase("PAGAR")){
            pagamentoService.processarPagamento(pedido);
        }else if(tipoAcao.equalsIgnoreCase("PREPARAR")){
            cozinhaService.iniciarPreparo(pedido);
        }else if(tipoAcao.equalsIgnoreCase("CANCELAR")){
            estoqueService.cancelarEVoltarAoEstoque(pedido);
        }else{
            System.out.println("Ação invalida");
        }
    }
}
