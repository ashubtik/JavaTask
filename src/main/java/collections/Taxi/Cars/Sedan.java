package collections.taxi.cars;

import collections.taxi.properties.Coverage;

import java.util.Objects;

public class Sedan extends Car {
    private final Coverage coverage;

    public Sedan(String model, int maxSpeed, double fuelConsumption, int price, Coverage coverage) {
        super(model, maxSpeed, fuelConsumption, price);
        this.coverage = coverage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sedan sedan = (Sedan) o;
        return coverage == sedan.coverage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coverage);
    }

    @Override
    public String toString() {
        return "Sedan{" +
                "model='" + model + '\'' +
                ", fuelConsumption=" + getFuelConsumption() +
                ", maxSpeed=" + getMaxSpeed() +
                '}';
    }
}
