# Coffee Bean Controller

Данный микросервис принимает сообщения через брокера Kafka о новом поступлении зерна. 
По gRPC он принимает информацию об обжарке поступившего зерна. 
По REST сервис отдает информацию о количестве остатков зерна и о процентах потери зерна при обжарке.

Пример сообщения для Kafka - [example_message_kafka.json](example_message_kafka.json).
(*country* - страна происхождения, *percentageOfRobusta* - процент робусты, *percentageOfArabica* - процент арабики, *variety* - сорт зерна) Одно сообщение - один мешок зерна.
Имя топика - **DeliveryOfBag**

.proto файл для gRPC - [file.proto](src/main/proto/file.proto) 
(*countOfBags* - количество взятых мешков, *country* - страна происхождения, *outputWeight* - вес на выходе **в граммах**,
*brigadeUUID* - UUID бригады, *variety* - сорт зерна)

В качестве базы данных использован PostgreSQL. Для управления миграциями базы данных использована Liquibase.

Протестировать работу сервиса можно с помощью написанных тестов.

Документация API создана с использованием swagger и представлена по ссылке: http://localhost:8080/swagger-ui/index.html#/

Для запуска сервиса необходимо запустить файл docker-compose.yml из графического интерфейса IDE или командой docker-compose up.

