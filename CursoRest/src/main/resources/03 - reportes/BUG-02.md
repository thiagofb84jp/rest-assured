# Bug #2: Produto é criado com sucesso ao enviar requisição sem dados no corpo

## Descrição
Quando uma requisição de criação de produto é enviada sem nenhum dado no corpo do request, a API permite a criação 
do produto com sucesso e retorna apenas o ID do novo produto. 

O comportamento esperado é que o sistema retorne um erro informando a obrigatoriedade dos campos e não crie o produto.

## Comportamento Esperado
A API deve retornar um erro de validação informando que todos os campos obrigatórios precisam ser preenchidos. E o 
status da resposta deve ser 400 (Bad Request).

## Comportamento Atual
A API cria o produto com sucesso e retorna um status 201 (Created) mesmo sem dados no corpo da requisição, 
retornando apenas o ID.

## Passos para Reproduzir
1. Enviar uma requisição POST (`{base_url}/products/add`) para o endpoint de criação de produto sem fornecer 
nenhum dado no corpo (`{}`).
2. Verificar a resposta do sistema.

## Captura de Tela
![BUG-02.png](..%2FXX%20-%20pictures%2FBUG-02.png)

## Ambiente
- API: `{base_url}/products/add`
- Data e Hora do Teste: 09/09/2024
- Software utilizado: Postman
