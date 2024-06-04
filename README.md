
# Spring Boot com Apache Kafka + Apache Zookeeper e Docker

Projeto desenvolvido para a cadeira de programacao distribuida e paralela do curso de ciencias da computacao, trabalhando com paralelismo e clusterizacao visando atingir um maior tempo de resposta da aplicacao



## Classes

Este projeto conta com as seguintes classes para o funcionamento da aplicacao:

- KafkaConsumerConfig
- KafkaConsumer
- KafkaController
- KafkaProducer


## Deploy

Para fazer o deploy deste projeto execute o docker-compose.yml para criar a imagem ja configurada do apache kafka junto ao zookeeper:

```bash
  docker-compose up -d
```

Apos iniciar o container , acesse o bash do container atraves do terminal do docker pelo comando:

```bash
docker exec -it kafka bash
```

A aplicacao em questao trabalha com a criacao de particoes visando o paralelismo e a clusterizacao, para isso temos que executar um comando para criar nosso topico e quantas particoes ele deve ter:

```bash
kafka-topics --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1 
```

Voce pode configurar livremente o nome do topico, o endereco do seu local host e o numero de particoes, caso deseje testar de outras formas.




## Documentação da API

#### Envia mensagem para o servico do kafka

```http
  POST /publish
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `key` | `string` | Flag de identificacao|
| `Value` | `string` | Mensagem para enviar para o topico |

Fazendo isso, o servico do kafka recebe sua mensagem e de acordo com a mensagem recebida, pode executar alguma regra de negocio. Para isso use as classes KafkaTemplate e KafkaConsumer

