package Collections.Taxi.Cars;

import java.util.Objects;

public class Minivan extends Car{
    private final int passengerCapacity;

    public Minivan(String model, int maxSpeed, double fuelConsumption, int price, int passengerCapacity) {
        super(model, maxSpeed, fuelConsumption, price);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String toString() {
        return "Minivan{" +
                "model='" + model + '\'' +
                ", fuelConsumption=" + getFuelConsumption() +
                ", maxSpeed=" + getMaxSpeed() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Minivan minivan)) return false;
        if (!super.equals(o)) return false;
        return passengerCapacity == minivan.passengerCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengerCapacity);
    }
}
