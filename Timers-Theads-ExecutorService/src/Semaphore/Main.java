package Semaphore;

public class Main {

    public static void main(String... s){
        PrintInOrder printInOrder = new PrintInOrder();
        System.out.println("Without Semaphore Synchronization");
        printInOrder.withoutSemaphore();
        System.out.println("With Semaphore Synchronization");
        printInOrder.withSemaphore();
    }

}
