package listUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers =new ArrayList<>();
        System.out.println(ListUtils.getMax(numbers));
        System.out.println(ListUtils.getMin(numbers));

    }
}
