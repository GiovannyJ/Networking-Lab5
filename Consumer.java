import java.util.Random;
 
public class Consumer implements Runnable {
    private Drop drop;
    private String name;
 
    public Consumer(Drop drop, String name) {
        this.drop = drop;
        this.name = name;
    }
 
    public void run() {
        Random random = new Random();
        for (String message = drop.take();
             ! message.equals("DONE");
             message = drop.take()) {
            System.out.format("MESSAGE RECEIVED: %s PRODUCED BY: %s CONSUMED BY: %s%n", message, name, drop.producerName);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}
