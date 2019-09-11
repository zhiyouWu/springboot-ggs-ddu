package top.flygrk.ishare.springbootswagger.stream.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Package top.flygrk.ishare.springbootswagger.stream.practice
 * @Author wuzy@watone.com.cn
 * @Date 2019/8/6 10:52
 * @Version V1.0
 * @Description:
 */
public class AssertMapStream {

    public static void main(String[] args) {

        oldMap();
        newMap();


    }

    private static void oldMap() {
        List<String> collected = new ArrayList <>();
        for (String string : Arrays.asList("a", "b", "hello")) {
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }

        for (String str : collected) {
            System.out.println("old: " + str);
        }
    }

    private static void newMap() {
        List<String> collected = Stream.of("a", "b", "hello")
                .map(str -> str.toUpperCase())
                .collect(Collectors.toList());

        for (String str : collected) {
            System.out.println("new: " + str);
        }

    }

}
