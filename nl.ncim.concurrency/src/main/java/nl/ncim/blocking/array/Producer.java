package nl.ncim.blocking.array;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Producer implements Runnable {


    private final static Logger LOGGER = Logger.getLogger(Producer.class.getName());

    private final BlockingQueue<UserMessage> queue;

    private SecureRandom random = new SecureRandom();

    public Producer(BlockingQueue<UserMessage> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                UserMessage userMessage =  new UserMessage(new BigInteger(30, random).toString());
                System.out.printf("\n Thread: "+ Thread.currentThread().getName() + " Producing: " + userMessage.getMsg());
                queue.put(userMessage);
                System.out.printf("\n Current queue size "+ queue.size());
            }
        } catch (Exception e) {
            LOGGER.info("Interrupted" + e);
        }
    }
}