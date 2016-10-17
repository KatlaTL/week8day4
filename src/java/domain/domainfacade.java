package domain;

import static databasepopulation.DatabasePopulation.randomBuildings;
import databasepopulation.domain.Building;
import java.util.List;

/**
 *
 * @author Asger
 */
public class domainfacade {
    
    
    public static List<Building> buildings(){
        return randomBuildings(100);
    }
}
