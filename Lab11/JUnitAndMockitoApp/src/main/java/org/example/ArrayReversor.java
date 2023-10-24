package org.example;

import java.util.Arrays;

public class ArrayReversor {
    public ArrayFlattener flattenerService;

    public ArrayReversor(ArrayFlattener flattenerService) {
        this.flattenerService = flattenerService;
    }

    public int[] reverseArray(int[][] inputArray) {
        if (inputArray == null) {
            return new int[]{};
        }

        int[] flattenedArray = flattenerService.flattenArray(inputArray);
        int[] reversedArray = new int[flattenedArray.length];

        for (int i = 0; i < flattenedArray.length; i++) {
            reversedArray[i] = flattenedArray[flattenedArray.length - 1 - i];
        }

        return reversedArray;
    }
}
