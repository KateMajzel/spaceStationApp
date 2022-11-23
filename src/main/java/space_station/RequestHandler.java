package space_station;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RequestHandler {

    public static void userChoice(int userChoice, CalculatorParamiters calculatorParamiters, List<Human> humanList) {


        switch (userChoice) {
            case 1:
                System.out.println(SpeedCalculator.speedCalculator(calculatorParamiters));
                break;
            case 2:
                System.out.println(HumanInSpaceCalculator.humanInSpace(humanList));
                break;
            case 3:
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("spaceStationPU", ApplicationPropertiesProvider.getSpaceStationProperties());
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                try {
                    entityManager.getTransaction().begin();
                    entityManager.createQuery("""
                                    DELETE FROM Human
                                    """
                    ) .executeUpdate();
                    entityManager.getTransaction().commit();
                } finally {
                    entityManagerFactory.close();
                }

        }
    }
}

