# Melhoria #3: Definir permissões de acesso para a consulta de produtos na API.

## Descrição
Atualmente, a API permite que qualquer usuário, independentemente de perfil ou permissões, possa acessar a consulta de 
busca de produtos após a autenticação. A sugestão é implementar permissões de acesso, garantindo que apenas usuários 
com perfis específicos possam acessar determinadas partes do sistema, como a listagem de produtos.

## Comportamento Esperado
Apenas usuários com permissões apropriadas (ex.: `admin`, `moderator`) devem ser capazes de acessar a consulta de 
produtos. Usuários com o perfil `user` não devem ter acesso a essa funcionalidade.

## Comportamento Atual
Qualquer usuário autenticado, sem restrições de perfil, pode acessar a busca de produtos.

## Passos para Reproduzir
1. Gerar um token de autenticação para o usuário com a role de `user`:
    - **Endpoint**: `{{base_url}}/auth/login`
    - **Credenciais**:
        - **Username**: `averyp`
        - **Password**: `averyppass`
2. Utilizar o token gerado para buscar produtos:
    - **Endpoint**: `{{base_url}}/auth/products`
3. Verificar que a consulta de produtos está disponível para o usuário com a role `user`, sem restrições de acesso.

## Captura de Tela
![MEL-03-01.png](..%2FXX%20-%20files%2FMEL-03-01.png)

![MEL-03-02.png](..%2FXX%20-%20files%2FMEL-03-02.png)

## Ambiente
- API: `{base_url}/auth/login` e `{{base_url}}/auth/products`
- Data e Hora do Teste: 09/09/2024
- Software utilizado: Postman
- Sistema Operacional: Linux Ubuntu 22.10
- Versão do Sistema: API de Produtos - v1.2.0

## Observações
- Avaliar a criação de perfis com permissões diferenciadas (ex.: `admin`, `user`, `product_manager`) e restringir o acesso de cada endpoint conforme o perfil do usuário.
- Verificar se outras áreas da API também necessitam de restrições semelhantes para garantir a segurança do sistema.