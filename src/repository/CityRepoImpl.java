package repository;

import model.City;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CityRepoImpl implements CityRepo {
    private final List<City> cities = new ArrayList<>();

    public CityRepoImpl(String fileName) {
        try (Scanner myCSVScanner = new Scanner(Paths.get(fileName))) {
            myCSVScanner.useDelimiter(System.lineSeparator());
            while (myCSVScanner.hasNext()) {
                cities.add(parseCSVLineToCity(myCSVScanner.next()));
            }
        } catch (NoSuchFileException e) {
            System.out.println(MessageFormat.format("File {0} not found.", fileName));
        } catch (IOException e) {
            System.out.println(MessageFormat.format("Other error: {0}.", e.getMessage()));
        }
    }

    private City parseCSVLineToCity(String csvLine) {
        Scanner myLineScanner = new Scanner(csvLine);
        myLineScanner.useDelimiter(";");
        myLineScanner.skip("\\d*");
        String name = myLineScanner.hasNext() ? myLineScanner.next() : "";
        String region = myLineScanner.hasNext() ? myLineScanner.next() : "";
        String district = myLineScanner.hasNext() ? myLineScanner.next() : "";
        int population = myLineScanner.hasNext() ? myLineScanner.nextInt() : 0;
        String foundation = myLineScanner.hasNext() ? myLineScanner.next().replaceAll(String.valueOf((char) 13), "") : "";
        return new City(name, region, district, population, foundation);
    }

    @Override
    public List<City> getAllCities() {
        return cities;
    }

    @Override
    public List<City> sortCitiesByName() {
        //List<Word> sortedWords = words.stream()
        //    .sorted(Comparator.comparing(w -> countLetter(w, 'a')))
        //    .collect(Collectors.toList());
        return cities.stream()
                .sorted(Comparator.comparing(city -> city.getName().toLowerCase()))
                .toList();
    }

    @Override
    public List<City> sortCitiesByDistrictAndName() {
        return cities.stream()
                .sorted(Comparator.comparing(City::getDistrict).thenComparing(City::getName))
                .toList();
    }
}