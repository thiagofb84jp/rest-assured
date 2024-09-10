# Reporte de Bug

## Título do Bug
Mensagem confusa ao inserir valores inválidos no campo "username"

## Descrição
Ao tentar gerar um token para autenticação, quando valores não-string (inteiros ou booleanos) são inseridos no campo "username", 
o sistema retorna uma mensagem confusa: `"username.toLowerCase is not a function"`. O comportamento correto seria exibir 
uma mensagem clara informando o erro nas credenciais.

## Comportamento Esperado
O sistema deveria retornar a seguinte mensagem ao detectar valores inválidos no campo "username":
```json
{
  "message": "Invalid credentials"
}
```
Lembrando que é preciso que ele retorne erro 400.

## Comportamento Atual
Quando valores como inteiros ou booleanos são inseridos no campo "username", o sistema retorna a seguinte mensagem:
```json
{
"error": "username.toLowerCase is not a function"
}
```
Depois disso, o sistema retorna erro 500.

## Passos para Reproduzir
1. Acesse a URL `{base_url}/auth/login`.
2. No campo "username", insira um valor não-string (por exemplo, um número ou um booleano).
3. Envie a requisição.
4. Observe a mensagem de erro retornada.

## Captura de Tela
![BUG-06.png](..%2FXX%20-%20pictures%2FBUG-06.png)

## Ambiente
- API: `{base_url}/auth/login`
- Data e Hora do Teste: 09/09/2024
- Software utilizado: Postman
- Sistema Operacional: Linux Ubuntu 22.10
- Versão do Sistema: API de Produtos - v1.2.0

## Observações
Aqui estão os valores que podem ser usados para testes:
- username: ``11``
- username: ``true``