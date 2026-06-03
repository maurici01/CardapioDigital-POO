package service;

import domain.Pedido;

public class PagamentoService {
    public void processarPagamento(Pedido pedido){
        System.out.printf("Pagamento Processado de R$%.2f  para o pedido: %s \n", pedido.getValorTotal(), pedido.getId());
    }

}
