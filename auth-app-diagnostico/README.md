# Auth App Diagnóstico

Este projeto é responsável pela autenticação e gerenciamento de usuários dentro do sistema de diagnóstico. Ele fornece endpoints para login, registro e controle de permissões.

---

## Instalação e Execução

### 1. Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [MongoDB](https://www.mongodb.com/try/download/community) ou utilize um container Docker.

---

### 2. Configuração do Banco de Dados

Para que a aplicação funcione corretamente, é necessário configurar o banco de dados MongoDB.

#### 2.1 Instalando o MongoDB

1. **Baixe e instale o MongoDB Community Server**  
   - Acesse: [MongoDB Download Center](https://www.mongodb.com/try/download/community)  
   - Escolha a versão para o seu sistema operacional e instale seguindo as instruções.

2. **Baixe e instale o MongoDB Compass** (opcional, mas recomendado)  
   - Acesse: [MongoDB Compass Download](https://www.mongodb.com/try/download/compass)  
   - Instale para gerenciar o banco de dados visualmente.

#### 2.2 Iniciando o serviço do MongoDB

**Windows**  
Abra o **Prompt de Comando** e execute:

```sh
net start MongoDB
```

**Linux/macOS**  
Inicie o MongoDB com:

```sh
sudo systemctl start mongod
```

Verifique se o MongoDB está rodando executando:

```sh
mongosh
```

Se tudo estiver correto, você verá a interface interativa do MongoDB.

#### 2.3 Configuração no MongoDB Compass

1. **Abra o MongoDB Compass**
2. **Crie uma nova conexão**  
   - Clique em **"New Connection"**  
   - No campo **"URI"**, digite:

     ```sh
     mongodb://localhost:27017
     ```

   - Clique em **"Connect"** para conectar ao banco.

3. **Criar um novo banco de dados**  
   - No MongoDB Compass, clique em **"Create Database"**  
   - Defina um nome para o banco e uma coleção inicial  
   - Clique em **"Create Database"** para finalizar.

---

### 3. Executando a Aplicação

1. Clone o repositório:

   ```sh
   git clone https://github.com/EzequielOS/aplicacao-diagnostico-ana.git
   cd aplicacao-diagnostico-ana/auth-app-diagnostico
   ```

2. Compile e execute a aplicação:

   ```sh
   mvn spring-boot:run
   ```

---

### Documentação da API (Swagger)

Após iniciar a aplicação, acesse:

- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
