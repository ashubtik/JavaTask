package threads.parking2;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
    //Car storage
    private BlockingQueue<Boolean> bq;
    private int carNumber;

    public Producer(int carNumber, BlockingQueue<Boolean> bq) {
        super();
        this.bq = bq;
        this.carNumber = carNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void run() {

        try {
            bq.put(true);//If the garage is full, you can’t park, and parking will be blocked
            System.out.println("A car successfully parked" + carNumber);


        } catch (InterruptedException e) {

            e.printStackTrace();


        }
    }
}


