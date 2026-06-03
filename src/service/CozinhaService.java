package service;

import domain.Pedido;

public class CozinhaService {
    public void iniciarPreparo(Pedido pedido){
        System.out.println("Enviando pedido " + pedido.getId() +  " para o painel da cozinha");
    }
}
