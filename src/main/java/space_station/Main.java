package space_station;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.json.JSONArray;
import org.json.JSONObject;
import space_station.gui.Ui;
import space_station.model.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        File file1 = new File("API1.json");
        File file2 = new File("API2.json");
        File file3 = new File("human.json");

        String fileLoading = space_station.File.fileLoading(file1);
        String fileLoading2 = space_station.File.fileLoading(file2);
        String fileLoading3 = space_station.File.fileLoading(file3);

        String jsonString = fileLoading;
        JSONObject object = new JSONObject(jsonString);
        Long timestamp = object.getLong("timestamp");
        double longitude = object.getJSONObject("iss_position").getDouble("longitude");
        double latitude = object.getJSONObject("iss_position").getDouble("latitude");

        String jsonString2 = fileLoading2;
        JSONObject object2 = new JSONObject(jsonString2);
        long timestamp2 = object2.getLong("timestamp");
        double longitude2 = object2.getJSONObject("iss_position").getDouble("longitude");
        double latitude2 = object2.getJSONObject("iss_position").getDouble("latitude");

        String jsonString3 = fileLoading3;
        JSONObject object3 = new JSONObject(jsonString3);
        JSONArray array3 = object3.getJSONArray("people");
        List<Human> names = new ArrayList<>();


        for (int i = 0; i < array3.length() - 1; i++) {
            String name = array3.getJSONObject(i).getString("name");
            String craft = array3.getJSONObject(i).getString("craft");
            names.add(new Human(name, craft));
        }
        for (Human o : names) {
            System.out.println(o);
        }


//        Location location11 = location(ApplicationPropertiesProvider.getSpaceStationProperties(), timestamp, latitude, longitude);
//        Location location22 = location(ApplicationPropertiesProvider.getSpaceStationProperties(), timestamp2, latitude2, longitude2);

        List<Human> human = human(ApplicationPropertiesProvider.getSpaceStationProperties(), names);
        List<Human> humanList = (loadHumans(ApplicationPropertiesProvider.getSpaceStationProperties()));
//        System.out.println(HumanInSpaceCalculator.humanInSpace(loadHumans(ApplicationPropertiesProvider.getSpaceStationProperties())));
        List<Location> locationList = loadLocation(ApplicationPropertiesProvider.getSpaceStationProperties());
        CalculatorParamiters parameters = new CalculatorParamiters(locationList.get(0).getLocalTime(), locationList.get(1).getLocalTime(), locationList.get(0).getLatitude(), locationList.get(1).getLatitude(), locationList.get(0).getLongitude(), locationList.get(1).getLongitude());
        System.out.println(SpeedCalculator.speedCalculator(parameters));


        Ui ui = new Ui();
        int choice;
        do {
            ui.showMenu();
            choice = ui.getUserChoice();
            RequestHandler.userChoice(choice, parameters, humanList);

        } while (choice != 3);
    }


    public static Location location(Properties properties, long timestamp, double latitude, double longitude) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("spaceStationPU", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            final Location location = new Location(timestamp, latitude, longitude);
            entityManager.getTransaction().begin();
            entityManager.persist(location);
            entityManager.getTransaction().commit();
            return location;

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);

        } finally {
            entityManagerFactory.close();
        }
    }

    public static List<Human> human(Properties properties, List<Human> humans) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("spaceStationPU", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            humans.forEach(human -> entityManager.persist(human));
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);

        } finally {
            entityManagerFactory.close();
        }
        return humans;
    }

    public static List<Human> loadHumans(Properties properties) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("spaceStationPU", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Human> humans;
        try {
            TypedQuery<Human> typedQuery = entityManager.createQuery("""
                            FROM Human human WHERE human.craft = 'ISS'
                            """,
                    Human.class
            );
            humans = typedQuery.getResultList();

        } finally {
            entityManagerFactory.close();
        }
        return humans;
    }

    public static List<Location> loadLocation(Properties properties) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("spaceStationPU", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Location> locations;
        try {
            TypedQuery<Location> typedQuery = entityManager.createQuery("""
                            FROM Location location
                            """,
                    Location.class
            );
            locations = typedQuery.getResultList();

        } finally {
            entityManagerFactory.close();
        }
        return locations;
    }

}

