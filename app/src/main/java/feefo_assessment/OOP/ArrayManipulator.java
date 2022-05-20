package feefo_assessment.OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayManipulator {

    private double median;
    private double mean;
    private List<Integer> modes;
    private int range;

    // Setters
    public void setMedian(double median) {
        this.median = median;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public void setModes(List<Integer> modes) {
        this.modes = modes;
    }

    public void setRange(int range) {
        this.range = range;
    }

    // Getters
    public double getMedian() {
        return this.median;
    }

    public double getMean() {
        return this.mean;
    }

    public List<Integer> getModes() {
        return this.modes;
    }

    public int getRange() {
        return this.range;
    }

    public void printStats() {
        System.out.println("Median of array: " + this.median);
        System.out.println("Mean of array: " + this.mean);

        if (this.modes.size() > 1) {
            int numberOfModes = this.modes.size();
            System.out.println("There are " + numberOfModes + "modes. They are:");
            for (Integer mode : modes) {
                System.out.println(mode);
            }
        } else {
            System.out.println("Mode of array: " + this.modes.get(0));
        }
        System.out.println("Range of array: " + this.range);
    }

    /**
     * Calculates the Median, Mean, Mode and range for an int array then prints the values to the
     * console
     * 
     * @param input an array of int's
     */
    public void getStats(int[] input) {

        this.setMedian(calculateMedian(input));

        this.setMean(calculateMean(input));

        this.setModes(calculateMode(input));

        this.setRange(calculateRange(input));

        // print stats
        this.printStats();
    }

    /**
     * Calculates the median of an array of int's Median is the middle number of a set, so this get
     * the middle number in the array when sorted from smallest to largest. If there is an even
     * number of items in the set, there will be two numbers in the middle. The median is the number
     * that is half way between these two numbers. input array is cloned as to not mutate the input
     * should it be needed in its original form elsewhere.
     * 
     * @param input array of int's
     * @return a double of the median
     */
    public double calculateMedian(int[] input) {
        // clone then sort the array
        int[] sorted = input.clone();
        Arrays.sort(sorted);
        int middleOfArray = (int) Math.ceil(sorted.length / 2); // could be a fraction so round up
        double toReturn;
        if (sorted.length % 2 == 0) {
            // if even number of elements then the median is the number between the 2 bits in the
            // middle
            double above = sorted[middleOfArray];
            double below = sorted[middleOfArray - 1];;
            toReturn = ((above + below) / 2);
        } else {
            toReturn = (sorted[middleOfArray]);
        }
        return toReturn;
    }

    /**
     * Calculates the mean of an array of int's Mean is the sum of a set divided by the number in
     * the set
     * 
     * @param input array of int's
     */
    public double calculateMean(int[] input) {
        int sum = 0;

        for (int i : input) {
            sum = sum + i;
        }
        return (sum / input.length);
    }

    /**
     * Calculates the range of an array of int's Range of a set is the difference between the
     * smallest and highest numbers in the set. input array is cloned as to not mutate the input
     * should it be needed in its original form elsewhere.
     * 
     * @param input array of int's
     */
    public int calculateRange(int[] input) {
        // clone then sort the array
        int[] sorted = input.clone();
        Arrays.sort(sorted);

        int smallest = sorted[0];
        int largest = sorted[sorted.length - 1];
        return (largest - smallest);
    }

    /**
     * Calculates the mode of an array of int's Mode of a set is the most frequent number in that
     * set. As there is a chance of more than one mode, a list is returned. returns null if there is
     * an even distribution of all values.
     * 
     * @param input array of int's
     * @return Integer list of modes.
     */
    public List<Integer> calculateMode(int[] input) {
        int mostFrequentValueCount = 0;
        HashMap<Integer, Integer> groupedOccurencesMap = new HashMap<Integer, Integer>();
        for (int i : input) {
            if (groupedOccurencesMap.containsKey(i)) {
                int occurencesOfKey = groupedOccurencesMap.get(i) + 1;
                groupedOccurencesMap.put(i, occurencesOfKey);

                // check if this value is the new highest
                if (occurencesOfKey > mostFrequentValueCount) {
                    mostFrequentValueCount = occurencesOfKey;
                }
            } else {
                groupedOccurencesMap.put(i, 1);
            }
        }

        if (mostFrequentValueCount == 0) {
            return null;
        }

        // now its all grouped, check if there is more than one mode
        List<Integer> multiModes = new ArrayList<Integer>();
        if (groupedOccurencesMap.containsValue(mostFrequentValueCount)) {
            for (Map.Entry<Integer, Integer> entry : groupedOccurencesMap.entrySet()) {
                if (entry.getValue() == mostFrequentValueCount) {
                    multiModes.add(entry.getKey());
                }
            }
        }
        return multiModes;
    }
}
