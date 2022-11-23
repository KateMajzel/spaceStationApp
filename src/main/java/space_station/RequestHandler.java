package space_station;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import space_station.model.CalculatorParamiters;
import space_station.model.Human;
import space_station.model.HumanInSpaceCalculator;
import space_station.model.SpeedCalculator;
import java.util.List;

public class RequestHandler {
    public static void userChoice(int userChoice, CalculatorParamiters calculatorParamiters, List<Human> humanList) {


        switch (userChoice) {
            case 1:
                System.out.println("Now, speed is " + SpeedCalculator.speedCalculator(calculatorParamiters));
                break;
            case 2:
                System.out.println("Now, in space are " + HumanInSpaceCalculator.humanInSpace(humanList) + " persons");
                break;
            case 3:
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("spaceStationPU", ApplicationPropertiesProvider.getSpaceStationProperties());
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                try {
                    entityManager.getTransaction().begin();
                    entityManager.createQuery("""
                            DELETE FROM Human
                            """
                    ).executeUpdate();
                    entityManager.getTransaction().commit();
                } finally {
                    entityManagerFactory.close();
                }

        }
    }
}

