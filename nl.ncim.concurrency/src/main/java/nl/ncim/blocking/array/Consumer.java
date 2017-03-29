package nl.ncim.blocking.array;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Consumer implements Runnable {

    private final static Logger LOGGER = Logger.getLogger(Consumer.class.getName());


    private final BlockingQueue<UserMessage> queue;

    public Consumer(BlockingQueue<UserMessage> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {


        try {
            while (!Thread.currentThread().isInterrupted()) {
                final UserMessage user = queue.take();

                System.out.printf("\n [%s] - Take object = %s%n",
                       Thread.currentThread().getName(), user.getMsg() + " \n");
                System.out.printf("\n Current queue size: "+ queue.size());
            }
        } catch (Exception e) {
            System.out.printf("Interrupted" + e);
        }
    }
}