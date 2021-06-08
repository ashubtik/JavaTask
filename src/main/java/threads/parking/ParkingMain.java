package threads.parking;

import threads.car.Car;
import threads.parking.CarPlace;
import threads.parking.Parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ParkingMain {
    public static void main(String[] args) {
        BlockingQueue<CarPlace> blockingQueue = new ArrayBlockingQueue<>(10);

//        Parking<CarPlace> cars = new Parking<>();
//        for (int i = 1; i < 51; i++) {
//            new Car(i, cars).start();
//            try {
//                Thread.sleep(new Random().nextInt(2000));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
