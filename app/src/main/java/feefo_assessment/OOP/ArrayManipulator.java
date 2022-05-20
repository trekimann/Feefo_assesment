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
        
        // sort the array
        Arrays.sort(input);

        int inputLength = input.length;
        // Median is the middle number of a set, so just get the middle number in the array
        int middleOfArray = (int) Math.ceil(inputLength / 2); // might be a fraction so round up
        this.setMedian(input[middleOfArray]);
        
        // Mean is the sum of a set divided by the number in the set
        int sum = 0;

        for (int i : input) {
            sum = sum + i;
        }
        this.setMean(sum / inputLength);
           
        // Mode of a set is the most frequent number in that set so group the array into a hashmap where the key is the number, value is the count.
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
         
        
        // Range of a set is the difference between the smallest and highest numbers in the set. Subtract the first element of the array from the last.
        int smallest = input[0];
        int largest = input[inputLength-1];
        this.setRange(largest - smallest);
       
        //print stats
        this.printStats();
    }
}
