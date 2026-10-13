# Agendador

API REST para gerenciamento de clientes, funcionários e serviços, desenvolvida com Spring Boot.

## Requisitos

- Java 25
- O Maven Wrapper incluído no projeto (`mvnw` / `mvnw.cmd`)

Confira a versão do Java instalada:

```bash
java -version
```

## Build

Na raiz do projeto, execute:

**Windows (PowerShell ou Prompt de Comando):**

```powershell
.\mvnw.cmd clean package
```

**Linux ou macOS:**

```bash
./mvnw clean package
```

O comando compila a aplicação, executa os testes e gera o JAR em `target/agendador-0.0.1-SNAPSHOT.jar`.

## Executar em desenvolvimento

Na raiz do projeto, inicie a aplicação com o Maven Wrapper:

**Windows:**

```powershell
.\mvnw.cmd spring-boot:run
```

**Linux ou macOS:**

```bash
./mvnw spring-boot:run
```

A aplicação fica disponível na porta `8080`. Para encerrá-la, use `Ctrl+C` no terminal.

## Executar o JAR

Depois do build, execute:

```bash
java -jar target/agendador-0.0.1-SNAPSHOT.jar
```

## Swagger / OpenAPI

Com a aplicação em execução, acesse a interface interativa do Swagger UI:

[http://localhost:8080/agendador/swagger-ui/index.html](http://localhost:8080/agendador/swagger-ui/index.html)

O documento OpenAPI em JSON está disponível em:

[http://localhost:8080/agendador/v3/api-docs](http://localhost:8080/agendador/v3/api-docs)

Todas as rotas da API usam o prefixo `/agendador`. Por exemplo, a listagem de clientes fica em `GET /agendador/cliente`.

## Banco de dados

A aplicação usa o H2 em arquivo no caminho configurado `~/test`. O Hibernate está configurado com `create-drop`, então o esquema é recriado ao iniciar a aplicação e removido ao encerrá-la.
