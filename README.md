# SOLUTION MESSAGE ROUTER

This repository shows the behaviour related with mechanism to route messages based on a routing key.

To illustrate this kind of behaviour, this implementation was using RabbitMQ as a queue provider. RabbitMQ provides exchange mechanism which could be used in order to manage it. In case we are using a different messaging mechanism not allowing routing, it could be done with an artifact in the middle forwarding messages to the specific location.

## How to start it locally

Prerequisites
* Java 17
* Maven 
* Docker

How to start it:

Step 1: Build project jar file

```shell
mvn clean package
```

Step 2: Launch compose

```shell
cd docker
docker-compose -f docker-compose.yml up
```

## How to check behaviour

Once application is started, we can see local RabbitMQ admin tool at this localtion: http://localhost:15672 . It will be the admin tool for Rabbit MQ (user: guest/user: guest)

At this point everything will be up and running. Then it's the momento to check it's possible to send using the same exchange and with different routing key and those message will be delivered to different queues.

There are two endpoints:

1. One to receive information about a car and forward it to the exchange using the routing key `car`
2. One to receive information about a person and forward it to the exchange using the routing key `person`.

Once the endpoints are defined the way to check the are running, it calling the API using CURL like those.

For car endpoint:

```shell
curl --location 'localhost:8080/api/data/car' \
--header 'Content-Type: application/json' \
--data '{
    "id": "96fb1164-e274-4440-8377-7296773ba08d",
    "trademark": "Opel",
    "model": "Vectra",
    "year": "2001",
    "cv": "140",
    "price": 23000,
    "notes": "Diesel car with some electric issues."
}'
```

For person endpoint:

```shell
curl --location 'localhost:8080/api/data/person' \
--header 'Content-Type: application/json' \
--data '{
    "id": "96fb1164-e274-4440-8377-7296773ba08d",
    "name": "Pedro",
    "surname": "Rodriguez",
    "phone": "555-555-555",
    "age": 34,
    "notes": "Software developer sinde 2017",
    "address": "Calle Ancha del Mar",
    "gender": "Male"
}'
```