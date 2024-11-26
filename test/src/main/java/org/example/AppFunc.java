package org.example;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class AppFunc {
    public static void main(String[] args) {
        Consumer <String> consumer = (input) ->
        {
            System.out.println(input);
        };
        consumer.accept("hello");


        // pas de parametre mais retourne quelque chose
        Supplier<String> supplier = () -> "world";

        System.out.println(supplier.get());

        Function<Integer, Integer> function = x -> x * 2;

        System.out.println(function.apply(3));
    }
}
