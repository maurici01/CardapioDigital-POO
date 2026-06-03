Requisitos para rodar o projeto:

* Java SDK 25 (Não testado em versões inferiores)
* Ter uma IDE com suporte para Java (Eclipse, IntelliJ, etc) de sua preferência.

Problema Proposto:

Um sistema de cardápio digital, em que sua classe de serviço é responsável pelo fluxo de pedidos (PedidoService) esta atuando como uma God Class.

Ela centraliza as chamadas condicionais para processar pagamentos, enviar preparos para a cozinha e gerenciar o estoque em caso de cancelamento.

Isso gera um alto acoplamento, tornando a adição de novas ações custosa e viola os princípios Aberto/Fechado(OCP) e de Responsabilidade Única (SRP).



Como o padrão resolve o problema apresentado:

A solução inicia era inadequada porque o serviço central de pedidos precisava conhecer e importar todos os serviços auxiliares(estoque, pagamento, cozinha), ferindo o princípio Aberto/Fechado (OCP) e gerava alto acoplamento.

Ao aplicar o Invoker no (GerenciadorDeAcoesPedido) a classe agora depende apenas da interface genérica (Command).

Se uma nova ação surgir, basta apenas criar uma nova classe que implemente a interface (Command), sem a necessidade de alterar o código ou criar do Invoker(GerenciadorDeAcoesPedido) ou criar novos fluxos condicionais (if/else)