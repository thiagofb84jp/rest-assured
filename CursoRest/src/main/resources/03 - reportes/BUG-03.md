# Bug #3: Falta de validação nos campos de criação de produto (rating, stock, price, discountPercentage, thumbnail)

## Descrição
Alguns campos da criação de produto não possuem validação adequada. É possível:
- Informar valores do tipo string no campo "rating" (como "one" ou "foo foo foo").
- Inserir valores negativos no campo "stock" (exemplo: -55).
- Enviar valores inválidos nos campos "price" e "discountPercentage".
- Informar uma URL inválida no campo "thumbnail".

Esses campos devem ser validados para garantir que apenas dados corretos sejam inseridos.

## Comportamento Esperado
O sistema deve validar os campos para garantir:
- O campo "rating" aceita apenas números dentro de um intervalo válido.
- O campo "stock" não aceita valores negativos.
- O campo "price" e "discountPercentage" aceitam apenas valores numéricos válidos.
- O campo "thumbnail" aceita apenas URLs válidas.

O status de resposta esperado ao inserir valores inválidos é 400 (Bad Request).

## Comportamento Atual
Atualmente, o sistema permite:
- Informar strings no campo "rating".
- Inserir valores negativos no campo "stock".
- Aceitar valores inválidos nos campos "price" e "discountPercentage".
- Aceitar URLs inválidas no campo "thumbnail".
  O status de resposta retornado é 201 (Created).

## Passos para Reproduzir
1. Enviar uma requisição POST para o endpoint de criação de produto ((`{base_url}/products/add`)).
2. Nos campos "rating", "stock", "price", "discountPercentage" e "thumbnail", inserir valores inválidos conforme descrito acima.
3. Verificar que a requisição é aceita e o produto é criado com sucesso.

## Captura de Tela
![BUG-03.png](..%2FXX%20-%20pictures%2FBUG-03.png)

## Ambiente
- API: (`{base_url}/products/add`)
- Data e Hora do Teste: 09/09/2024
- Software utilizado: Postman