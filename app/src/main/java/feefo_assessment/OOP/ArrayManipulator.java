package feefo_assessment.OOP;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayManipulator {

    private int median;
    private float mean;
    private int mode;
    private int range;

    // Setters
    public void setMedian(int median){
        this.median = median;
    }
    public void setMean(float mean){
        this.mean = mean;
    }
    public void setMode(int mode){
        this.mode = mode;
    }
    public void setRange(int range){
        this.range = range;
    }

    // Getters
    public int getMedian(){
        return this.median;
    }
    public float getMean(){
        return this.mean;
    }
    public int getMode(){
        return this.mode;
    }
    public int getRange(){
        return this.range;
    }

    public void printStats(){
        System.out.println("Median of array: " + this.median);
        System.out.println("Mean of array: " + this.mean);
        System.out.println("Mode of array: " + this.mode);
        System.out.println("Range of array: " + this.range);
    }

    public void getStats(int[] input){
        
        calculateMedian(input);
        
        calculateMean(input);
           
        calculateMode(input);         
        
        calculateRange(input);
       
        //print stats
        this.printStats();
    }

    /**
     * Calculates the median of an array of int's
     * Median is the middle number of a set, so this get the middle number in the array when sorted from smallest to largest.
     * If the number of elements is even so there is no middle, then it returns the number to the right of the middle.
     * input array is cloned as to not mutate the input should it be needed in its original form elsewhere.
     * @param input array of int's
     */
    public void calculateMedian(int[] input) {
        // clone then sort the array
        int[] sorted = input.clone();
        Arrays.sort(sorted);

        int middleOfArray = (int) Math.ceil(sorted.length / 2); // might be a fraction so round up
        this.setMedian(sorted[middleOfArray]);
    }

    /**
     * Calculates the mean of an array of int's
     * Mean is the sum of a set divided by the number in the set
     * @param input array of int's
     */
    public void calculateMean(int[] input) {
        int sum = 0;

        for (int i : input) {
            sum = sum + i;
        }
        this.setMean(sum / input.length);
    }

    /**
     * Calculates the range of an array of int's
     * Range of a set is the difference between the smallest and highest numbers in the set.
     * input array is cloned as to not mutate the input should it be needed in its original form elsewhere.
     * @param input array of int's
     */
    public void calculateRange(int[] input) {
        // clone then sort the array
        int[] sorted = input.clone();
        Arrays.sort(sorted);

        int smallest = sorted[0];
        int largest = sorted[sorted.length - 1];
        this.setRange(largest - smallest);
    }
    
    /**
     * Calculates the mode of an array of int's
     * Mode of a set is the most frequent number in that set so group the array into a hashmap where the key is the number, value is the count.
     * @param input array of int's
     */
    public void calculateMode(int[] input) {
        int mostFrequentValueCount = 0;
        
        HashMap<Integer,Integer> groupedOccurencesMap = new HashMap<Integer,Integer>();
        for (int i : input) {
            if(groupedOccurencesMap.containsKey(i)){
                int occurencesOfKey = groupedOccurencesMap.get(i) + 1;
                groupedOccurencesMap.put(i, occurencesOfKey);
                
                // check if this value is the new highest
                if (occurencesOfKey > mostFrequentValueCount){
                    this.setMode(i);
                    mostFrequentValueCount = occurencesOfKey;
                }
            } else {
                groupedOccurencesMap.put(i ,1);
            }
        }
    }
}
