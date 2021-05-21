package Collections.Necklace.Stones;

import java.util.Objects;

public class Stones {
    private final int price;
    private final double weight;

    public Stones(int price, double weight) {
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Stones{" +
                "price=" + price +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stones stones = (Stones) o;
        return price == stones.price && weight == stones.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, weight);
    }
}
