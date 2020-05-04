# Documentação - Teste Wipro
### Observações:  
- Foi utilizado autenticação do tipo Basic Auth para realizar as requisições, e os dados do Usuário Cadastrado são:
Login: alexandre
Senha: teste1

- Consideramos que Status True = Ativo e Status False = Inativo
- Todas as Requisições possuem um limite de 5 Registros por página, respeitando o padrão Lazy Loading

### Segue os Endpoints referentes as requisições solicitadas:

### /produtos/cadastro
Realiza o Cadastro de um Produto passando no corpo da Requisição:
- descricao
- valorUnitario
- status
- usuario -> Código do Usuário, que no caso é 1

### /produtos/ativos
Retorna todos os produtos com status TRUE, ou seja, todos os produtos ATIVOS.

### /produtos/inativos
Retorna todos os produtos com status FALSE, ou seja, todos os produtos INATIVOS.

### /produtos/edicao/{codigo}
Realiza a alteração de um produto, passando o código do produto que você deseja alterar, e atualiza os dados dele, baseado nos dados que estão no corpo da Requisição:
- descricao
- valorUnitario
- status
- usuario -> Código do Usuário, que no caso é 1

### /produtos/inativacao/{codigo}
Realiza a inativação de um produto, passando o código do produto que você deseja inativar.

### /produtos/{codigo}
Realiza a busca de um produto, passando o código deste produto que você deseja encontrar.

### /exclusao/{codigo}
Realiza a exclusão de um produto, passando o código deste produto que você deseja excluir.

### Tecnologias e Ferramentas Utilizadas
- Java 11
- Spring Boot 2.2.6
- Spring Data JPA
- Spring Security
- Banco H2
- Maven
- Flyway
- Lombok