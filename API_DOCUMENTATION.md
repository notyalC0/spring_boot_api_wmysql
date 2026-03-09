# Documentação da API Flutter API

## Visão Geral

Esta é uma API REST desenvolvida em Spring Boot para gerenciar carteiras de investimento, contas, transações e moedas. A API é projetada para integração com aplicações Flutter e utiliza autenticação JWT.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal
- **Spring Security**: Autenticação e autorização
- **JWT**: Tokens de autenticação
- **MySQL**: Banco de dados
- **JPA/Hibernate**: ORM

## Configuração

### Banco de Dados

- **URL**: jdbc:mysql://localhost:3306/db
- **Usuário**: root
- **Senha**: admin
- **Driver**: com.mysql.cj.jdbc.Driver

### Segurança

- **Segredo JWT**: Configurado via variável de ambiente `JWT_SECRET` (padrão: my-secret-key)

## Autenticação

A API utiliza autenticação baseada em JWT. Para acessar endpoints protegidos, inclua o token no header `Authorization` como `Bearer <token>`.

### Endpoints de Autenticação

#### POST /auth/login

Realiza login e retorna um token JWT.

**Request Body:**

```json
{
  "email": "string",
  "senha": "string"
}
```

**Response:**

```json
{
  "token": "string"
}
```

#### POST /auth/registrar

Registra um novo usuário.

**Request Body:**

```json
{
  "email": "string",
  "senha": "string",
  "role": "string"
}
```

**Response:** 200 OK ou 400 Bad Request (se email já existe)

## Endpoints da API

### Carteira

#### GET /api/carteira

Lista todas as carteiras do usuário autenticado.

**Response:** Lista de `CarteiraResponse`

### Conta

#### GET /api/conta

Lista todas as contas do usuário autenticado.

**Response:** Lista de `ContaResponse`

#### GET /api/conta/{id}

Obtém uma conta específica por ID.

**Response:** `ContaResponse` ou null se não encontrada

#### POST /api/conta

Cria uma nova conta.

**Request Body:** `ContaRequest`

**Response:** `ContaResponse`

#### PUT /api/conta/{id}

Atualiza uma conta existente.

**Request Body:** `Conta`

**Response:** `Conta`

#### PATCH /api/conta/depositar

Deposita um valor na conta do usuário.

**Request Body:**

```json
{
  "valor": number
}
```

**Response:** `ContaResponse`

#### DELETE /api/conta/{id}

Deleta uma conta.

### Favoritas

#### GET /api/favoritas

Lista todas as favoritas do usuário.

**Response:** Lista de `FavoritasResponse`

#### GET /api/favoritas/{sigla}

Obtém uma favorita específica por sigla.

**Response:** `FavoritasResponse` ou 404

#### POST /api/favoritas

Adiciona uma nova favorita.

**Request Body:** `FavoritasRequest`

**Response:** `FavoritasResponse`

#### PUT /api/favoritas/{sigla}

Atualiza uma favorita existente.

**Request Body:** `FavoritasRequest`

**Response:** `FavoritasResponse`

#### DELETE /api/favoritas/{sigla}

Deleta uma favorita.

### Histórico

#### GET /api/historico

Lista o histórico de transações do usuário.

**Response:** Lista de `HistoricoResponse`

### Moeda

#### GET /api/moeda

Lista todas as moedas disponíveis.

**Response:** Lista de `Moeda`

### Transação

#### POST /api/transacao/comprar

Realiza uma compra de moeda.

**Request Body:** `TransacaoRequest`

**Response:** String de confirmação

#### POST /api/transacao/vender

Realiza uma venda de moeda.

**Request Body:** `TransacaoRequest`

**Response:** String de confirmação

#### POST /api/transacao/carrinho

Processa um carrinho de compras.

**Request Body:** Lista de `TransacaoRequest`

**Response:** String de confirmação

## Modelos/DTOs

### AuthenticationDTO

```json
{
  "email": "string",
  "senha": "string"
}
```

### LoginResponseDTO

```json
{
  "token": "string"
}
```

### RegistroDTO

```json
{
  "email": "string",
  "senha": "string",
  "role": "string"
}
```

### CarteiraRequest

```json
{
  "sigla": "string",
  "moeda": "string",
  "quantidade": number
}
```

### CarteiraResponse

Estrutura baseada no modelo Carteira.

### ContaRequest

```json
{
  "saldo": number
}
```

### ContaResponse

Estrutura baseada no modelo Conta.

### FavoritasRequest

```json
{
  "sigla": "string",
  "nome": "string",
  "icone": "string",
  "valor": number
}
```

### FavoritasResponse

Estrutura baseada no modelo Favoritas.

### HistoricoRequest

Estrutura para histórico.

### HistoricoResponse

Estrutura baseada no modelo Historico.

### TransacaoRequest

```json
{
  "sigla": "string",
  "quantidade": number
}
```

## Executando a Aplicação

1. Certifique-se de que o MySQL está rodando e o banco `db` existe.
2. Configure as variáveis de ambiente se necessário.
3. Execute `mvn spring-boot:run` ou use o wrapper `./mvnw spring-boot:run`.

## Notas

- Todos os endpoints (exceto autenticação e moedas) requerem autenticação JWT.
- Alguns métodos em CarteiraController estão comentados e não disponíveis.
- A API utiliza Spring Security para proteção.</content>
  <parameter name="filePath">c:\Dev\projetos\java\spring_boot_api_wmysql\API_DOCUMENTATION.md
