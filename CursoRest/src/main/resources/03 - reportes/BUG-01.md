# Bug #1: Falha de retorno quando o token é inválido

## Descrição
Quando o token fornecido é inválido, a resposta da API é "invalid signature" no corpo do response. 
Ao invés de retornar o erro 401, está sendo gerado erro 500.

## Comportamento Esperado
O sistema deve retornar um erro 401 quando o token é inválido.

## Comportamento Atual
O sistema retorna um erro 500.

## Passos para Reproduzir
1. Cole o token fornecido no campo apropriado para autenticação.
2. Envie a requisição para a API (`{base_url}/auth/products`).
3. Observe a resposta.

## Captura de Tela
![BUG-01.png](..%2FXX%20-%20pictures%2FBUG-01.png)

## Ambiente
- API: `{base_url}/auth/products`
- Data e Hora do Teste: 09/09/2024
- Software utilizado: Postman

## Observações:
### Token de Exemplo
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NywidXNlcm5hbWUiOiJhbGV4YW5kZXJqIiwiZW1haWwiOiJhbGV4YW5kZXIuam9uZXNAeC5kdW1teWpzb24uY29tIiwiZmlyc3ROYW1lIjoiQWxleGFuZGVyIiwibGFzdE5hbWUiOiJKb25lcyIsImdlbmRlciI6Im1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vZHVtbXlqc29uLmNvbS9pY29uL2FsZXhhbmRlcmovMTI4IiwiaWF0IjoxNzI1ODc3OTY5LCJleHAiOjE3MjU4ODE1Njl9.-GaTXHFX-muyO-ZLxHeh8zrlIjqDQUgGLzSRqKF8ms1