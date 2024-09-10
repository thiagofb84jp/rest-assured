# Bug #5: Não há validação de limites para os campos "title", "description", "stock", "price", entre outros

## Descrição
Os campos "title", "description", "stock" e "price" estão permitindo a inclusão de valores acima de 1000 caracteres, 
sem qualquer validação ou tratamento. Isso pode resultar na falha do cadastro desses valores na base de dados.

## Comportamento Esperado
Os campos "title", "description", "stock" e "price" deveriam ter limites definidos para o número de caracteres e 
valores, garantindo que os dados sejam inseridos corretamente na base de dados.

## Comportamento Atual
Atualmente, os valores são aceitos sem validação de tamanho, permitindo a inserção de valores que excedem os limites 
esperados, o que pode causar falhas no cadastro dos produtos.

## Passos para Reproduzir
1. Acesse a URL `{base_url}/products/add`.
2. Preencha os campos "title", "description", "stock" e "price" com valores acima de 1000 caracteres ou limites 
razoáveis.
3. Observe que o sistema aceita os valores e os processa normalmente, sem exibir mensagens de erro ou validação.

## Captura de Tela
![BUG-05.png](..%2FXX%20-%20pictures%2FBUG-05.png)

## Ambiente
- API: `{base_url}/products/add`
- Data e Hora do Teste: 09/09/2024
- Software utilizado: Postman
- Sistema Operacional: Linux Ubuntu 22.10
- Versão do Sistema: API de Produtos - v1.2.0

## Observações
Aqui estão os valores que podem ser usados para testes:
- **price**: `111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.`
- **stock**: `666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666.`
- **description**: `"Of tree fowl man doesn't which grass. Stars all moving fruit god. Fourth very signs that all darkness created a Stars. Let fish was give. Hath. Don't. Land beginning fruitful very life upon may fly to for us. Moving. Us, evening bring cattle bring land Image seas to darkness subdue to. You. Behold You also. Stars good be fish saw waters living fill fly herb waters two..."`
