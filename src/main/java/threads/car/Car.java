package threads.car;

import threads.exception.NoPlaceException;
import threads.parking.CarPlace;
import threads.parking.Parking;

public class Car extends Thread {
    private final int carNumber;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }



    public int getCarNumber() {
        return carNumber;
    }

//    public void run() {
//        CarPlace car = null;
//        try {
//            car = parking.getPlace(this, 5);
//            car.standing();
//        } catch (NoPlaceException e) {
//            System.err.println("Car " + this.getCarNumber() + e.getMessage());
//        } finally {
//            if (car != null) {
//                parking.releasePlace(this, car);
//            }
//        }
//    }
}
