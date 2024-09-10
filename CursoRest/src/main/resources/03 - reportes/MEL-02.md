# Melhoria #2: Atualização da documentação da API para refletir o status correto da criação de token.

## Descrição
Na documentação da API, o status esperado para a criação de um token está definido como `201`. No entanto, ao consumir 
o serviço, o status retornado é `200`. A documentação precisa ser corrigida para refletir o comportamento real da API.

## Comportamento Esperado
O status da resposta para a criação de um token deve estar documentado como `200`.

## Comportamento Atual
Atualmente, a documentação da API descreve o status como `201`, mas o serviço retorna `200`.

## Passos para Reproduzir
1. Acesse a URL de criação de produtos: `{base_url}/auth/products`.
2. Envie uma requisição POST com os dados válidos de usuário e senha.
3. Verificar o status da resposta HTTP.
4. Acessar a documentação no seguinte endereço: https://sicredi-desafio-qe.readme.io/reference/post-auth-login
5. Verificar na documentação o status apresentado no corpo do response.

## Captura de Tela
![MEL-02.png](..%2FXX%20-%20files%2FMEL-02.png)

## Ambiente
- API: `{base_url}/auth/products`
- Data e Hora do Teste: 09/09/2024
- Software utilizado: Postman
- Sistema Operacional: Linux Ubuntu 22.10
- Versão do Sistema: API de Produtos - v1.2.0