package threads.parking;

import threads.car.Car;
import threads.exception.NoPlaceException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking<T extends Place> {
    private final static int totalCarPlaces = 10;
    private final Semaphore semaphore = new Semaphore(totalCarPlaces, true);
    private final ArrayList<T> places = new ArrayList<>();

    public Parking(List<T> source) {
        places.addAll(source);
    }

    public T getPlace(Car car, int maxTimeWait)
            throws NoPlaceException {
        try {
            if (semaphore.tryAcquire(maxTimeWait, TimeUnit.SECONDS)) {
                for (T place : places) {
                    if (!place.isOccupied()) {
                        place.takePlace(true);
                        System.out.println("Car " + car.getCarNumber() + " has occupied " + place);
                        return place;
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        throw new NoPlaceException("time is up " + maxTimeWait);
    }

    public void releasePlace(Car car, T place) {
        place.takePlace(false);
        System.out.println("Car " + car.getCarNumber() + " has released " + place);
        semaphore.release();
    }
}
