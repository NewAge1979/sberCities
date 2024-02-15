import repository.CityRepo;
import repository.CityRepoImpl;
import service.CityServ;
import service.CityServImpl;

public class Main {
    public static void main(String[] args) {
        String fileName = System.getProperty("user.dir") + "/resource/cities.csv";
        CityRepo cityRepo = new CityRepoImpl(fileName);
        CityServ cityServ = new CityServImpl(cityRepo);
        cityServ.printAllCities();
    }
}