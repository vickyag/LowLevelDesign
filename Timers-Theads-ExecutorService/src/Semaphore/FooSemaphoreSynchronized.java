package Semaphore;

import java.util.concurrent.Semaphore;

public class FooSemaphoreSynchronized {

    private final Semaphore semaphore1 = new Semaphore(0);
    private final Semaphore semaphore2 = new Semaphore(0);

    public void first() {
        System.out.println("first");
        semaphore1.release();
    }

    public void second() throws InterruptedException {
        semaphore1.acquire();
        System.out.println("second");
        semaphore2.release();
    }

    public void third() throws InterruptedException {
        semaphore2.acquire();
        System.out.println("third");
    }

}
