# centralized-configuration-management


Sample projects to show how to use _Centralized Configuration Management_ in a microservice system with Go and Java applications.

[Read more](https://malike.github.io/Configuration-Management-For-Microservices-And-Distributed-Systems/)

The project contains :

1. [go-kafka-alert](https://github.com/malike/go-kafka-alert). Which is a reactive application written in Go. That sends emails and sms
notifications based on data in [Apache Kafka](https://kafka.apache.org/)

2. [message-summary](https://github.com/malike/centralized-configuration-mangement/tree/master/message-summary). A sample java micro service to give summary of messages sent by 
`go-kafka-alert`. 

3. A [config server]() to serve as centralized configuration management for the applications in 
`go-kafka-alert` and `message-summary`.

Note : [configuration files](https://github.com/malike/centralized-configuration) can be located in another reposistory.
