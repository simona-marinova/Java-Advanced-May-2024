package reflection.excersiceDemo;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class personClass = Person.class;
        Field[] fields = personClass.getDeclaredFields();
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        Person person = (Person) constructor.newInstance("Ivan", 20);
        Method[] methods = personClass.getMethods();
        Method[] declaredMethods = personClass.getDeclaredMethods();
        Method getNameMethod = personClass.getDeclaredMethod("getName");
        getNameMethod.setAccessible(true);
        System.out.println(getNameMethod.invoke(person));
        Field nameField = personClass.getDeclaredField("age");
        nameField.setAccessible(true);
        System.out.println(nameField.get(person));
        int mask = nameField.getModifiers();
        System.out.println(Modifier.toString(mask));
    }

}
