# Bug #4: Acesso indevido à lista de produtos pela URL sem endpoint

## Descrição
Ao remover o caminho `/add` da URL de produtos (`/products/`), o sistema retorna uma lista contendo todos os dados 
dos produtos.

## Comportamento Esperado
O sistema deve exibir um erro 400 (Bad Request) e não permitir o acesso à lista de produtos. 
A listagem de produtos deve ser permitida apenas para o método GET.

## Comportamento Atual
O sistema está retornando um código 200 (OK) e exibindo a lista de todos os produtos.

## Passos para Reproduzir
1. Acesse a URL `{base_url}/products/`, observando em ajustar o método para POST.
2. Observe que o sistema retorna a lista de produtos com status 200.

## Captura de Tela
![BUG-04.png](..%2FXX%20-%20pictures%2FBUG-04.png)

## Ambiente
- API: `{base_url}/auth/products`
- Data e Hora do Teste: 09/09/2024
- Software utilizado: Postman

## Observações
Esse comportamento pode expor informações sensíveis de produtos inadvertidamente. Sugere-se uma verificação adicional 
da URL e a implementação de uma resposta apropriada para requisições não conformes.