package reflection.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
        Field[] declaredFields = richSoilLandClass.getDeclaredFields();
        List<Field> privateFields = new ArrayList<>();
        List <Field> protectedFields = new ArrayList<>();

        for (Field field : declaredFields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field);
            }
            else if(Modifier.isProtected(field.getModifiers())){
                protectedFields.add(field);
            }

        }

        String command = scanner.nextLine();
        while (!command.equals("HARVEST")) {
            switch (command) {
                case "private":
                    for (Field field : privateFields) {
                        System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
                    }
                    break;
                case "protected":
                    for (Field protectedField : protectedFields) {
                        System.out.println(Modifier.toString(protectedField.getModifiers()) + " " + protectedField.getType().getSimpleName() + " " + protectedField.getName());
                    }
                    break;
                case "public":
                    for (Field field : richSoilLandClass.getFields()) {
                        System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
                    }
                    break;
                case "all":
                    for (Field declaredField : declaredFields) {
                        System.out.println(Modifier.toString(declaredField.getModifiers()) + " " + declaredField.getType().getSimpleName() + " " + declaredField.getName());
                    }
                    break;
            }


            command = scanner.nextLine();

        }

    }
}
