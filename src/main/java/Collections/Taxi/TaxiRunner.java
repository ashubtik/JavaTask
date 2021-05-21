package Collections.Taxi;

import Collections.Taxi.Cars.Car;
import Collections.Taxi.Cars.Minivan;
import Collections.Taxi.Cars.Premium;
import Collections.Taxi.Cars.Sedan;
import Collections.Taxi.Properties.CarBody;
import Collections.Taxi.Properties.Coverage;

import java.util.Arrays;
import java.util.List;

public class TaxiRunner {
    static List<Car> cars = Arrays.asList(
            new Sedan("Renault Logan", 160, 7.3, 10000, Coverage.URBAN),
            new Sedan("Volkswagen Polo", 170, 6.9, 13000, Coverage.URBAN),
            new Sedan("Kia Rio", 170, 6.5, 13500, Coverage.COMBINED),
            new Sedan("Honda Jazz", 160, 6.3, 16000, Coverage.URBAN),
            new Sedan("Volkswagen Passat", 190, 7.9, 29000, Coverage.SUBURBAN),
            new Sedan("Tesla Model E", 220, 0.0, 45000, Coverage.COMBINED),
            new Minivan("Ford Galaxy", 180, 8.0, 40000, 6),
            new Minivan("Volkswagen Multivan", 190, 8.5, 50000, 6),
            new Minivan("Volkswagen Caravella", 190, 6.5, 45500, 10),
            new Premium("Hummer H2", 160, 18.3, 70000, CarBody.CROSSOVER),
            new Premium("Lincoln Limousine", 190, 15.9, 75000, CarBody.LIMOUSINE),
            new Premium("BMW z4", 300, 13.0, 90000, CarBody.CABRIOLET)
    );

    public static void main(String[] args) {
        int allCarsCost = cars.stream().mapToInt(Car::getPrice).sum();
        System.out.println("Total cost of all taxi cars = $" + allCarsCost);
        Taxi taxi = new Taxi(cars);
        Taxi sortByFuelConsumption = new Taxi(taxi.getCar());
        System.out.println("Taxi cars sorted by fuel consumption: " + sortByFuelConsumption
                .sortByFuelConsumption()
                .toString());
        Taxi premium = new Taxi(taxi.getPremium());
        System.out.println("The fastest premium car = " + premium.getTheFastestPremiumCar());
    }
}
