import model.City;
import repository.CityRepo;
import repository.CityRepoImpl;
import service.CityServ;
import service.CityServImpl;
import utils.Utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Optional;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String fileName = System.getProperty("user.dir") + "/resource/cities.csv";
        CityRepo cityRepo = new CityRepoImpl(fileName);
        CityServ cityServ = new CityServImpl(cityRepo);
        System.out.println("Исходный список городов:");
        Utils.printCities(cityServ.getAllCities());
        System.out.println("*".repeat(150));
        System.out.println("Список городов отсортированный по наименованию без учета регистра:");
        Utils.printCities(cityServ.sortCitiesByName());
        System.out.println("*".repeat(150));
        System.out.println("Список городов отсортированный по региону и наименованию:");
        Utils.printCities(cityServ.sortCitiesByDistrictAndName());
        System.out.println("*".repeat(150));
        Optional<City> bigCity = cityServ.getBigCity();
        bigCity.ifPresent(city -> System.out.printf("Город с большим населением:\n%s\n", city));
        System.out.println("*".repeat(150));
        System.out.println("Количество городов в регионах:");
        cityServ.getCitiesByRegion().forEach((x, y) -> System.out.println(MessageFormat.format("{0}: {1}", x, y)));
    }
}