package Collections.Necklace.Stones.Precious;

import java.util.Objects;

public class Diamond extends PreciousStones {
    private final int color;

    public Diamond(int price, double weight, int clarity, int color) {
        super(price, weight, clarity);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Diamond{" +
                "price=" + getPrice() +
                ", clarity=" + getClarity() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Diamond diamond = (Diamond) o;
        return color == diamond.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
