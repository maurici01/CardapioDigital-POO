package service;

import domain.Pedido;

public class EstoqueService {
    public void cancelarEVoltarAoEstoque(Pedido pedido){
        System.out.println("Cancelando pedido " + pedido.getId() + " e retornando os ingredientes ao estoque.");
    }
}
