import org.apache.kafka.clients.producer.KafkaProducer;

class FastFeeder {
    public static void main(String args[]) {
        for (int i = 0; i < args.length; i++)
            System.out.println(args[i]);
    }
}
