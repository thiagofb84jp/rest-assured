# Melhoria #1: Realizar a validação de segurança para criação de novos produtos

## Descrição
Atualmente, para a criação de novos produtos, não há nenhuma validação de segurança. A sugestão é implementar a 
necessidade de token de autenticação para a criação de produtos, da mesma forma que já ocorre na consulta de produtos. 
Essa melhoria ajudaria a aumentar a segurança no sistema, evitando que produtos sejam criados sem autorização adequada.

## Comportamento Esperado
Ao realizar a requisição de criação de um novo produto, o sistema deve solicitar um token de autenticação válido 
para permitir a operação. A requisição sem um token ou com token inválido deve retornar uma mensagem de erro 
informando a falta de autorização.

## Comportamento Atual
Atualmente, a criação de novos produtos pode ser realizada sem a necessidade de autenticação, o que permite que 
qualquer usuário faça isso sem verificação de segurança.

## Passos para Reproduzir
1. Acesse a URL de criação de produtos: `{base_url}/products/add`.
2. Envie uma requisição POST com os dados de um novo produto sem um token de autenticação.
3. Observe que o produto é criado sem qualquer validação de segurança.

## Captura de Tela
![MEL-01.png](..%2FXX%20-%20files%2FMEL-01.png)

## Ambiente
- API: `{base_url}/products/add`
- Data e Hora do Teste: 09/09/2024
- Software utilizado: Postman
- Sistema Operacional: Linux Ubuntu 22.10
- Versão do Sistema: API de Produtos - v1.2.0