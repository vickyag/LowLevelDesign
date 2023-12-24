package Timer;

import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {

    private final Timer timer;

    public TimerExample(){
        timer = new Timer();
    }
    public void timerExample(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack);
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                stack.pop();
                System.out.println(stack);
            }
        }, 2000);

        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                stack.push(3);
                System.out.println(stack);
            }
        }, 1000);

        System.out.println(stack);
    }

}
