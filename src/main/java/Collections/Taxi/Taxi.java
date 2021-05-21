package Collections.Taxi;

import Collections.Taxi.Cars.Car;
import Collections.Taxi.Cars.Premium;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingDouble;

public class Taxi {
    private final List<? extends Car> cars;

    public Taxi(List<? extends Car> cars) {
        this.cars = cars;
    }

    public List<Premium> getPremium() {
        List<Premium> luxury = new ArrayList<>();
        for (Car car : cars) {
            if (car instanceof Premium) {
                luxury.add((Premium) car);
            }
        }
        return luxury;
    }

    public List<Car> getCar() {
        List<Car> allCars = new ArrayList<>();
        for (Car car : cars) {
            if (car != null) {
                allCars.add(car);
            }
        }
        return allCars;
    }

    public Premium getTheFastestPremiumCar() {
        List<Premium> luxury = getPremium();
        Premium theFastestPremiumCar = luxury.get(0);
        for (Premium car : luxury) {
            if (car.getMaxSpeed() > theFastestPremiumCar.getMaxSpeed()) {
                theFastestPremiumCar = car;
            }
        }
        return theFastestPremiumCar;
    }
    public Taxi sortByFuelConsumption() {
        cars.sort(comparingDouble(Car::getFuelConsumption));
        return this;
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
