# Sistema de Hotel

Este projeto é um sistema de gerenciamento de hotel que utiliza **Spring Boot** para os consumidores e **Python** para os produtores. Ele utiliza o RabbitMQ como sistema de mensageria para comunicação entre os componentes.

## Estrutura do Projeto

- **FCCPD_ULTIMO/ConsApplication**: Consumidores implementados em Java com Spring Boot.
- **FCCPD_ULTIMO/produtor**: Produtores implementados em Python.

## Pré-requisitos

Certifique-se de ter os seguintes softwares instalados:

- **Java 17** ou superior
- **Maven** (ou utilize o wrapper `mvnw` incluído no projeto)
- **Python 3.10** ou superior
- **pip** (gerenciador de pacotes do Python)
- **RabbitMQ** (ou uma conta no [CloudAMQP](https://www.cloudamqp.com/))

---

## Como Rodar o Projeto

### 1. Consumidores (Java)

1. Navegue até o diretório `FCCPD_ULTIMO/ConsApplication`:
   ```sh
   cd FCCPD_ULTIMO/ConsApplication
   ```

2. Compile o projeto com Maven:
   ```sh
   ./mvnw clean install
   ```

3. Execute o consumidor:
   ```sh
   ./mvnw spring-boot:run
   ```

4. Escolha o setor desejado no menu exibido:
   - `1`: Gerência
   - `2`: Secretaria
   - `3`: Auditoria

---

### 2. Produtores (Python)

1. Navegue até o diretório `FCCPD_ULTIMO/produtor`:
   ```sh
   cd FCCPD_ULTIMO/produtor
   ```

2. Instale as dependências do Python:
   ```sh
   pip install pika
   ```

3. Execute o arquivo `main.py` para acessar o menu principal:
   ```sh
   python main.py
   ```

4. Escolha uma das opções no menu:
   - `1`: Nova Reserva
   - `2`: Alteração de Reserva
   - `3`: Emergência
   - `4`: Item Perdido/Encontrado
   - `5`: Relatório Diário
   - `6`: Sair

---

## Testes

### Consumidores

Os testes para os consumidores estão localizados em `FCCPD_ULTIMO/ConsApplication/src/test`. Para rodar os testes, execute:
```sh
./mvnw test
```

### Produtores

Os produtores não possuem testes automatizados, mas você pode testar manualmente executando os scripts Python e verificando as mensagens no RabbitMQ.

---

## Observações

- Certifique-se de que as variáveis de ambiente estão configuradas corretamente para o RabbitMQ, caso utilize um servidor diferente.
- Para mais informações sobre o RabbitMQ, consulte a [documentação oficial](https://www.rabbitmq.com/documentation.html).

---

## Licença

Este projeto é licenciado sob a [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
