import java.util.List;

public interface CityDAO {
    List<City> gerAllCity();
    City getCityById(int id);
    void createCity(City city, int id);
    void deleteCity(City city);
    Integer addCity(City city);
}
