# Backend - Sistema de Intercâmbio

Backend em Java com Spring Boot para o sistema de intercâmbio.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- Spring Security
- SQL Server
- Maven

## Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- SQL Server (local ou remoto)

## Configuração do Banco de Dados

1. Execute o script SQL em `../cria-db.sql` no seu SQL Server
2. Configure as credenciais do banco no arquivo `src/main/resources/application.properties`

## Instalação e Execução

1. Clone o repositório
2. Navegue até a pasta do backend:
   ```bash
   cd backend
   ```

3. Compile o projeto:
   ```bash
   mvn clean compile
   ```

4. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

O servidor estará disponível em `http://localhost:8080`

## Endpoints da API

### Usuários
- `GET /api/usuarios` - Listar todos os usuários
- `GET /api/usuarios/{id}` - Buscar usuário por ID
- `GET /api/usuarios/email/{email}` - Buscar usuário por email
- `POST /api/usuarios` - Criar novo usuário
- `PUT /api/usuarios/{id}` - Atualizar usuário
- `DELETE /api/usuarios/{id}` - Deletar usuário

### Senhorios
- `GET /api/senhorios` - Listar todos os senhorios
- `GET /api/senhorios/ativos` - Listar senhorios ativos
- `GET /api/senhorios/pais/{pais}` - Buscar senhorios por país
- `GET /api/senhorios/{id}` - Buscar senhorio por ID
- `POST /api/senhorios` - Criar novo senhorio
- `PUT /api/senhorios/{id}` - Atualizar senhorio
- `DELETE /api/senhorios/{id}` - Deletar senhorio

## Estrutura do Projeto

```
src/main/java/com/intercambio/
├── BackendApplication.java
├── config/
│   └── SecurityConfig.java
├── controller/
│   ├── UsuarioController.java
│   └── SenhorioController.java
├── dto/
│   ├── UsuarioDTO.java
│   └── SenhorioDTO.java
├── entity/
│   ├── Usuario.java
│   ├── Senhorio.java
│   └── Escola.java
├── repository/
│   ├── UsuarioRepository.java
│   ├── SenhorioRepository.java
│   └── EscolaRepository.java
└── service/
    ├── UsuarioService.java
    └── SenhorioService.java
```

## Configurações

### application.properties
```properties
# Database Configuration
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=bd_intercambio;encrypt=true;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=YourPassword123
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect

# Server Configuration
server.port=8080

# CORS Configuration
spring.web.cors.allowed-origins=http://localhost:5173
spring.web.cors.allowed-methods=GET,POST,PUT,DELETE,OPTIONS
spring.web.cors.allowed-headers=*
```

## Desenvolvimento

Para desenvolvimento, você pode usar:
- IntelliJ IDEA
- Eclipse
- VS Code com extensões Java

## Build para Produção

```bash
mvn clean package
```

O arquivo JAR será gerado em `target/backend-0.0.1-SNAPSHOT.jar`

## Executar JAR

```bash
java -jar target/backend-0.0.1-SNAPSHOT.jar
``` 