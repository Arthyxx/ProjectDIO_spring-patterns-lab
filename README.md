# API de Clientes com Integração ViaCEP

Projeto desenvolvido com **Spring Boot** para gerenciamento de clientes, com integração à API **ViaCEP** para consulta automática de endereços a partir do CEP informado.

## Sobre o projeto

A aplicação permite:

- Cadastrar clientes
- Buscar todos os clientes
- Buscar cliente por ID
- Atualizar dados de um cliente
- Deletar cliente
- Consultar e salvar automaticamente o endereço pelo CEP usando a API do **ViaCEP**

Este projeto foi desenvolvido como parte de um desafio prático da **DIO**, com foco em **Spring Boot**, **consumo de API externa**, **persistência de dados** e **organização em camadas**.

---

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- OpenFeign
- Bean Validation
- H2 Database
- Maven
- Swagger / OpenAPI

---

## Estrutura do projeto

O projeto foi organizado em camadas:

- **controller** → responsável pelos endpoints da API
- **service** → regras de negócio da aplicação
- **repository** → acesso aos dados
- **model** → entidades do sistema

---

## Funcionalidades

### Cliente
- `GET /clientes` → lista todos os clientes
- `GET /clientes/{id}` → busca cliente por ID
- `POST /clientes` → cadastra um novo cliente
- `PUT /clientes/{id}` → atualiza um cliente existente
- `DELETE /clientes/{id}` → remove um cliente

### Integração com ViaCEP
Ao cadastrar ou atualizar um cliente, a aplicação:

1. recebe o CEP enviado no corpo da requisição
2. verifica se esse endereço já está salvo no banco
3. caso não esteja, consulta o endereço na API do **ViaCEP**
4. salva o endereço no banco
5. associa o endereço ao cliente

---

## Exemplo de requisição

### POST `/clientes`

```json
{
  "nome": "Arthur Lima",
  "endereco": {
    "cep": "60421410"
  }
}
```

---

## Exemplo de resposta

```json
{
  "id": 1,
  "nome": "Arthur Lima",
  "endereco": {
    "cep": "60421410",
    "logradouro": "Rua Exemplo",
    "complemento": "",
    "bairro": "Bairro Exemplo",
    "uf": "CE",
    "ibge": "2304400",
    "gia": "",
    "ddd": "85",
    "siafi": "1389"
  }
}
```

---

## Como executar o projeto

### Pré-requisitos

- Java 17+ ou superior
- Maven instalado

### Passos

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/api-clientes-via-cep.git
```

2. Entre na pasta do projeto:

```bash
cd api-clientes-via-cep
```

3. Execute a aplicação:

```bash
mvn spring-boot:run
```

4. A API estará disponível em:

```bash
http://localhost:8080
```

---

## Banco de dados

O projeto utiliza o **H2 Database** em memória para facilitar os testes e o desenvolvimento.

---

## Documentação da API

Com o projeto em execução, a documentação pode ser acessada pelo Swagger/OpenAPI em:

```bash
http://localhost:8080/swagger-ui.html
```

ou, dependendo da configuração:

```bash
http://localhost:8080/swagger-ui/index.html
```

---

## Aprendizados com o projeto

Com este desafio, foi possível praticar:

- criação de API REST com Spring Boot
- organização do projeto em camadas
- uso de repositórios com Spring Data JPA
- integração com API externa usando OpenFeign
- persistência de dados com H2
- validação de dados com Bean Validation

---

## Melhorias futuras

- tratamento global de exceções
- melhoria nos códigos de resposta HTTP
- validação mais completa dos campos
- retorno de mensagens mais descritivas para erros
- testes unitários e de integração

---

## Autor

Desenvolvido por **Arthur Lima** como parte dos estudos em **Spring Boot** e desafios práticos da **DIO**.
