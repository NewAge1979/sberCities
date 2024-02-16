import repository.CityRepo;
import repository.CityRepoImpl;
import service.CityServ;
import service.CityServImpl;
import utils.Utils;

public class Main {
    public static void main(String[] args) {
        String fileName = System.getProperty("user.dir") + "/resource/cities.csv";
        CityRepo cityRepo = new CityRepoImpl(fileName);
        CityServ cityServ = new CityServImpl(cityRepo);
        System.out.println("Исходный список городов:");
        Utils.printCities(cityServ.getAllCities());
        System.out.println("Список городов отсортированный по наименованию без учета регистра:");
        Utils.printCities(cityServ.sortCitiesByName());
        System.out.println("Список городов отсортированный по региону и наименованию:");
        Utils.printCities(cityServ.sortCitiesByDistrictAndName());
    }
}