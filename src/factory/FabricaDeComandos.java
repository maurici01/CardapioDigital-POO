package factory;

import command.Command;
import command.annotations.AcaoDoCommand;
import domain.Pedido;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class FabricaDeComandos {

    private Map<String, Class<? extends Command>> comandosRegistrados = new HashMap<>();

    public void registrarComando(Class<? extends Command> classeComando){
        if(classeComando.isAnnotationPresent(AcaoDoCommand.class)){
            AcaoDoCommand anotacao = classeComando.getAnnotation(AcaoDoCommand.class);
            String acao = anotacao.nomeAcao().toUpperCase();
            comandosRegistrados.put(acao, classeComando);
            System.out.println("Registro Automático (Reflection): Comando" + acao + " mapeado para" + classeComando.getSimpleName());
        }
    }

    public Command criarComando(String nomeAcao, Object receveir, Pedido pedido) throws Exception {
        Class<? extends Command> classeComando = comandosRegistrados.get(nomeAcao.toUpperCase());
        if (classeComando != null) {
            Constructor<?> constructor = classeComando.getConstructors()[0];

            return (Command) constructor.newInstance(receveir, pedido);
        }
        throw new IllegalArgumentException("Ação não suportada ou não mapeada");
    }

}
