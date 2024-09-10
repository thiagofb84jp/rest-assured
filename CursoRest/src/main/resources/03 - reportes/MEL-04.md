# Melhoria #4: Implementação de paginação nas APIs de busca de usuários e produtos.

## Descrição
Atualmente, as APIs de busca de usuários e produtos não oferecem suporte para paginação. Mesmo com a exibição dos 
totais e do limite de exibição por página, não há uma funcionalidade de paginação para a consulta via GET. É necessário 
adicionar a capacidade de paginar os itens nas consultas para melhorar a eficiência e usabilidade das APIs.

## Comportamento Esperado
As APIs devem suportar parâmetros de paginação para retornar os resultados de forma paginada. Os parâmetros esperados
incluem:
- `page`: número da página a ser retornada.
- `limit`: número de itens por página.

**Exemplo de parâmetros para paginação:**
- `/users/?page=1&limit=10`
- `/auth/products?page=1&limit=10`

## Comportamento Atual
As APIs retornam todos os itens de uma vez sem paginação, mesmo que haja informações sobre o total de itens e o 
limite de exibição.

## Passos para Reproduzir
1. Consultar a lista de usuários com autenticação:
    - **Endpoint**: `{{base_url}}/users/`
2. Consultar a lista de produtos com autenticação:
    - **Endpoint**: `{{base_url}}/auth/products`
    - **Observação**: É necessário gerar um token de autenticação para o usuário antes de realizar esta consulta.
3. Verificar que ambas as APIs retornam todos os itens de uma vez, sem suporte para paginação.

## Captura de Tela
![MEL-04-01.png](..%2FXX%20-%20files%2FMEL-04-01.png)

![MEL-04-02.png](..%2FXX%20-%20files%2FMEL-04-02.png)

## Ambiente
- API: `{base_url}/auth/users` e `{{base_url}}/auth/products`. O mesmo exemplo pode ser usado para as URIs de Produtos
e Usuários
- Data e Hora do Teste: 09/09/2024
- Software utilizado: Postman
- Sistema Operacional: Linux Ubuntu 22.10
- Versão do Sistema: API de Produtos - v1.2.0

## Observações
- A implementação da paginação deve considerar a inclusão de parâmetros `page` e `limit` para permitir a navegação 
entre páginas de resultados.
- Avaliar se outras APIs da aplicação também necessitam de suporte para paginação para garantir uma consistência no 
comportamento das APIs.