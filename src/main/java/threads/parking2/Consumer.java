package threads.parking2;

import threads.car.Car;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
    private BlockingQueue<Boolean> bq;
    private int car;

    public Consumer(int car, BlockingQueue<Boolean> bq) {
        super();
        this.bq = bq;
        this.car = car;
    }
    public void run() {
        try {
            bq.take();
            System.out.println("A car was successfully taken out");
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }
}
