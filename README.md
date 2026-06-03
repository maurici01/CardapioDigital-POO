**Integrantes: Adailton da Cruz Silva Júnior, Ítalo Cecconi Teixeira Gomes, Lucas de Oliveira Ferreira dos Santos e Maurício Gabriel Souza de Jesus.**

**Padrão escolhido: Command.**

**Requisitos para rodar o projeto:**

* Java SDK 25 (Não testado em versões inferiores)
* Ter uma IDE com suporte para Java (Eclipse, IntelliJ, etc) de sua preferência.

**Problema Proposto:**

Um sistema de cardápio digital, em que sua classe de serviço é responsável pelo fluxo de pedidos (PedidoService) esta atuando como uma God Class.

Ela centraliza as chamadas condicionais para processar pagamentos, enviar preparos para a cozinha e gerenciar o estoque em caso de cancelamento.

Isso gera um alto acoplamento, tornando a adição de novas ações custosa e viola os princípios Aberto/Fechado(OCP) e de Responsabilidade Única (SRP).



**Como o padrão resolve o problema apresentado:**

A solução inicia era inadequada porque o serviço central de pedidos precisava conhecer e importar todos os serviços auxiliares(estoque, pagamento, cozinha), ferindo o princípio Aberto/Fechado (OCP) e gerava alto acoplamento.

Ao aplicar o Invoker no (GerenciadorDeAcoesPedido) a classe agora depende apenas da interface genérica (Command).

Se uma nova ação surgir, basta apenas criar uma nova classe que implemente a interface (Command), sem a necessidade de alterar o código ou criar do Invoker(GerenciadorDeAcoesPedido) ou criar novos fluxos condicionais (if/else)


**Evolução: Uso de Reflection e Anotações Customizadas**

Para elevar o nível de desacoplamento e automatizar o registro dos comandos, o projeto foi evoluído utilizando metaprogramação.

* **Anotação customizada (@AcaoDoCommand):** Criamos uma anotação própria para "taguear" as classes concretas de comando. Ela atua como metadado que vincula a classe à sua respectiva ação em texto EX: @AcaoDoCommand(nomeAcao = "Pagar")
* **Fábrica Dinâmica com Reflection:** Desenvolvemos uma "FabricaDeComandos" que utiliza a API *Reflection* do Java. Em tempo de execução, ele lê as classes, identifica quais possuem a anotação e as instancias dinamicamente usando "newInstance()" de acordo com a solicitação do usuário

**Como isso reduz ainda mais acoplamento**

Na implementação clássica do padrão Command, o código cliente a classe "Main" ainda precisa conhecer e instanciar manualmente cada comando usando a palavra-chave new. 
Ao unirmos anotações e reflection, criamos um mecanismo de injeção dinâmico. O sistema descobre e constrói as ações em tempo de execução, eliminando totalmente a dependência de compilação entre o cliente e as classes concretas.