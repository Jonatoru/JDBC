import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Hibernate_EntityManagerFactory {
    private static EntityManagerFactory entityManagerFactory;
    private Hibernate_EntityManagerFactory() {}

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

                } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return entityManagerFactory;
    }
}
