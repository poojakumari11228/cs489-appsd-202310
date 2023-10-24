package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayFlattener {
    public int[] flattenArray(int[][] inputArray) {
        if (inputArray == null) {
            return new int[]{};
        }

        return Arrays.stream(inputArray)
                .flatMapToInt(Arrays::stream)
                .toArray();

    }
}
