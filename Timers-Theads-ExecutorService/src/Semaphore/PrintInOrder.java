package Semaphore;

public class PrintInOrder {

    private final Foo foo;
    private final FooSemaphoreSynchronized fooSemaphoreSynchronized;

    public PrintInOrder() {
        this.foo = new Foo();
        this.fooSemaphoreSynchronized = new FooSemaphoreSynchronized();
    }

    public void withoutSemaphore(){

        Runnable first = () -> {
            foo.first();
        };

        Runnable second = () -> {
            foo.second();
        };

        Runnable third = () -> {
            foo.third();
        };

        Thread firstThread = new Thread(first);
        Thread secondThread = new Thread(second);
        Thread thirdThread = new Thread(third);

        secondThread.start();
        firstThread.start();
        thirdThread.start();

        try {
            firstThread.join(); // wait for thread to finish its execution before exiting this method
            secondThread.join();
            thirdThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void withSemaphore(){
        Runnable first = () -> {
            fooSemaphoreSynchronized.first();
        };

        Runnable second = () -> {
            try {
                fooSemaphoreSynchronized.second();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable third = () -> {
            try {
                fooSemaphoreSynchronized.third();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread firstThread = new Thread(first);
        Thread secondThread = new Thread(second);
        Thread thirdThread = new Thread(third);

        secondThread.start();
        firstThread.start();
        thirdThread.start();

        try {
            firstThread.join(); // wait for thread to finish its execution before exiting this method
            secondThread.join();
            thirdThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
