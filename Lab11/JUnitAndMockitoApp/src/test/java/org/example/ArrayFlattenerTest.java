package org.example;


import org.example.ArrayFlattener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayFlattenerTest {
    private ArrayFlattener flattener;

    @Before
    public void setUp() {
        flattener = new ArrayFlattener();
    }

    @After
    public void tearDown() {
        flattener = null;
    }
    @Test
    public void testFlattenArrayValidInput() {
        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {1, 3, 0, 4, 5, 9};
        assertArrayEquals(expectedOutput, flattener.flattenArray(inputArray));
    }

    @Test
    public void testFlattenArrayNullInput() {
        int[][] inputArray = null;
        int[] expectedOutput = new int[]{};
        assertArrayEquals(expectedOutput, flattener.flattenArray(inputArray));
    }


}