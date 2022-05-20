package feefo_assessment.OOP;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayManipulatorTest {

    int[] testArray;
    ArrayManipulator arrayManipulator;

    @BeforeEach
    void setup() {
        testArray = new int[] {1, 5, 4, 2, 6, 3, 0};

        arrayManipulator = new ArrayManipulator();
    }

    @Test
    void calculateMedianSetsMedianWhenArrayOddLength() {
        double expected = 3;

        var actual = arrayManipulator.calculateMedian(testArray);

        assertEquals(expected, actual);
    }

    @Test
    void calculateMedianSetsMedianWhenArrayEvenLength() {
        int[] evenLengthArray = new int[] {0, 1, 2, 3, 4, 5};
        double expected = 2.5;

        var actual = arrayManipulator.calculateMedian(evenLengthArray);

        assertEquals(expected, actual);
    }

    @Test
    void calculateMedianWorkWithUnorderedInput() {
        double expected = 3;

        var actual = arrayManipulator.calculateMedian(testArray);

        assertEquals(expected, actual);
    }

    @Test
    void calculateMedianDoesNotMutateInput() {
        int[] expected = testArray.clone();

        arrayManipulator.calculateMedian(testArray);

        assertArrayEquals(expected, testArray);
    }

    @Test
    void calculateMeanSetsMeanWhenValidInput() {
        int expected = 3;

        var actual = arrayManipulator.calculateMean(testArray);

        assertEquals(expected, actual);

    }

    @Test
    void calculateRangeSetsRangeWhenValidInput() {
        int expected = 6;

        var actual = arrayManipulator.calculateRange(testArray);

        assertEquals(expected, actual);
    }

    @Test
    void calculateRangeDoesNotMutateInput() {
        int[] expected = testArray.clone();

        arrayManipulator.calculateRange(testArray);

        assertArrayEquals(expected, testArray);
    }

    @Test
    void calculateModeSetsModeWhenValidInput() {
        int[] arrayWithRepeats = new int[] {0, 1, 2, 3, 4, 4, 5, 6};
        int expected = 4;

        var actual = arrayManipulator.calculateMode(arrayWithRepeats);

        assertEquals(expected, actual.get(0));
    }

    @Test
    void calculateModeReturnsMoreThanOneModeIfThereIsMoreThanOneMode() {
        int[] triModalArray = new int[] {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4};
        int expectedLength = 3;
        List<Integer> expectedList = List.of(1, 2, 3);

        var actual = arrayManipulator.calculateMode(triModalArray);

        assertEquals(expectedLength, actual.size());
        assertEquals(expectedList, actual);
    }

    @Test
    void calculateModeReturnsNullWhenNoOutlier() {

        var actual = arrayManipulator.calculateMode(testArray);

        assertNull(actual);
    }

}
