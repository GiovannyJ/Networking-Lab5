import java.util.Random;
 
public class Producer implements Runnable {
    private Drop drop;
    private String name;
 
    public Producer(Drop drop, String name) {
        this.drop = drop;
        this.name = name;
    }
 
    public void run() {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };
        Random random = new Random();
 
        for (int i = 0;
             i < importantInfo.length;
             i++) {
            drop.put(importantInfo[i], name);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
        drop.put("DONE", name);
    }
}
