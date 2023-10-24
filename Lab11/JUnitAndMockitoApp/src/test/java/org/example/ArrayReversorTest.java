package org.example;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayReversorTest extends TestCase {

    private ArrayReversor reverser;
    private ArrayFlattener flattenerService;

    @Before
    public void setUp() {
        flattenerService = mock(ArrayFlattener.class);
        reverser = new ArrayReversor(flattenerService);
    }

    @After
    public void tearDown() {
        reverser = null;
    }
    @Test
    public void testReverseArrayValidInput() {
        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};
        int[] flattenedArray = {1, 3, 0, 4, 5, 9};
        int[] expectedOutput = {9, 5, 4, 0, 3, 1};

        when(flattenerService.flattenArray(inputArray)).thenReturn(flattenedArray);

        int[] result = reverser.reverseArray(inputArray);

        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testReverseArrayNullInput() {
        int[][] inputArray = null;
        int[] expectedOutput = new int[]{};

        int[] result = reverser.reverseArray(inputArray);

        assertArrayEquals(expectedOutput, result);
    }
}