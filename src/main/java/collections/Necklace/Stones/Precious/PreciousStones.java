package collections.necklace.stones.Precious;

import collections.necklace.stones.Stones;

import java.util.Objects;

public class PreciousStones extends Stones {
    private final int clarity;

    public PreciousStones(int price, double weight, int transparency) {
        super(price, weight);
        this.clarity = transparency;
    }

    public int getClarity() {
        return clarity;
    }

    @Override
    public String toString() {
        return "PreciousStones{" +
                "clarity=" + clarity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PreciousStones that = (PreciousStones) o;
        return clarity == that.clarity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clarity);
    }
}
