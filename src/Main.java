
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=  new Scanner(new File("Задача ВС Java Сбер.csv"));
        ArrayList<City> cities = new ArrayList<>();
        while (sc.hasNextLine()){

            String[] disrib = sc.nextLine().split(";");
            if (disrib.length != 6){
                cities.add(new City(disrib[1], disrib[2], disrib[3], Integer.parseInt(disrib[4])));
            }
            else {
                cities.add(new City(disrib[1], disrib[2], disrib[3], Integer.parseInt(disrib[4]), disrib[5]));
            }



        }
        System.out.println(cities);
    }


}
class City{

    private String nameCity;
    private String region;
    private String district;
    private int population;
    private String  foundation;
    public City(String nameCity, String region, String district, int population, String foundation) {
        this.nameCity = nameCity;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }
    public City(String nameCity, String region, String district, int population) {
        this(nameCity, region, district, population, "unknown");
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }



    public String getNameCity() {
        return nameCity;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public String getFoundation() {
        return foundation;
    }


    @Override
    public String toString() {
        return String.format("City{name='%s', region='%s', district='%s', population=%d, foundation='%s'}", nameCity, region, district, population, foundation);
    }
}
