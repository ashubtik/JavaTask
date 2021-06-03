package threads;

import threads.car.Car;
import threads.parking.CarPlace;
import threads.parking.Parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingMain {
    public static void main(String[] args) {
        List<CarPlace> carPlaces = new ArrayList<CarPlace>() {
            {
                this.add(new CarPlace(1));
                this.add(new CarPlace(2));
                this.add(new CarPlace(3));
                this.add(new CarPlace(4));
                this.add(new CarPlace(5));
                this.add(new CarPlace(6));
                this.add(new CarPlace(7));
                this.add(new CarPlace(8));
                this.add(new CarPlace(9));
                this.add(new CarPlace(10));
            }
        };
        Parking<CarPlace> cars = new Parking<>(carPlaces);
        for (int i = 1; i < 51; i++) {
            new Car(i, cars).start();
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
