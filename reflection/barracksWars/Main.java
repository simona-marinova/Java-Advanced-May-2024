package reflection.barracksWars;

import reflection.barracksWars.interfaces.Repository;
import reflection.barracksWars.interfaces.Runnable;
import reflection.barracksWars.interfaces.UnitFactory;
import reflection.barracksWars.core.Engine;
import reflection.barracksWars.core.factories.UnitFactoryImpl;
import reflection.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
