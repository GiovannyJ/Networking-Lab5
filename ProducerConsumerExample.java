public class ProducerConsumerExample {
    public static void main(String[] args) {
        //Shared resource
        Drop drop = new Drop();
        
        //PRODUCERS
        (new Thread(new Producer(drop, "Producer 1"))).start();
        (new Thread(new Producer(drop, "Producer 2"))).start();
        (new Thread(new Producer(drop, "Producer 3"))).start();
        
        //CONSUMERS
        (new Thread(new Consumer(drop, "Gio"))).start();
        (new Thread(new Consumer(drop, "Martin"))).start();
        (new Thread(new Consumer(drop, "Angel"))).start();
    }
}
