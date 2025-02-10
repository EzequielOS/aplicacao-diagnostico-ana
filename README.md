# Aplicação Diagnóstico Avalia Kids

## 👥 Integrantes do Grupo  

👨‍💻 Rafael Andrade Prado - [@rafael-iftm](https://github.com/rafael-iftm)  
👨‍💻 Lucas José Arantes Silva - [@LucasJoseArantes](https://github.com/LucasJoseArantes)  
👨‍💻 Ezequiel de Oliveira Santana - [@EzequielOS](https://github.com/EzequielOS)  
👩‍💻 Gabriela de Oliveira Ferreira - [@gabrieelaoliv](https://github.com/gabrieelaoliv)  

---

## 📚 Documentações do Projeto  


### 1. 📑 [**Documentação do App Diagnóstico de Introdução**](https://docs.google.com/document/d/1THPYEIUaSC15rjibWeJmcnnHxD8x3AJMOqJuseEhaTo/edit?usp=sharing)  

Detalhes completos sobre o sistema de diagnóstico educacional, incluindo requisitos funcionais, fluxo de usuários e objetivos do projeto. Contém especificações de autenticação, gerenciamento de questões e avaliação dos diagnósticos.  

### 2. 📦 [**Documentação da API e Payloads**](https://docs.google.com/document/d/13IP7fUWq2S4QqGz-Dw2eXgu5wZH0xhV3hncvay0K_Nw/edit?usp=sharing)  
Estrutura detalhada dos endpoints RESTful, exemplos de payloads JSON e integração com banco de dados (MongoDB). Descreve autenticação, gestão de questões, respostas, diagnósticos e logs do sistema.  

---


## 🛠️ Como Executar  

### 1. Pré-requisitos  

Certifique-se de ter instalado:  

- [Java 17+](https://adoptium.net/)  
- [Maven](https://maven.apache.org/)  
- [MongoDB](https://www.mongodb.com/try/download/community) ou um container Docker  

---

### 2. Clonando o Repositório  

```sh
git clone https://github.com/EzequielOS/aplicacao-diagnostico-ana.git
cd aplicacao-diagnostico-ana
```

---

### 3. Configuração do Banco de Dados  

#### 3.1 Instalando o MongoDB  

1. Baixe e instale o **MongoDB Community Server**  
   - [Download MongoDB](https://www.mongodb.com/try/download/community)  
   - Escolha a versão adequada e siga as instruções de instalação  

2. (Opcional) Baixe e instale o **MongoDB Compass** para gerenciar o banco visualmente  
   - [Download MongoDB Compass](https://www.mongodb.com/try/download/compass)  

#### 3.2 Iniciando o serviço do MongoDB  

**Windows**  
Abra o **Prompt de Comando** e execute:  

```sh
net start MongoDB
```

**Linux/macOS**  
Execute:  

```sh
sudo systemctl start mongod
```

Verifique se o MongoDB está rodando:  

```sh
mongosh
```

Se tudo estiver correto, você verá a interface interativa do MongoDB.

#### 3.3 Configuração no MongoDB Compass  

1. **Abra o MongoDB Compass**  
2. **Crie uma nova conexão**  
   - Clique em **"New Connection"**  
   - No campo **"URI"**, insira:  

     ```sh
     mongodb://localhost:27017
     ```

   - Clique em **"Connect"**  
3. **Criar um novo banco de dados**  
   - No MongoDB Compass, clique em **"Create Database"**  
   - Defina um nome para o banco e uma coleção inicial  
   - Clique em **"Create Database"** para finalizar  

---

### 4. Executando os Microsserviços  

#### 4.1 Iniciando o Serviço de Autenticação  

```sh
cd auth-app-diagnostico
mvn spring-boot:run
```

#### 4.2 Iniciando o Serviço de Gestão de Questões  

```sh
cd ../questions-app-diagnostico
mvn spring-boot:run
```

---

### 🔗 Documentação da API (Swagger)  

Após iniciar os microsserviços, acesse:  

- **Autenticação**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  
- **Questões**: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)  

## 🎨 Frontend da Aplicação  

O frontend do projeto está disponível no seguinte repositório:  

[🔗 Avalia Kids - Frontend](https://github.com/rafael-iftm/avalia-kids)  

Lá você encontrará instruções detalhadas para instalação e execução da interface do usuário.  
