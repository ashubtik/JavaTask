package collections.Necklace.Stones.Semiprecious;

import collections.Necklace.Stones.Stones;

import java.util.Objects;

public class SemipreciousStones extends Stones {
    private final int solidity;

    public SemipreciousStones(int price, double weight, int solidity) {
        super(price, weight);
        this.solidity = solidity;
    }

    @Override
    public String toString() {
        return "SemipreciosStones{" +
                "solidity=" + solidity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SemipreciousStones that = (SemipreciousStones) o;
        return solidity == that.solidity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), solidity);
    }
}
