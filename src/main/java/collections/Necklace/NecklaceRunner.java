package collections.necklace;

import collections.necklace.properties.EmeraldCut;
import collections.necklace.properties.PearlColor;
import collections.necklace.stones.Precious.Diamond;
import collections.necklace.stones.Precious.Emerald;
import collections.necklace.stones.Semiprecious.Pearl;
import collections.necklace.stones.Stones;

import java.util.Arrays;
import java.util.List;

public class NecklaceRunner {
    static List<Stones> gems = Arrays.asList(
            new Diamond(1300, 0.54, 2, 3),
            new Diamond(1150, 0.42, 3, 6),
            new Diamond(980, 0.42, 5, 8),
            new Diamond(1420, 0.56, 2, 2),
            new Diamond(5200, 1.52, 1, 1),
            new Emerald(760, 0.45, 5, EmeraldCut.PRINCESS),
            new Emerald(890, 0.45, 2, EmeraldCut.ROUND),
            new Emerald(990, 0.53, 3, EmeraldCut.ROUND),
            new Pearl(180, 1.60, 3, PearlColor.WHITE),
            new Pearl(170, 1.60, 2, PearlColor.WHITE),
            new Pearl(290, 1.9, 3, PearlColor.BLACK)
    );

    public static void main(String[] args) {
        int totalNecklacePrice = gems.stream()
                .mapToInt(Stones::getPrice)
                .sum();
        System.out.println("$" + totalNecklacePrice);

        double totalNecklaceWeight = gems.stream()
                .mapToDouble(Stones::getWeight)
                .sum();
        System.out.println(totalNecklaceWeight + " ct");

        Necklace necklace = new Necklace(gems);
        Necklace stonesSortedByPrice = new Necklace(necklace.getStone());
        System.out.println(stonesSortedByPrice
                .sortByPrice()
                .toString());

        Necklace certainClarity = new Necklace(necklace.getPreciousStone());
        System.out.println("Gems with clarity > 4 are " + certainClarity
                .getCertainClarity()
                .toString());
    }
}
