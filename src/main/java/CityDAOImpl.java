import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityDAOImpl implements CityDAO{
    @Override
    public List<City> gerAllCity() {
        EntityManager entityManager = Hibernate_EntityManagerFactory.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        String jpqlQuery = "FROM City";
        TypedQuery<City> query = entityManager.createQuery(jpqlQuery, City.class);
        List<City> CityList = query.getResultList();
        entityManager.close();
        return CityList;
    }

    @Override
    public City getCityById(int id) {
        EntityManager entityManager = Hibernate_EntityManagerFactory.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        City city = entityManager.find(City.class, id);
        entityManager.close();
        return city;
    }

    @Override
    public void createCity(City city, int id) {
        EntityManager entityManager = Hibernate_EntityManagerFactory.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.find(City.class, id);
        city.setEmployees(city.getEmployees());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteCity(City city) {
        EntityManager entityManager = Hibernate_EntityManagerFactory.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        city = entityManager.find(City.class, city.getCityId());
        entityManager.remove(city);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Integer addCity(City city) {
        EntityManager entityManager = Hibernate_EntityManagerFactory.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
        entityManager.close();
        return city.getCityId();
    }
}
