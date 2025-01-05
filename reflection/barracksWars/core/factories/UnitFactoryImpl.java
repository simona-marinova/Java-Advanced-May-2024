package reflection.barracksWars.core.factories;

import reflection.barracksWars.interfaces.Unit;
import reflection.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;
import reflection.barracksWars.models.units.Archer;
import reflection.barracksWars.models.units.Pikeman;
import reflection.barracksWars.models.units.Swordsman;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"reflection.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		// TODO: implement for problem 3
        try {
            Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> declaredConstructor = unitClass.getDeclaredConstructor();
return declaredConstructor.newInstance();

		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
