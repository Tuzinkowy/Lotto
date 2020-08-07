package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Integer[] array = new Integer[49];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.println(Arrays.toString(array));
        Collections.shuffle(Arrays.asList(array));
        System.out.println(Arrays.toString(array));
    }
}
