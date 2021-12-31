# FeedKafka

A producer feeds data to Kafka cluster as fast as possible. Using Gradle as
build tool.

## How to run

`./gradlew run args='--topic [topic name] --brokers [broker IP] --records [record amount] --recordSize [size of a record]'`

Check `./app/build.gradle` for dependencies.

## How to build a fat-jar

`./gradlew shadowJar` This bundle all the dependencies into one fat-jar in
/app/libs/shadow.jar. use
`java -jar shadow.jar --topic [topic name] --brokers [broker IP] --records [record amount] --recordSize [size of a record]`
to run.
