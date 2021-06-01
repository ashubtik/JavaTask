package collections.Taxi.Cars;

import collections.Taxi.Properties.CarBody;

import java.util.Objects;

public class Premium extends Car {
    private final CarBody body;

    public Premium(String model, int maxSpeed, double fuelConsumption, int price, CarBody body) {
        super(model, maxSpeed, fuelConsumption, price);
        this.body = body;
    }

    @Override
    public String toString() {
        return "Premium{" +
                "model='" + model + '\'' +
                ", fuelConsumption=" + getFuelConsumption() +
                ", maxSpeed=" + getMaxSpeed() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Premium that)) return false;
        if (!super.equals(o)) return false;
        return body == that.body;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), body);
    }
}
