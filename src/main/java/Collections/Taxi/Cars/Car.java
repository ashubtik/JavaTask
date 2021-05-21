package Collections.Taxi.Cars;

import java.util.Objects;

public class Car {
    String model;
    private final int maxSpeed;
    private final double fuelConsumption;
    private final int price;

    public Car(String model, int maxSpeed, double fuelConsumption, int price) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{" +
                "model '" + model + '\'' +
                ", maxSpeed = " + maxSpeed +
                ", consumption = " + fuelConsumption +
                ", price = " + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return maxSpeed == car.maxSpeed && fuelConsumption == car.fuelConsumption && price == car.price && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, fuelConsumption, price);
    }
}
