package nl.ncim.blocking.array;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;


public class BlockingQueueExample {

    public static void main(String[] args) throws Exception {

        BlockingQueue<UserMessage> queue = new ArrayBlockingQueue<>(5, true);
        final List<Runnable> runnables = Arrays.asList(
                new Producer(queue),
                new Producer(queue),
                new Consumer(queue),
                new Consumer(queue),
                new Consumer(queue)
        );

        final List<Thread> threads = runnables
                .stream()
                .map(runnable -> new Thread(runnable, threadName(runnable)))
                .peek(Thread::start)
                .collect(toList());

        TimeUnit.SECONDS.sleep(5);
        threads.forEach(Thread::interrupt);

    }

    private static String threadName(Runnable runnable) {
        return runnable.getClass().getSimpleName() + "-" + System.identityHashCode(runnable);
    }
}