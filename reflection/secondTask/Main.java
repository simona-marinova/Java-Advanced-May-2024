package reflection.secondTask;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> clazz = Reflection.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods).
                filter(m -> !m.getName().contains("toString")).sorted(Comparator.comparing(Method::getName)).
                map(Main::toString).forEach(System.out::println);

    }

    private static String toString(Method m) {
        if(m.getName().contains("get")){
            return String.format("%s will return class %s", m.getName(),m.getReturnType().getName());
        }
        return String.format("%s and will set field of class %s", m.getName(), m.getParameterTypes()[0].getName());
    }
}

