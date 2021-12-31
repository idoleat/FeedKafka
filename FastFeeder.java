import java.util.Properties;
import java.util.List;
import java.util.Arrays;
import java.lang.Integer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.header.Header;

class FastFeeder {
    public static void main(String args[]) {
        String brokers = "";
        String topic = "";
        int records = 0;
        int recordSize = 0;

        // a bad way to parse argument for sure
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
            case "--brokers":
                brokers = args[i + 1];
                i += 1;
                break;
            case "--topic":
                topic = args[i + 1];
                i += 1;
                break;
            case "--records":
                records = Integer.parseInt(args[i + 1]);
                i += 1;
                break;
            case "--recordSize":
                recordSize = Integer.parseInt(args[i + 1]);
                i += 1;
                break;
            }
        }

        final int size = recordSize;

        Properties props = new Properties();
        props.put("bootstrap.servers", brokers);
        props.put("acks", "0"); // Set acknowledgements for producer requests. all is SLOWWWW
        props.put("retries", 0); // If the request fails, the producer can automatically retry
        props.put("batch.size", 16384); // Specify buffer size in config
        props.put("linger.ms", 500); // Reduce the no of requests less than 0
        props.put("buffer.memory", 33554432); // The buffer.memory controls the total amount of memory available to the
                                              // producer for buffering.
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Header data = new Header() {
            @Override
            public String key() {
                return "";
            }

            @Override
            public byte[] value() {
                return new byte[size];
            }
        };

        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        for (int i = 0; i < records; i++) {
            String key, value;
            key = String.format("key-%06d", i);
            value = String.format("value-%06d", i);
            producer.send(new ProducerRecord<String, String>(topic, null, key, value, Arrays.asList(data)));
        }
        System.out.println("Message sent successfully");

        producer.close();
    }
}
