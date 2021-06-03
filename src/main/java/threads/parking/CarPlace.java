package threads.parking;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CarPlace extends Place {
    private final int PlaceNumber;

    public CarPlace(int placeNumber) {
        this.PlaceNumber = placeNumber;
    }

    @Override
    public void standing() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(30));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "carPlace {#" + PlaceNumber +
                '}';
    }
}
