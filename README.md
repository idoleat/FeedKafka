# FeedKafka

A producer feeds data to Kafka cluster as fast as possible. Using Gradle as build tool.

## How to run

`./gradlew run args='--topic [topic name] --brokers [broker IP] --records [record amount] --recordSize [size of a record]'`

Check `./app/build.gradle` for dependencies.

## How to build a fat-jar

`./gradlew shadowJar`
This bundle all the dependencies into one fat-jar in /app/libs/FeedKafka.jar. 

use `java -jar FeedKafka.jar --topic [topic name] --brokers [broker IP] --records [record amount] --recordSize [size of a record]` to run.

## Note
I do want to study how to make producers send data to brokers fast, but during the time I scheduled for this course I got a harsh relationship issue. It's also impossible to delay cause there are more exams and projects after this. It's even impossible to delay further more cause grades need to be sent to the system. So this is the best I can do this time. I hope I can comback with a better form later.
