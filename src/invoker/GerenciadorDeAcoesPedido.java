package invoker;

import command.Command;

public class GerenciadorDeAcoesPedido {
    private Command comando;

    public void setComando(Command comando) {
        this.comando = comando;
    }

    public void executarComando() {
        if (comando != null) {
            comando.executar();
        }
        else{
            System.out.println("Nenhum comando foi encontrado.");
        }
    }
}
