package nl.ncim.blocking.synchronous;

import java.util.concurrent.SynchronousQueue;

class QueueConsumer implements Runnable {

    private SynchronousQueue queue;

    public QueueConsumer(SynchronousQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String event = (String) queue.take();
            // thread will block here
            System.out.printf("[%s] consumed event : %s %n", Thread
                    .currentThread().getName(), event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
