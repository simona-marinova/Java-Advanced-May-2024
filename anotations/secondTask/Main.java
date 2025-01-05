package anotations.secondTask;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    @Author(name = "George")
    public static void main(String[] args) {
        print(Main.class);
    }

    @Author(name = "Pesho")
    public static void print(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            Author annotation = method.getAnnotation(Author.class);
            System.out.println(annotation.name() + ": " + method.getName());
        }
    }

}
