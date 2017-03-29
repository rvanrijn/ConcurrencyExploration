# ConcurrencyExploration
Exploration of the java.util.concurrency package


# BlockingQueue Implementations

Since BlockingQueue is an interface, you need to use one of its implementations to use it. The java.util.concurrent package has the following implementations of the BlockingQueue interface (in Java 6):

* ArrayBlockingQueue

This class provides bounded blocking FIFO queue backed by an array. The capacity is defined during instantiating this class. The fairness policy can also be set during creation. By default, this class is unfair. Elements are inserted at the tail of the queue. This class implements BlockingQueue interface and exists since Java 5.

* DelayQueue

This class provides unbounded blocking queue of elements that implement Delayed interface. Only the elements whose delay has expired can be removed from this blocking queue. The element whose delay has expired furthest in the past is at the head of the queue. If there are no elements with delay expired the poll method returns null. This class implements BlockingQueue interface and exists since Java 5.

* LinkedBlockingQueue

This class provided optionally bounded blocking FIFO queue based on linked nodes. It implements BlockingQueue interface and exists since Java 5.

* PriorityBlockingQueue

This class provides unbounded and thread-safe priority queue implementation. Ordering of elements with equal priority is not taken care by this class and a custom comparator needs to be defined to take care of this. This class implements BlockingQueue interface and exists since Java 5.

* SynchronousQueue

This class provides a blocking queue with zero capacity – an empty collection. It acts as a channel to handoff the element from producer to consumer. The insert operation in this queue waits for the the corresponding remove operation and vice-versa. The peek operation cannot be performed on this queue. This class implements BlockingQueue interface and exists since Java 5.