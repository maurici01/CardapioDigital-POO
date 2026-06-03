Requisitos para rodar o projeto:

* Java SDK 25 (Não testado em versões inferiores)
* Ter uma IDE com suporte para Java (Eclipse, IntelliJ, etc) de sua preferência.

Problema Proposto:

Um sistema de cardápio digital, em que sua classe de serviço responsável pelo fluxo de pedidos (PedidoService) esta atuando como uma God Class.

Ela centraliza as chamadas condicionais para processar pagamentos, enviar preparos para a cozinha e gerenciar o estoque em caso de cancelamento.

Isso gera um alto acoplamento, tornando a adição de novas ações custosa e viola os princípios Aberto/Fechado(OCP) e de Responsabilidade Única (SRP).