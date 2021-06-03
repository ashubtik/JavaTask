package collections.necklace;

import collections.necklace.stones.Precious.PreciousStones;
import collections.necklace.stones.Stones;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingDouble;

public class Necklace {
    private final List<? extends Stones> gems;

    public Necklace(List<? extends Stones> gems) {
        this.gems = gems;
    }

    public List<Stones> getStone() {
        List<Stones> allStones = new ArrayList<>();
        for (Stones stones : gems) {
            if (stones != null) {
                allStones.add(stones);
            }
        }
        return allStones;
    }

    public List<PreciousStones> getPreciousStone() {
        List<PreciousStones> preciousStones = new ArrayList<>();
        for (Stones stones : gems) {
            if (stones instanceof PreciousStones) {
                preciousStones.add((PreciousStones) stones);
            }
        }
        return preciousStones;
    }

    public Necklace sortByPrice() {
        gems.sort(comparingDouble(Stones::getPrice));
        return this;
    }

    public List<PreciousStones> getCertainClarity() {
        List<PreciousStones> clarity = new ArrayList<>();
        List<PreciousStones> certainClarity = getPreciousStone();
        for (PreciousStones stones : certainClarity) {
            if (stones.getClarity() > 4) {
                clarity.add(stones);
            }
        }
        return clarity;
    }

    @Override
    public String toString() {
        return "Necklace{" +
                "gems" + gems +
                '}';
    }
}
