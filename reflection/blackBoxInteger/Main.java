package reflection.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = blackBoxIntClass.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Object object = constructor.newInstance(0);


        while (!command.equals("END")) {
            String[] commands = command.split("_");
            String instruction = commands[0];
            int number = Integer.parseInt(commands[1]);
            Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
            innerValue.setAccessible(true);

            switch (instruction) {
                case "add":
                    Method add = blackBoxIntClass.getDeclaredMethod("add", int.class);
                    add.setAccessible(true);
                    add.invoke(object, number);
                    System.out.println(innerValue.get(object));
                    break;
                case "subtract":
                    Method subtract = blackBoxIntClass.getDeclaredMethod("subtract", int.class);
                    subtract.setAccessible(true);
                    subtract.invoke(object, number);
                    System.out.println(innerValue.get(object));
                    break;
                case "multiply":
                    Method multiply = blackBoxIntClass.getDeclaredMethod("multiply", int.class);
                    multiply.setAccessible(true);
                    multiply.invoke(object, number);
                    System.out.println(innerValue.get(object));
                    break;
                case "divide":
                    Method divide = blackBoxIntClass.getDeclaredMethod("divide", int.class);
                    divide.setAccessible(true);
                    divide.invoke(object, number);
                    System.out.println(innerValue.get(object));
                    break;
                case "leftShift":
                    Method leftShift = blackBoxIntClass.getDeclaredMethod("leftShift", int.class);
                    leftShift.setAccessible(true);
                    leftShift.invoke(object, number);
                    System.out.println(innerValue.get(object));
                    break;
                case "rightShift":
                    Method rightShift = blackBoxIntClass.getDeclaredMethod("rightShift", int.class);
                    rightShift.setAccessible(true);
                    rightShift.invoke(object, number);
                    System.out.println(innerValue.get(object));
                    break;

            }

            command = scanner.nextLine();
        }
    }
}
