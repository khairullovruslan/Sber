
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=  new Scanner(new File("Задача ВС Java Сбер.csv"));
        List<City> cities = new ArrayList<>();
        while (sc.hasNextLine()){

            String[] disrib = sc.nextLine().split(";");
            if (disrib.length != 6){
                cities.add(new City(disrib[1], disrib[2], disrib[3], Integer.parseInt(disrib[4])));
            }
            else {
                cities.add(new City(disrib[1], disrib[2], disrib[3], Integer.parseInt(disrib[4]), disrib[5]));
            }

        }
        System.out.println(getMaxPopulation(cities));
        sortByName(cities);
        for(int i = 0; i < 10; i++) {
            System.out.println(cities.get(i));
        }

        System.out.println();

        sortingByFederalDistrictAndCityName(cities);
        for(int i = 0; i < 10; i++){
            System.out.println(cities.get(i));
        }


        // lambda
        //cities.sort(City::compareTo);





    }

    public  static  City getMaxPopulation(List<City> cities){
        City cityWithMaxPop  = cities.get(0);
        for (int i = 1; i < cities.size(); i++){
            if (cities.get(i).getPopulation() > cityWithMaxPop.getPopulation()){
                cityWithMaxPop = cities.get(i);
            }
        }
        return cityWithMaxPop;

    }

    public  static void sortByName(List<City> cities){
        cities.sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                if (o1.getNameCity().toLowerCase().compareTo(o2.getNameCity().toLowerCase()) > 0){
                    return 1;
                }
                else  if((o1.getNameCity().toLowerCase().compareTo(o2.getNameCity().toLowerCase()) < 0)){
                    return  -1;
                }
                return 0;
            }
        });
    }
    public  static void sortingByFederalDistrictAndCityName(List<City> cities){
        cities.sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                if (o1.getDistrict().compareTo(o2.getDistrict())  ==  0){
                    return o1.getNameCity().compareTo(o2.getNameCity());
                }
                else  if(o1.getDistrict().compareTo(o2.getDistrict()) < 0){
                    return  -1;
                }
                return  1;
            }

        }
        );
    }



}
class City implements  Comparable{

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


    // Sort № 1
//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof City city){
//            return nameCity.toLowerCase().compareTo(city.getNameCity().toLowerCase());
//        }
//        throw new RuntimeException();
//
//    }

    // Sort 2
    @Override
    public int compareTo(Object o) {
        if (o instanceof City city) {
            if  (district.compareTo(city.getDistrict()) == 0){
                return nameCity.compareTo(city.getNameCity());
            }
            else {
                return  district.compareTo(city.getDistrict());
            }
        }
        throw new RuntimeException();
    }
}
