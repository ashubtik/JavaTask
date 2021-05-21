package Collections.Necklace.Stones.Precious;

import Collections.Necklace.Properties.EmeraldCut;

import java.util.Objects;

public class Emerald extends PreciousStones {
    private final EmeraldCut cut;

    public Emerald(int price, double weight, int clarity, EmeraldCut cut) {
        super(price, weight, clarity);
        this.cut = cut;
    }

    @Override
    public String toString() {
        return "Emerald{" +
                "price=" + getPrice() +
                ", clarity=" + getClarity() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Emerald emerald = (Emerald) o;
        return cut == emerald.cut;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cut);
    }
}
