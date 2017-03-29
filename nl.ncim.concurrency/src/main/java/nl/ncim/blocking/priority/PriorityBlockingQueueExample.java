package nl.ncim.blocking.priority;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        final ExecutorService service = Executors.newFixedThreadPool(2);
        final BlockingQueue<Document> bqueue = new PriorityBlockingQueue<Document>();
        service.execute(new AddDocumentThread(bqueue));
        service.execute(new PrintDocumentThread(bqueue));
        service.shutdown();
    }
}

