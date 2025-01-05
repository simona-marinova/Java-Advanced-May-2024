package reflection.thirdTask;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;
        Arrays.stream(clazz.getDeclaredFields()).
                filter(f -> !Modifier.isPrivate(f.getModifiers())).
                sorted(Comparator.comparing(Field::getName)).
                forEach(f -> System.out.printf("%s must be private!\n", f.getName()));

        Method[] declaredMethods = clazz.getDeclaredMethods();

        ArrayList<Method> getters = new ArrayList<>();
        ArrayList<Method> setters = new ArrayList<>();

        for (Method method : declaredMethods) {
            if (method.getName().contains("get")) {
                getters.add(method);
            } else if (method.getName().contains("set")) {
                setters.add(method);
            }
        }

        getters.stream().filter(g -> !Modifier.isPublic(g.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(g-> System.out.printf("%s have to be public!\n", g.getName()));

        setters.stream().filter(s->!Modifier.isPrivate(s.getModifiers())).
                sorted(Comparator.comparing(Method::getName)).
                forEach(s-> System.out.printf("%s have to be private!\n", s.getName()));
    }
}
