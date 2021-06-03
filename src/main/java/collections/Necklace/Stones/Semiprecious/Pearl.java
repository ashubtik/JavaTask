package collections.necklace.stones.Semiprecious;

import collections.necklace.properties.PearlColor;

import java.util.Objects;

public class Pearl extends SemipreciousStones {
    private final PearlColor color;

    public Pearl(int price, double weight, int solidity, PearlColor color) {
        super(price, weight, solidity);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pearl{" +
                "price=" + getPrice() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pearl pearl = (Pearl) o;
        return color == pearl.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
